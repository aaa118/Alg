package com.company.general.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int keyTimesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int keyTimesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> keyTimes = new ArrayList<>();

        IntStream.range(0, keyTimesRows).forEach(i -> {
            try {
                keyTimes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        char result = SlowestKey.slowestKey(keyTimes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}