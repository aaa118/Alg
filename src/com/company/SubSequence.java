package com.company;

import java.util.*;

class SubSequence {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
//        int[] array1 = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] array1 = {5, 1, 22, 25, 6, -1, 8, 10};
//        int[] sequence1 = {1, 6, -1, -1};
        int[] sequence1 = {1, 6, -1, 10};
        for (int text : array1) {
            array.add(text);
        }

        for (int text : sequence1) {
            sequence.add(text);
        }

        boolean value = isValidSubsequence(array, sequence);
        System.out.println(value);
    }


    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while(arrayIndex < array.size()) {
            if (sequence.get(sequenceIndex).equals(array.get(arrayIndex))) {
                sequenceIndex++;
            }
            arrayIndex++;
            if (sequenceIndex == sequence.size()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int j = 0;
        System.out.println(sequence.size());

        for (int i = 0; i < array.size(); i++) {

            if (sequence.get(j).equals(array.get(i))) {
                j++;
                System.out.println(j);
            }


            if (j == sequence.size()) {
                return true;
            }

        }
        return false;
    }

    public static boolean isValidSubsequences1(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while(arrayIndex < array.size()) {
            if (sequence.get(sequenceIndex).equals(array.get(arrayIndex))) {
                sequenceIndex++;
            }
            arrayIndex++;
            if (sequenceIndex == sequence.size()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSubsequences2(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while(arrayIndex < array.size()) {
            if (sequence.get(sequenceIndex).equals(array.get(arrayIndex))) {
                sequenceIndex++;
            }
            arrayIndex++;
            if (sequenceIndex == sequence.size()) {
                return true;
            }
        }
        return false;
    }

}
