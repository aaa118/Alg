package com.company.leetcode.kotlin.arrayandstrings.medium

import kotlin.math.max
import kotlin.math.min

class IntegerToRoman {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(intToRoman(3749))
            var wordList = mutableListOf("123", "456", "789")

            var words = wordList.toMutableSet()
            words.remove("123")
            println(words.size)


        }

        private fun intToRoman(num: Int): String {
            var nums = num
            val ints = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
            val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
            var i = 0
            var sb = StringBuilder()
            while (nums > 0) {
                while (ints[i] > nums) i++
                sb.append(romans[i])
                nums -= ints[i]
            }
            return sb.toString()
        }
    }
}