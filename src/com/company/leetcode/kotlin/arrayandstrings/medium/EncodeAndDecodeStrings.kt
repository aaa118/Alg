package com.company.leetcode.kotlin.arrayandstrings.medium

import java.lang.StringBuilder

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
 * decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 * You are not allowed to solve the problem using any serialize methods (such as eval).
 *
 *
 * Example 1:
 * Input: dummy_input = ["Hello","World"]
 * Output: ["Hello","World"]
 * Explanation:
 * Machine 1:
 * Codec encoder = new Codec();
 * String msg = encoder.encode(strs);
 * Machine 1 ---msg---> Machine 2
 * Machine 2:
 * Codec decoder = new Codec();
 * String[] strs = decoder.decode(msg);
 *
 * Example 2:
 * Input: dummy_input = [""]
 * Output: [""]
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] contains any possible characters out of 256 valid ASCII characters.
 *
 * https://www.lintcode.com/problem/659/
 */


 /**
 * Solution:
 */
class EncodeAndDecodeStrings {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//            val list = mutableListOf("Hello", "World")
            val list = mutableListOf("we", "say#2td", ":", "yes")
            val string = encode(list)
            println(decode(string))


        }

        // Encodes a list of strings to a single string.
        private fun encode(strs: List<String>): String {
            val delimiter = "#"
            val resultString = StringBuilder()
            for (string in strs) {
                resultString.append("${string.length}" + delimiter + string)
            }
            return resultString.toString()
        }

        // Decodes a single string to a list of strings.
        private fun decode(s: String): List<String> {
            val delimiter = "#"
            val finalList:MutableList<String> = emptyList<String>().toMutableList()

            // Valid List should always start with the index
            var startIndexOfStringLength = 0
            var indexOfDelimiter = 1

            while (indexOfDelimiter < s.length) {
                if (s[indexOfDelimiter].toString() == delimiter) {
                    val length: Int = s.substring(startIndexOfStringLength, indexOfDelimiter).toInt()
                    finalList.add(s.substring(indexOfDelimiter+1, indexOfDelimiter + 1 + length))
                    indexOfDelimiter += length + 1
                    startIndexOfStringLength = indexOfDelimiter
                } else {
                    indexOfDelimiter++
                }

            }
            return finalList
        }
    }
}