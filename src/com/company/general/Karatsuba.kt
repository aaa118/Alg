package com.company.general

import com.company.hackerRank.kotlin.DivisibleSumPairs
import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

class Karatsuba {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val arrays = arrayOf(1, 3, 2, 6, 1, 2)
////            val d = 3

////            val m = 2
//            val k = 3
//            val n = 6
//            println(DivisibleSumPairs.divisibleSumPairs(n, k, arrays))

            karatsubaMulti(5678, 1234)
        }

        fun karatsubaMulti(number1: Int, number2: Int) {
            val num1Length = number1.length()
            val num2Length = number2.length()
            println(num1Length)
            println(num2Length)
            val ans = 5.0.pow(2.0).toInt()


        }

        fun Int.length() = when(this) {
            0 -> 1
            else -> log10(abs(toDouble())).toInt() + 1
        }

    }
}
