package io.galaag.dsa.sorting;

import org.springframework.stereotype.Component;

@Component
public class Sorting {

    /**
     * Insertion sort algorithm, time complexity O(n^2)
     * @param array to bo sorted
     * @param descending if true, array will be ordered in reverse order
     * @return a sorted array
     */
    public int[] insertionSort(int[] array, boolean descending) {
        if (array.length <= 1)
            return array;

        for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) {
            int currentElement = array[unsortedIndex];
            int previousIndex = unsortedIndex - 1;

            while (previousIndex >= 0 && ((!descending && array[previousIndex] > currentElement) || (descending && array[previousIndex] < currentElement))) {
                array[previousIndex + 1] = array[previousIndex];
                previousIndex--;
            }

            array[previousIndex + 1] = currentElement;
        }

        return array;
    }
}
