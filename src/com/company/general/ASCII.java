package com.company.general;

public class ASCII {
    public static void main(String[] args) {
        char character = 'a';
//        System.out.println((int) character);
//        char b = 99;

        String b = "zyx";
//        System.out.println((int) 'a');
        System.out.println(b.charAt(1) + 1);
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.

        // Write your code here.
        int l = str.length();
        char[] allC = new char[l];
        int key1 = key % 26;

        for (int i = 0; i < l; i++) {
            allC[i] = (char) (str.charAt(i) + key1);
        }
        return new String(allC);
    }

    public static int getNewASCII(int totalN) {
        if (totalN > 122) {
            return 96 + totalN % 122;
        } else {
            return totalN;
        }
    }
}
