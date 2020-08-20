package com.company;

public class Fibonacci {
    public static void main(String[] args) {

    }
    
    public static int getNthFib(int n) {
        // Write your code here.

        if(n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int f = 0;
        int f1 = 1;
        int nextInt = 0;

        for (int i = 2; i < n; i++) {
            nextInt = f + f1;
            f = f1;
            f1 = nextInt;
        }

        return nextInt;
    }
}
