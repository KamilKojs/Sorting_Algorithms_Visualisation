package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import java.util.List;

public abstract class AbstractSort {
    static int DX = (SortingController.WINDOW_WIDTH - SortingController.BUTTONROW_BOUNDARY) / SortingController.numberOfRecords;

    public abstract List<Transition> sort(Record[] array);

    ParallelTransition swap(Record[] array, int i, int j) {
        ParallelTransition pt = new ParallelTransition();

        int dxFactor = j - i;

        pt.getChildren().addAll(array[i].moveToX(DX * dxFactor), array[j].moveToX(-DX * dxFactor));

        Record tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        return pt;
    }
}
