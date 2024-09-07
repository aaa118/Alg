package com.company.leetcode.kotlin.arrayandstrings.hard

import kotlin.math.max
import kotlin.math.min

/**
 *
 */
class IntegerToEnglishWords {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        fun numberToWords(num: Int): String {
            return if (num == 0) "Zero" else helper(num)
        }

        fun lessTwenty(num: Int): String {
            return when(num) {
                1 -> "One"
                2 -> "Two"
                3 -> "Three"
                4 -> "Four"
                5 -> "Five"
                6 -> "Six"
                7 -> "Seven"
                8 -> "Eight"
                9 -> "Nine"
                10 -> "Ten"
                11 -> "Eleven"
                12 -> "Twelve"
                13 -> "Thirteen"
                14 -> "Fourteen"
                15 -> "Fifteen"
                16 -> "Sixteen"
                17 -> "Seventeen"
                18 -> "Eighteen"
                19 -> "Nineteen"
                else -> ""
            }
        }
        fun lessHundred(num: Int): String {
            return when (num) {
                20 -> "Twenty"
                30 -> "Thirty"
                40 -> "Forty"
                50 -> "Fifty"
                60 -> "Sixty"
                70 -> "Seventy"
                80 -> "Eighty"
                90 -> "Ninety"
                else -> ""
            }
        }

        fun helper(num: Int) : String {
            var res = ""
            res += if (num >= 1_000_000_000) {
                helper(num / 1_000_000_000) + " Billion " + helper(num % 1_000_000_000)
            } else if (num >= 1_000_000) {
                helper(num / 1_000_000) + " Million " + helper(num % 1_000_000)
            } else if (num >= 1_000) {
                helper(num / 1_000) + " Thousand " + helper(num % 1_000)
            } else if (num >= 100) {
                helper(num / 100) + " Hundred " + helper(num % 100)
            } else if (num >= 20) {
                lessHundred(num - (num % 10)) + " " + lessTwenty(num % 10)
            } else {
                lessTwenty(num)
            }
            return res
        }

    }
}