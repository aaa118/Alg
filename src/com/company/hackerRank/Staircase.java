package com.company.hackerRank;

public class Staircase {
    public static void main(String[] args) {
        staircase(4);

    }


    // Complete the staircase function below.
    static void staircase(int n) {
        int space = n - 1;
        for (int hashce = 0; hashce < n; hashce++) {
            int space1 = space;
            while (space1 > 0) {
                System.out.print(" ");
                space1--;
            }
            int numH = n - space - 1;
            space--;
            int j = 0;
            while (j < numH + 1) {
                System.out.print("#");
                j++;
            }
            System.out.println();

        }
    }
}
