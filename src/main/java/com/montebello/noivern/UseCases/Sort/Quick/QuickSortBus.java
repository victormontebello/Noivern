package com.montebello.noivern.UseCases.Sort.Quick;

import com.montebello.noivern.core.Enums.Complexity;
import com.montebello.noivern.core.Interface.IAlgorithm;
import com.montebello.noivern.core.models.Algorithm;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class QuickSortBus implements IAlgorithm {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    @SneakyThrows
    @Override
    public Algorithm getAlgorithm(){
        Algorithm algorithm = new Algorithm();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/montebello/noivern/core/Resources/quick-sort-images.jpeg"));
        algorithm.Name = "Quick Sort";
        algorithm.Description = "Quick Sort is a highly efficient sorting algorithm and is based on partitioning of array of data into smaller arrays.";
        algorithm.TimeComplexity = Complexity.NlogN;
        algorithm.MemoryComplexity = Complexity.LogN;
        algorithm.ImageUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20240925173636/quick-sort--images.webp";
        algorithm.ImageContent = reader.lines().toString().getBytes();
        return algorithm;
    }
}
