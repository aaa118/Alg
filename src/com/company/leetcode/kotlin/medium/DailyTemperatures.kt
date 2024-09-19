package com.company.leetcode.kotlin.medium

import java.util.*
import kotlin.math.min

class DailyTemperatures {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val nums = intArrayOf(73,74,75,71,69,72,76,73)

            var map = mutableMapOf<String, MutableList<Pair<String, Int>>>()
            map["123"] = mutableListOf<Pair<String, Int>>()
            map["123"]?.add(Pair("rtr", 12))
            map["123"]?.add(Pair("rtr22", 12))

            println(map["123"]?.first())

            println(dailyTemperatures1(nums).asList())
        }
        fun uncommonFromSentences(s1: String, s2: String): Array<String> {
            var count = mutableMapOf<String, Int>()
            for (word in s1.split(" ")) count[word] = count.getOrDefault(word, 0) + 1
            for (word in s2.split(" ")) count[word] = count.getOrDefault(word, 0) + 1
            var ans = LinkedList<String>()
            for (word in count.keys) {
                if (count[word] == 1) ans.add(word)
            }
            return ans.toArray(arrayOf<String>())
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

        fun dailyTemperatures1(temperatures: IntArray): IntArray {
            val stack : Stack<Pair<Int, Int>> = Stack<Pair<Int, Int>>()


            var res = IntArray(temperatures.size)

            for (i in 0 until temperatures.size - 1) {
                if (temperatures[i] < temperatures[i + 1]) {
                    res[i] = 1
                } else {
                    stack.add(Pair(i, temperatures[i]))
                }
                while (stack.isNotEmpty() && stack.peek().second < temperatures[i + 1]) {
                    val top = stack.pop()
                    if (temperatures[i] < temperatures[i + 1]) {
                        res[top.first] = i + 1 - top.first
                    } else {
                        break
                    }
                }

            }
            return res
        }


    }
}