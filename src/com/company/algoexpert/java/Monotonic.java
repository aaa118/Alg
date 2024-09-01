package com.company.algoexpert.java;

public class Monotonic {

    public static void main(String[] args) {
//        int[] inputArray = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        int[] inputArray = {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        System.out.println(isMonotonic(inputArray));

        String str = "1.2.0 (101.000235.00.10)";

        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                startIndex = i + 5;
            }
        }

        System.out.println(str.substring(startIndex, startIndex + 6));
        int version = Integer.parseInt(str.substring(startIndex, startIndex + 6));
        System.out.println(str.substring(0, startIndex - 5));
        System.out.println(str.substring(0, startIndex - 5) + "(" + version + ")");


    }

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        boolean isM = false;
        int i = 0;
        if (array.length < 2) {
            return true;
        }
        if (array[i] < array[i + 1] || array[i +  2] < array[i + 3]) {
            // Incrementing Array
            while (i < array.length - 1) {
                if (array[i] < array[i + 1] || array[i] == array[i + 1]) {
                    isM = true;
                } else {
                    isM = false;
                    break;
                }
                i++;
            }
        } else {
            while (i < array.length - 1) {
                if (array[i] > array[i + 1] || array[i] == array[i + 1]) {
                    isM = true;
                } else {
                    isM = false;
                    break;
                }
                i++;
            }
        }

        return isM;
    }
}
