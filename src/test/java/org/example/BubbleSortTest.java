package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        int[] arr1 = {3,2,1};
        int[] arrSorted = {1,2,3};

        BubbleSort.sort(arr1);
        assertArrayEquals(arr1, arrSorted);
    }

    @Test
    void sortOpt() {
        int[] arr1 = {3,2,1};
        int[] arrSorted = {1,2,3};

        BubbleSort.sortOptimising(arr1);
        assertArrayEquals(arr1, arrSorted);
    }
}