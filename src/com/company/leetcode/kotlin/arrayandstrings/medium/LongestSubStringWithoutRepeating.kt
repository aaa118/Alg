package com.company.leetcode.kotlin.arrayandstrings.medium

import kotlin.math.max

class LongestSubStringWithoutRepeating {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(lengthOfLongestSubstring("dvdf"))
            println(lengthOfLongestSubstring(""))
        }

        private fun lengthOfLongestSubstring(s: String): Int {
            val set = mutableSetOf<Char>()
            var res = 0
            for (c in s) {
                while(set.size > 0 && set.contains(c)) {
                    set.remove(set.first())
                }
                set.add(c)
                res = max(res, set.size)
            }
            return res
        }
    }
}