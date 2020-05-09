package sample;

import javafx.animation.Transition;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort extends AbstractSort {

    @Override
    public List<Transition> sort(Record[] array){
        List<Transition> transitions = new ArrayList<>();

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i].getValue();
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j].getValue() > key) {
                transitions.add(swap(array, j+1, j));
                j = j - 1;
            }
        }
        return transitions;
    }
}
