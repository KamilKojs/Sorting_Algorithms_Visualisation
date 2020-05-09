package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;

import java.util.ArrayList;
import java.util.List;

public class MergeSort extends AbstractSort {
    private Record[] tmp;

    @Override
    public List<Transition> sort(Record[] array){
        ArrayList<Transition> transitions = new ArrayList<>();
        this.tmp = new Record[array.length];
        transitions.addAll(mergeSort(array, 0, array.length - 1));
        return transitions;
    }

    private ArrayList<Transition> merge(Record[] arr, int p, int q, int r) {
        ArrayList<Transition> transitions = new ArrayList<>();

        List<Record> tmpList = new ArrayList<>();

        for (int i = p; i <= r; i++) {
            tmp[i] = arr[i];
            tmpList.add(tmp[i]);
        }

        int i = p;
        int j = q + 1;
        int k = p;

        while (i <= q && j <= r) {
            if (tmp[i].getValue() <= tmp[j].getValue()) {
                arr[k++] = tmp[i++];
            } else {
                arr[k++] = tmp[j++];
            }
        }

        while (i <= q) {
            arr[k++] = tmp[i++];
        }

        while (j <= r) {
            arr[k++] = tmp[j++];
        }

        ParallelTransition pt = new ParallelTransition();

        for (int x = p; x <= r; x++) {
            for (int y = p; y <= r; y++) {
                if (tmp[x].equals(arr[y])) {
                    pt.getChildren().add(tmp[x].moveToX(DX * (y - x)));
                }
            }
        }

        transitions.add(pt);

        return transitions;
    }

    private ArrayList<Transition> mergeSort(Record[] arr, int p, int r) {
        ArrayList<Transition> transitions = new ArrayList<>();

        if (p < r) {
            int q = (p + r) / 2;
            transitions.addAll(mergeSort(arr, p, q));
            transitions.addAll(mergeSort(arr, q + 1, r));
            transitions.addAll(merge(arr, p, q, r));
        }

        return transitions;
    }


}
