package com.company.general.java;


import java.io.*;
import java.util.Arrays;

/**
 * Created by p.lepeev on 28.10.2015.
 *
 * The file contains all the 100,000 integers between 1 and 100,000 (including both) in some random order( no integer is repeated).
 *
 * Your task is to find the number of inversions in the file given (every row has a single integer between 1 and 100,000).
 * Assume your array is from 1 to 100,000 and ith row of the file gives you the ith entry of the array.
 * Write a program and run over the file given. The numeric answer should be written in the space.
 * So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / any other punctuation marks.
 * You can make upto 5 attempts, and we'll count the best one for grading.
 * (We do not require you to submit your code, so feel free to choose the programming language of your choice, just type the numeric answer in the following space)
 *
 */
public class Inversions {

    public static long countInversions(int[] numbers) {
        if (numbers.length == 1)
            return 0;
        int[] left = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
        int[] right = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
        return countInversions(left) +
                countInversions(right) +
                countSplitInv(left, right, numbers);

    }

    private static long countSplitInv(int[] left, int[] right, int[] numbers) {
        long count = 0;
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) { // no inversions
                numbers[k++] = left[i++];
            } else {
                numbers[k++] = right[j++];
                count += left.length - i;
            }
        }
        while (i < left.length) numbers[k++] = left[i++];
        while (j < right.length) numbers[k++] = right[j++];
        return count;

    }

    public static long countInvStandard(int[] numbers) {
        long count = 0;
        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[i] > numbers[j])
                    count++;
        return count;
    }

    public static void main(String[] args) throws IOException {

        long invNumber = 0;
        int i = 0;
        int[] numbers = new int[100_000];

        FileInputStream fis = new FileInputStream(new File("src/test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            numbers[i++] = Integer.valueOf(line);
        }

        System.out.println("Starting calculate...\n");
        long start, end;

        /*start = System.currentTimeMillis();
        invNumber = countInvStandard(numbers);
        end = System.currentTimeMillis();
        System.out.println("\nSlow solution, O(n^2) time. \nResult:" + invNumber + "\nTime elapsed = " + (end-start)/1000 + " sec");*/

        start = System.currentTimeMillis();
        invNumber = countInversions(numbers);
        end = System.currentTimeMillis();
        System.out.println("\n\nDevide-and-conqueror method, O(n*log(n)) time.\nResult:" + invNumber + "\nTime elapsed = " + (end-start)/1000 + " sec");


        br.close();

    }

}
