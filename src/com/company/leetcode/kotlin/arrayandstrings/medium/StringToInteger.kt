package com.company.leetcode.kotlin.arrayandstrings.medium

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
class StringToInteger {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            myAtoi("")
            myAtoi("   -042")
            myAtoi("-91283472332")
            myAtoi("2147483648")
        }

        private fun myAtoi(s: String): Int {
            var res = 0
            var i = 0
            while (i < s.length && s[i] == ' ') i++

            var pos = true
            if (i < s.length && (s[i] == '-' || s[i] == '+')) {
                pos = s[i] == '+'
                i++
            }

            while (i < s.length && s[i].isDigit()) {
                val digit = s[i] - '0'
                if (pos) {
                    if (res > (Int.MAX_VALUE - digit) / 10) return Int.MAX_VALUE
                    res = res * 10 + digit
                } else {
                    if (res < (Int.MIN_VALUE + digit) / 10) return Int.MIN_VALUE
                    res = res * 10 - digit
                }
                i++
            }
            return res
        }

    }
}