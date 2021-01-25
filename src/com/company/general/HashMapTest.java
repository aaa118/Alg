package com.company.general;

import java.util.HashMap;

public class HashMapTest<I extends Number, S> {
    public static void main(String[] args) {

        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(0, "Warn");
        integerStringHashMap.put(1, "Warniugn");
        integerStringHashMap.put(2, "WarnTest");

        System.out.println(integerStringHashMap.get(1));
        if (integerStringHashMap.get(3) != null) {
            System.out.println(integerStringHashMap.get(3));
        }
    }
}
