package com.company.algoexpert.java;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] test = new int[3][4];
        test[0][0] = 1;
        test[0][1] = 2;
        test[0][2] = 3;
        test[0][3] = 4;
        test[1][0] = 10;
        test[1][1] = 11;
        test[1][2] = 12;
        test[1][3] = 5;
        test[2][0] = 9;
        test[2][1] = 8;
        test[2][2] = 9;
        test[2][3] = 6;
//        test[3][0] = 10;
//        test[3][1] = 9;
//        test[3][2] = 8;
//        test[3][3] = 7;

        System.out.println(spiralTraverse(test));
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        int sR = 0;
        int eR = array.length - 1;
        int sC = 0;
        int eC = array[0].length - 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (sR <= eR && sC <= eC) {
            for (int c = sC; c <= eC; c++) {
                result.add(array[sR][c]);
            }
            for (int r = sR + 1; r <= eR; r++) {
                result.add(array[r][eC]);
            }
            for (int c = eC - 1; c >= sC; c-- ) {
                result.add(array[eR][c]);
            }
            for (int r = eR - 1; r > sR; r--) {
                result.add(array[r][sC]);
            }

//            int max2Sums[] = new int {0, 1};

            sR++;
            eC--;
            eR--;
            sC++;
        }

        return result;
    }
}
