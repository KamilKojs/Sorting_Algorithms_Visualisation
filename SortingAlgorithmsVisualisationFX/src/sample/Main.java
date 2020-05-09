package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Sorting Algorithms");

        SortingController sortingController = new SortingController();

        primaryStage.setScene(new Scene(sortingController, sortingController.WINDOW_WIDTH, sortingController.WINDOW_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
