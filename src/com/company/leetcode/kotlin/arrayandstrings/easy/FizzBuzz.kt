package com.company.leetcode.kotlin.arrayandstrings.easy

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
class FizzBuzz {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        fun fizzBuzz(n: Int): List<String> {
            val res = mutableListOf<String>()
            for (i in 0 until n) {
                val num = i + 1
                if (num % 3 == 0 && num % 5 == 0) {
                    res.add("FizzBuzz")
                } else if (num % 3 == 0) {
                    res.add("Fizz")
                } else if (num % 5 == 0) {
                    res.add("Buzz")
                } else {
                    res.add(num.toString())
                }
            }
            return res
        }

    }
}