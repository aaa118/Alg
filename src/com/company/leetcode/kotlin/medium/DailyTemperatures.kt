package com.company.leetcode.kotlin.medium

import java.util.*

class DailyTemperatures {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val nums = intArrayOf(73,74,75,71,69,72,76,73)

            println(dailyTemperatures(nums).asList())
        }

        private fun dailyTemperatures(temperatures: IntArray): IntArray {
            if (temperatures.size == 1) return intArrayOf(0)
            val stack = Stack<Int>()
            val resultantArray = IntArray(temperatures.size)
            var poppedElement: Int
            for (i in 0..temperatures.lastIndex) {
                while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    poppedElement = stack.pop()
                    resultantArray[poppedElement] = i - poppedElement
                }
                stack.push(i)
            }
            return resultantArray
        }
    }
}