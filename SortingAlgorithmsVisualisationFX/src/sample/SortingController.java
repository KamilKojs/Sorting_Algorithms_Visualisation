package sample;

import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingController extends BorderPane {
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 500;
    public static final int xGap = 5;
    public static final int BUTTONROW_BOUNDARY = 100;

    public static int numberOfRecords = 109;
    public static int range = 450;

    private Pane display;
    private VBox buttonColumn;

    private Button sortButton;
    private Button randomiseArrayOfRecordsButton;
    private ChoiceBox<AbstractSort> choiceBox;

    private Record[] arrayOfRecords;
    private AbstractSort abstractSort;

    public SortingController(){
        this.display = new Pane();
        this.buttonColumn = new VBox();
        buttonColumn.setPrefWidth(100.0);

        this.setCenter(display);
        this.setLeft(buttonColumn);

        //creating buttons
        this.sortButton = new Button("Sort");
        sortButton.setMinWidth(buttonColumn.getPrefWidth());
        this.randomiseArrayOfRecordsButton = new Button("Randomise");
        randomiseArrayOfRecordsButton.setMinWidth(buttonColumn.getPrefWidth());
        this.choiceBox = new ChoiceBox<>();
        choiceBox.setMinWidth(buttonColumn.getPrefWidth());

        List<AbstractSort> abstractSortList = new ArrayList<>();
        abstractSortList.add(new SelectionSort());
        abstractSortList.add(new InsertionSort());
        abstractSortList.add(new MergeSort());

        choiceBox.getSelectionModel().select(1);

        //buttons on click actions
        randomiseArrayOfRecordsButton.setOnAction(click -> {  this.arrayOfRecords = RandomRecords.randomiseRecords(numberOfRecords, range);
                                                        display.getChildren().clear();
                                                        display.getChildren().addAll(Arrays.asList(arrayOfRecords));
                                                    });

        sortButton.setOnAction(click -> {
            sortButton.setDisable(true);
            randomiseArrayOfRecordsButton.setDisable(true);

            abstractSort = choiceBox.getSelectionModel().getSelectedItem();

            SequentialTransition sq = new SequentialTransition();

            sq.getChildren().addAll(abstractSort.sort(arrayOfRecords));

            sq.setOnFinished(e -> {
                randomiseArrayOfRecordsButton.setDisable(false);
                sortButton.setDisable(false);
            });

            sq.play();

        });
        //adding buttons to vBox
        buttonColumn.getChildren().add(sortButton);
        buttonColumn.getChildren().add(randomiseArrayOfRecordsButton);
        buttonColumn.getChildren().add(choiceBox);

        this.arrayOfRecords = RandomRecords.randomiseRecords(numberOfRecords, range);

        buttonColumn.setAlignment(Pos.BASELINE_LEFT);

        for (Node b : buttonColumn.getChildren()) {
            buttonColumn.setMargin(b, new Insets(0, 5, 3, 5));
        }

        display.getChildren().addAll(Arrays.asList(arrayOfRecords));

        choiceBox.setItems(FXCollections.observableArrayList(
                abstractSortList
        ));

        choiceBox.setConverter(new StringConverter<AbstractSort>() {
            @Override
            public String toString(AbstractSort abstractSort) {
                if(abstractSort == null) {
                    return "";
                } else {
                    return abstractSort.getClass().getSimpleName();
                }
            }

            @Override
            public AbstractSort fromString(String s) {
                return null;
            }
        });
    }
}
