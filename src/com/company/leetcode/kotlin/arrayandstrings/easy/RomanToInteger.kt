package com.company.leetcode.kotlin.arrayandstrings.easy

import kotlin.math.max
import kotlin.math.min

class RomanToInteger {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(romanToInt("MCMXCIV"))
            println(romanToInt("III"))
        }

        private fun romanToInt(s: String): Int {
            val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000,)
            var sum = 0
            var i = 0
            while (i < s.length) {
                val num1 = map.getOrDefault(s[i], 0)
                val num2 = map.getOrDefault(s[i + 1], 0)
                if (i + 1 < s.length && num1 < num2) {
                    sum += num2 - num1
                    i += 2
                    continue
                }
                sum += num1
                i++

            }
            return sum
        }
    }
}