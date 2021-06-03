package com.company.general

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

class Karatsuba {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(karatsubaMulti(5678, 1234))
        }

        private fun karatsubaMulti(number1: Int, number2: Int): Int {
            val numFullLength = number2.length()
            if (numFullLength == 1) {
                return number1 * number2
            }
            val numHalfLength = number1.length() / 2
            val tenPowerOfHalfLength = 10.0.pow(numHalfLength).toInt()
            val tenPowerOfFullLength = 10.0.pow(numFullLength).toInt()
            val a = number1 / tenPowerOfHalfLength
            val b = number1 % tenPowerOfHalfLength
            val c = number2 / tenPowerOfHalfLength
            val d = number2 % tenPowerOfHalfLength
            return (tenPowerOfFullLength * karatsubaMulti(a, c)) +
                    (tenPowerOfHalfLength * (karatsubaMulti(a, d) + karatsubaMulti(b, c))) + karatsubaMulti(b, d)

        }

        fun Int.length() = when (this) {
            0 -> 1
            else -> log10(abs(toDouble())).toInt() + 1
        }

    }
}
