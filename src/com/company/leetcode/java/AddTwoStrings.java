package com.company.leetcode.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddTwoStrings {
    public static void main(String[] args) {

        String num1 = "1234";
//        String num2 = "1234";
        String num2 = "{\"type\":\"MobilityStart\",\"timestamp\":1607058534568,\"mobility\":\"WALKING\",\"preSDKStartTimestamp\":1607058534568}";
        String num3 = "{'type':'MobilityStart' :1607058534568}";

        String num4 = "some string with 'the data i want' inside";

//        Pattern pattern = Pattern.compile("'(.*?)'");
        Pattern pattern = Pattern.compile("'type':'(.*?)'");
        Matcher matcher = pattern.matcher(num3);
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
        }

        int p1 = num1.length() - 1;
        int p = num1.charAt(num1.length() - 1);
        int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;

        int test = p - 1;
//        System.out.println(p);
//        System.out.println(test);
//        System.out.println(x1);
    }
}
