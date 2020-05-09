package sample;

import javafx.animation.Transition;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort extends AbstractSort{

    @Override
    public List<Transition> sort(Record[] array) {
        List<Transition> transitions = new ArrayList<>();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j].getValue() < array[min_idx].getValue())
                    min_idx = j;
            }

            // Swap the found minimum element with the first
            // element
            transitions.add(swap(array, i, min_idx));
        }
        return transitions;
    }

}
