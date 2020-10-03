package com.company.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {


    public static void main(String[] args) {
//        int[] inputArray = {-1, 5, 10, 20, 3};
        Integer[] inputArray2 = {26, 134, 135, 15, 17};
        List<Integer> integers = Arrays.asList(inputArray2);

//        List<Integer> integers = new ArrayList<>();
//        integers.add(2);
//        integers.add(1);
//        integers.add(2);
//        integers.add(2);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        integers.add(2);
//        findThreeLargestNumbers(inputArray);
        System.out.println(moveElementToEnd(integers, 2));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) != toMove) {
                sway(array, i, i - 1);
                int j = i;
                while(j > 0) {
                    if (j - 2 > 0 && array.get(j - 2) == toMove) {
                        sway(array, j - 1, j - 2);
//                        System.out.println(j);
                    }
                    j--;
                }
            }
        }
        return array;
    }

    public static void sway(List<Integer> array, int pos, int p2) {
        int temp = array.get(pos);
        System.out.println(temp);
        array.set(pos, array.get(p2));
        array.set(p2, temp);
        System.out.println(array);
    }
}
