package com.company.algoexpert.java;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array1 = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int[] array2 = {5, 23, 111};
        int target1 = 33;
        int target2 = 3;
        int result = binarySearch(array2, target2);
        System.out.println(result);


    }

    public static int binarySearch(int[] array, int target) {
        int halfLength = array.length / 2;
        if (array[halfLength] == target) {
            return halfLength;
        }

        if (array[halfLength] < target) {
            for (int i = halfLength + 1; i < array.length; i++) {
                if (array[i] == target) {
                    return i;
                }
            }
        }

        if (array[halfLength] > target) {
            for (int i = 0; i < halfLength; i++) {
                if (array[i] == target) {
                return i;
                }
            }
        }
        // for (int i = 0; i < array.length; i++) {
        // 	if (array[i] == target) {
        // 		return i;
        // 	}
        // }
        return -1;
    }
}
