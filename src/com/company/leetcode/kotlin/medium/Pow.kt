package com.company.leetcode.kotlin.medium

import kotlin.math.abs

class Pow {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(myPow(2.0, 3))

        }
        fun myPow(x: Double, n: Int): Double {
            if (n == 0) return 1.00
            val res = helper(x, abs(n))
            return if (n < 0) 1 / res else res

        }

        private fun helper(x: Double, n: Int) : Double {
            if (n == 0) {
                return 1.0
            }
            var res = helper(x, n/2)
            res *= res
            return if (n % 2 == 0) return res else x * res
        }
    }
}