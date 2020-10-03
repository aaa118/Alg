package com.company.algoexpert;

import java.util.Arrays;

public class SmallestDifference {


    public static void main(String[] args) {
        int[] inputArray = {-1, 5, 10, 20, 3};
        int[] inputArray2 = {26, 134, 135, 15, 17};
//        findThreeLargestNumbers(inputArray);
        System.out.println(Arrays.toString(smallestDifference(inputArray, inputArray2)));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] sD = new int[0];
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int iL = 0;
        int iR = 0;
        int a1 = arrayOne.length - 1;
        int a2 = arrayTwo.length - 1;

        int diff = Math.abs(arrayOne[iL] - arrayTwo[iR]);

        while (iL < a1 && iR < a2) {
            if (arrayOne[iL] == arrayTwo[iR]) {
                return new int[]{arrayTwo[iL], arrayTwo[iR]};
            }
            int diff2 = Math.abs(arrayOne[iL + 1] - arrayTwo[iR]);

            if (diff < diff2) {
                iL++;

//                int newD = Math.abs(arrayOne[iL] - arrayTwo[iR]);
//                if (newD < diff) {
                    diff = diff2;
                    sD = new int[]{arrayOne[iL], arrayTwo[iR]};
//                System.out.println(Arrays.toString(sD));
//                }
            } else {
                iR++;
//                int newD = Math.abs(arrayOne[iL] - arrayTwo[iR]);
//                if (newD < diff) {
                    diff = diff2;
                    sD = new int[]{arrayOne[iL], arrayTwo[iR]};
//                }
            }
        }
        return sD;
    }
}
