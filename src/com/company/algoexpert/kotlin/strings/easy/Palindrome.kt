package com.company.algoexpert.kotlin.strings.easy

class Palindrome {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun isPalindrome(string: String): Boolean {
            // Write your code here.
            var i = 0
            var j = string.length - 1

            while (i < j) {
                if (string[i] == string[j]) {
                    i++
                    j--
                } else {
                    return false
                }
            }

            return true
        }
    }
}