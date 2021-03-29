package com.company.hackerRank.java;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = gradingStudents(grades);
//
////        bufferedWriter.write(
////                result.stream()
////                        .map(Object::toString)
////                        .collect(joining("\n"))
////                        + "\n"
////        );
//
//        bufferedReader.close();
////        bufferedWriter.close();
//    }

    public static void main(String[] args) {
//        List<Integer> result = new ArrayList<>();
//        result.add(73);
//        result.add(67);
//        result.add(38);
//        result.add(33);

//        System.out.println(gradingStudents(result));
int[] numbers = new int[10];
        System.out.println("apple".compareTo("banana"));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalList = new ArrayList<>();
        List list = new ArrayList();
//        list.add()
        for (int num : grades) {
            if (num > 37 && num % 5 >= 3) {
                finalList.add(((num / 5) + 1) * 5);
            } else {
                finalList.add(num);
            }
        }
        return finalList;
    }


}
