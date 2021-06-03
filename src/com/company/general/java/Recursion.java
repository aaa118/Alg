package com.company.general.java;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(    recursionFactorial(5));
    }
    public static int recursionFactorial(int n) {
        if (n > 1) {
            return n * recursionFactorial(n -1);
        }
        return 1;
    }


    public static void recursionExample(int n) {
        int p = 1;
        printMethod(n, p);
    }
    private static void printMethod(int n, int p) {
        System.out.println(p);
        if (p < n) {
            printMethod(n, p + 1);
        }
    }
}
