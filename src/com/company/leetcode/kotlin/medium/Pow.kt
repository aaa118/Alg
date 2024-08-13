package com.company.leetcode.kotlin.medium

import kotlin.math.abs

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
class Pow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(myPow(2.000, 10))
//            println(myPow(2.000, -2))
            println(myPow(2.000, -21483648))

        }
        fun myPow(x: Double, n: Int): Double {
            var sum = x
            var _n = abs(n)
            if (n == Int.MIN_VALUE) return 0.00
            while (_n > 1) {
                sum *= x
                _n--
            }
            return if (n < 0) {
                1/sum
            } else {
                sum
            }

        }


    }
}