package com.company.general.kotlin

import java.math.BigInteger
import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

class Karatsuba {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(karatsubaMultiIntParam(BigInteger.valueOf(31415926), BigInteger.valueOf(27182818)))
            println(karatsubaMultiStringParam("31415926", "27182818"))
            println(karatsubaMultiIntParam(BigInteger.valueOf(1234), BigInteger.valueOf(5678)))
            println(karatsubaMultiStringParam("5678", "1234"))
//            println(karatsubaMultiStringParam("3141592653589793238462643383279502884197169399375105820974944592",
//                    "2718281828459045235360287471352662497757247093699959574966967627"))
        }

        private fun karatsubaMultiIntParam(number1: BigInteger, number2: BigInteger): BigInteger {
            val numFullLength = number2.length()
            if (numFullLength == 1) {
                return number1 * number2
            }
            val numHalfLength = number1.length() / 2.0

            val tenPowerOfHalfLength = BigInteger.valueOf(10.0.pow(numHalfLength).toLong())
            val tenPowerOfFullLength = BigInteger.valueOf(10.0.pow(numFullLength).toLong())
//            val tenPowerOfFullLength = 10.0.pow(numFullLength).toInt()
            val a = number1 / tenPowerOfHalfLength
            val b = number1 % tenPowerOfHalfLength
            val c = number2 / tenPowerOfHalfLength
            val d = number2 % tenPowerOfHalfLength
            return (tenPowerOfFullLength * karatsubaMultiIntParam(a, c)) +
                    (tenPowerOfHalfLength * (karatsubaMultiIntParam(a, d) + karatsubaMultiIntParam(b, c))) +
                    karatsubaMultiIntParam(b, d)

        }
        private fun karatsubaMultiStringParam(number1: String, number2: String): String {
            val numFullLength = number1.length
            if (numFullLength == 1) {
                val num1 = number1.toInt()
                val num2 = number2.toInt()
                return (num1 * num2).toString()
            }
            val numHalfLength = number1.length / 2
            val tenPowerOfHalfLength = 10.0.pow(numHalfLength).toInt()
            val tenPowerOfFullLength = 10.0.pow(numFullLength).toInt()
            val a = number1.subSequence(0, numHalfLength).toString()
            val b = number1.subSequence(numHalfLength, numFullLength).toString()
            val c = number2.subSequence(0, numHalfLength).toString()
            val d = number2.subSequence(numHalfLength, numFullLength).toString()
            return ((tenPowerOfFullLength * karatsubaMultiStringParam(a, c).toInt()).toInt() +
                    (tenPowerOfHalfLength * (karatsubaMultiStringParam(a, d).toInt() +
                            karatsubaMultiStringParam(b, c).toInt())) + karatsubaMultiStringParam(b, d).toInt()).toString()
        }

        fun BigInteger.length() = when (this) {
            BigInteger.valueOf(0) -> 1
            else -> log10(abs(toDouble())).toInt() + 1
        }
    }
}
