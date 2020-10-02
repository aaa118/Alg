package com.company.algoexpert;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] inputArray = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
//        int[] inputArray = {8, 5, 2, 9, 6, 3};
        int[] inputArray = {8, 5, 2, 9, 5, 6, 3};

//        findThreeLargestNumbers(inputArray);
        System.out.println(Arrays.toString(bubbleSort(inputArray)));
    }

    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return new int[] {};
        }

        int counter = 0;

        boolean isSorted = false;
        while (!isSorted) {
        isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
//                isSorted = true;
                if (array[i] > array[i + 1]) {
                    swap(array, i);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public  static  void swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }
}
