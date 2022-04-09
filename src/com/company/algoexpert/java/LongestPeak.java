package com.company.algoexpert.java;

import java.util.ArrayList;
import java.util.List;

public class LongestPeak {

    public static void main(String[] args) {
//        int[] inputArray = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
//        int[] inputArray = {1, 2, 3, 4, 5, 1};
        //Expected 9
        int[] inputArray = { 1,
                1,
                1,
                2,
                3,
                10,
                12,
                -3,
                -3,
                2,
                3,
                45,
                800,
                99,
                98,
                0,
                -1,
                -1,
                2,
                3,
                4,
                5,
                0,
                -1,
                -1};
        System.out.println(longestPeak(inputArray));

    }

    public static int longestPeak(int[] array) {
        // Write your code here.

        int size;
        int highestP = 0;
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] < array[i + 1] && array[i + 1] > array[i + 2]) {
                List<Integer> list = new ArrayList<>();
                list.add(array[i]);
                list.add(array[i + 1]);
                list.add(array[i + 2]);
                int j = i + 2;
                while (j < array.length - 1 && array[j] > array[j + 1]) {
                    list.add(array[j + 1]);
                    j++;
                }
                int k = i;
                while (k > 0 && array[k - 1] < array[k]) {
                    list.add(array[k -1]);
                    k--;
                }
                size = list.size();
                System.out.println(list);
                if (highestP < size) {
                    highestP = size;
                }

            }
        }

        return highestP;
    }

}
