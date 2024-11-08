package com.montebello.noivern.UseCases.Sort.Bubble;

import com.montebello.noivern.core.Enums.Complexity;
import com.montebello.noivern.core.Interface.IAlgorithm;
import com.montebello.noivern.core.models.Algorithm;

public class BubbleSortBus implements IAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    public Algorithm getAlgorithm() {
        Algorithm algorithm = new Algorithm();
        algorithm.Name = "Bubble Sort";
        algorithm.Description = "Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.";
        algorithm.TimeComplexity = Complexity.ON2;
        algorithm.MemoryComplexity = Complexity.O1;
        algorithm.ImageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif";
        return algorithm;
    }
}
