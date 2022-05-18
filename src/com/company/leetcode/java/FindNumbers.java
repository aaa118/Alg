package com.company.leetcode.java;

/**
 * Find Numbers with Even Number of Digits
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 */
public class FindNumbers {

    public static void main(String[] args) {
        int[] input = {12, 345, 2, 6, 7896};

        System.out.println(findNumbers(input));
    }

    public static int findNumbers(int[] nums) {
        int counter = 0;
        for (int i : nums) {
            int numL = 0;
            if (i < 10) {
                numL = 1;
            } else {
                while (i >= 10) {
                    i =  i / 10;
                    numL++;
                }
                numL++;
            }
            System.out.println(numL);
            if (numL % 2 == 0) {
                counter++;
            }
        }

        return counter;
    }

}
