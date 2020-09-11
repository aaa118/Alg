package com.company.general;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'slowestKey' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts 2D_INTEGER_ARRAY keyTimes as parameter.
     */

    public static char slowestKey(List<List<Integer>> keyTimes) {
        // Write your code here
        char a = 0;

//        for (int i : keyTimes.get(keytime.size())) {
//            if (i ==0 ) {
//                int start = 0;
//            }
//        }
        System.out.println(keyTimes);

        return a;

    }

}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int keyTimesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int keyTimesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> keyTimes = new ArrayList<>();

        IntStream.range(0, keyTimesRows).forEach(i -> {
            try {
                keyTimes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").
                                split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        char result = Result.slowestKey(keyTimes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
