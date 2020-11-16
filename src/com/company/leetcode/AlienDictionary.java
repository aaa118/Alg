package com.company.leetcode;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        String[] words2 = {"hello","leetcode"};
        String order2 = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(isAlienSorted2(words, order));
        System.out.println(isAlienSorted2(words2, order2));

    }

    public static boolean isAlienSorted1(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }

    public static boolean isAlienSorted2(String[] words, String order) {
        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            int worlen1 = words[i].length();
            int worlen2 = words[i + 1].length();
            int worlen = Math.min(worlen1, worlen2);
            for (int j = 0; j < worlen; j++) {
                int curr = order.indexOf(words[i].charAt(j));
                int next = order.indexOf(words[i + 1].charAt(j));
                if (curr < next) break;
                else if (curr == next) {
                    // Do Nothing

                }
                else return false;
            }
            if (order.indexOf(words[i].charAt(worlen - 1)) == order.indexOf(words[i + 1]
                    .charAt(worlen - 1)) && worlen1 > worlen2)
                return false;
        }

        return true;
    }

}
