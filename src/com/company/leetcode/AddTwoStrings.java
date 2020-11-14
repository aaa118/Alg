package com.company.leetcode;

public class AddTwoStrings {
    public static void main(String[] args) {

        String num1 = "1234";
        String num2 = "1234";

        int p1 = num1.length() - 1;
        int p = num1.charAt(num1.length() - 1);
        int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;

        int test = p - 1;
        System.out.println(p);
        System.out.println(test);
        System.out.println(x1);
    }
}
