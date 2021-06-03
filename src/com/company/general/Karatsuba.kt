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
            val num1HalfLength = number1.length() / 2
            if (num1HalfLength == 1) {
                return number1 * number2
            }
            val num2HalfLength = number2.length()
            val tenPowerOfHalfLength = 10.0.pow(num1HalfLength).toInt()
            val tenPowerOfFullLength = 10.0.pow(num2HalfLength).toInt()
            val a = number1 / tenPowerOfHalfLength
            val b = number1 % tenPowerOfHalfLength
            val c = number2 / tenPowerOfHalfLength
            val d = number2 % tenPowerOfHalfLength
            return (tenPowerOfFullLength * (a * c)) + (tenPowerOfHalfLength * ((a * d) + (b * c))) + (b * d)

        }

        fun Int.length() = when (this) {
            0 -> 1
            else -> log10(abs(toDouble())).toInt() + 1
        }

    }
}
