package com.company.algoexpert.java;

import java.util.Arrays;

public class FindThreeLargest {
    public static void main(String[] args) {
//        int[] inputArray = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] inputArray = {55, 43, 11, 3, -3, 10};
//        findThreeLargestNumbers(inputArray);
        System.out.println(Arrays.toString(findThreeLargestNumbers(inputArray)));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] fArray = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i : array) {
            if (i > fArray[2]) {
                test(fArray, 2, i);
            } else if (i > fArray[1]) {
                test(fArray, 1, i);
            } else {
                if (i > fArray[0]) {
                    fArray[0] = i;
                }
            }
        }
        return fArray;
    }

    public static void test(int[] fArray, int position, int num) {
        int temp;
        for (int i = 0; i <= position; i++) {
            if (i == position) {
                temp = fArray[position];
                fArray[position] = num;
                fArray[position - 1] = temp;
            } else {
                fArray[i] = fArray[i + 1];
            }
        }
    }
}
