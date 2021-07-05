package com.company.general.java;


import com.company.general.java.utils.IPivot;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by p.lepeev on 03.11.2015.
 * <p>
 * Question 1
 * <p>
 * GENERAL DIRECTIONS:
 * Download the text file here.
 * <p>
 * The file contains all of the integers between 1 and 10,000 (inclusive, with no repeats) in unsorted order.
 * The integer in the ith row of the file gives you the ith entry of an input array.
 * Your task is to compute the total number of comparisons used to sort the given input file by QuickSort.
 * As you know, the number of comparisons depends on which elements are chosen as pivots, so we'll ask you
 * to explore three different pivoting rules.
 * You should not count comparisons one-by-one. Rather, when there is a recursive call on a subarray of length m,
 * you should simply add m?1 to your running total of comparisons. (This is because the pivot element is compared
 * to each of the other m?1 elements in the subarray in this recursive call.)
 * <p>
 * WARNING: The Partition subroutine can be implemented in several different ways, and different implementations
 * can give you differing numbers of comparisons. For this problem, you should implement the Partition subroutine
 * exactly as it is described in the video lectures (otherwise you might get the wrong answer).
 * <p>
 * DIRECTIONS FOR THIS PROBLEM:
 * For the first part of the programming assignment, you should always use the first element of the array as the pivot element.
 * <p>
 * HOW TO GIVE US YOUR ANSWER:
 * Type the numeric answer in the space provided.
 * So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / other
 * punctuation marks. You have 5 attempts to get the correct answer. (We do not require you to submit your code,
 * so feel free to use the programming language of your choice, just type the numeric answer in the following space.)
 * <p>
 * <p>
 * Question 2
 * <p>
 * GENERAL DIRECTIONS AND HOW TO GIVE US YOUR ANSWER:
 * See the first question.
 * <p>
 * DIRECTIONS FOR THIS PROBLEM:
 * Compute the number of comparisons (as in Problem 1), always using the final element of the given array as the pivot
 * element. Again, be sure to implement the Partition subroutine exactly as it is described in the video lectures.
 * Recall from the lectures that, just before the main Partition subroutine, you should exchange the pivot element
 * (i.e., the last element) with the first element.
 * <p>
 * <p>
 * Question 3
 * <p>
 * GENERAL DIRECTIONS AND HOW TO GIVE US YOUR ANSWER:
 * See the first question.
 * <p>
 * DIRECTIONS FOR THIS PROBLEM:
 * Compute the number of comparisons (as in Problem 1), using the "median-of-three" pivot rule. [The primary motivation
 * behind this rule is to do a little bit of extra work to get much better performance on input arrays that are nearly
 * sorted or reverse sorted.] In more detail, you should choose the pivot as follows. Consider the first, middle, and
 * final elements of the given array. (If the array has odd length it should be clear what the "middle" element is;
 * for an array with even length 2k, use the kth element as the "middle" element. So for the array 4 5 6 7, the
 * "middle" element is the second one ---- 5 and not 6!) Identify which of these three elements is the median (i.e.,
 * the one whose value is in between the other two), and use this as your pivot. As discussed in the first and second
 * parts of this programming assignment, be sure to implement Partition exactly as described in the video lectures
 * (including exchanging the pivot element with the first element just before the main Partition subroutine).
 * EXAMPLE: For the input array 8 2 4 5 7 1 you would consider the first (8), middle (4), and last (1) elements;
 * since 4 is the median of the set {1,4,8}, you would use 4 as your pivot element.
 * SUBTLE POINT: A careful analysis would keep track of the comparisons made in identifying the median of the three
 * candidate elements. You should NOT do this. That is, as in the previous two problems, you should simply add m?1 to
 * your running total of comparisons every time you recurse on a subarray with length m.
 */


public class QuickSort {

    // returns number of comparisons used.
    public static long quickSort(int[] a, IPivot choosePivot) {

        if (a.length <= 1) {
            return 0;
        }

        swap(a, 0, choosePivot.get(a));

        int i = partition(a);

        return a.length - 1 +
                quickSort(Arrays.copyOfRange(a, 0, i), choosePivot) +
                quickSort(Arrays.copyOfRange(a, i + 1, a.length), choosePivot);

    }

    private static int partition(int[] a) {
        int i = 1;
        for (int j = 1; j < a.length; j++) {
            if (a[j] < a[0]) {
                swap(a, j, i++);
            }
        }
        swap(a, 0, i - 1);
        return i - 1;
    }


    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) throws IOException {

        int i = 0;
        int[] numbers = new int[10_000];

        FileInputStream fis = new FileInputStream(new File("src/Quicksort.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            numbers[i++] = Integer.valueOf(line);
        }

        /* ====================== Q1 ======================*/
        System.out.println(quickSort(Arrays.copyOf(numbers, numbers.length), new IPivot() {
            @Override
            public int get(int[] a) {
                return 0;
            }
        }));

        /* ====================== Q2 ======================*/
        System.out.println(quickSort(Arrays.copyOf(numbers, numbers.length), new IPivot() {
            @Override
            public int get(int[] a) {
                return a.length - 1;
            }
        }));

        /* ====================== Q3 ======================*/
        System.out.println(quickSort(Arrays.copyOf(numbers, numbers.length), new IPivot() {
            @Override
            public int get(final int[] a) {
                int m = a.length % 2 == 0 ? a.length / 2 - 1 : a.length / 2;

                List<Integer> order = asList(0, m, a.length - 1);
                Collections.sort(order, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer x, Integer y) {
                        if (a[x] < a[y])
                            return 1;
                        else if (a[x] > a[y])
                            return -1;
                        return 0;
                    }
                });
                return order.get(1);
            }
        }));

    }

}
