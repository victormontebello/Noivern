package com.montebello.noivern.UseCases.BinarySearch;

import com.montebello.noivern.core.Enums.Complexity;
import com.montebello.noivern.core.Interface.IAlgorithm;
import com.montebello.noivern.core.models.Algorithm;

public class BinarySearchBus implements IAlgorithm {
    public int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) {
                return m;
            }
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    @Override
    public Algorithm getAlgorithm() {
        Algorithm algorithm = new Algorithm();
        algorithm.Name = "Binary Search";
        algorithm.Description = "Binary search is a fast search algorithm with run-time complexity of O(log n). This search algorithm works on the principle of divide and conquer. For this algorithm to work properly, the data collection should be in the sorted form.";
        algorithm.TimeComplexity = Complexity.LogN;
        algorithm.MemoryComplexity = Complexity.O1;
        algorithm.ImageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/83/Binary_Search_Depiction.svg";
        return algorithm;
    }
}
