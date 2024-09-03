package com.company.leetcode.kotlin.medium

import java.util.*
import kotlin.math.max

class LongestRepeatingCharReplacement {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(characterReplacement("AABABCBA", 1))
            println(characterReplacement1("AABABCBA", 1))

        }
        private fun characterReplacement(s: String, k: Int): Int {
            val freq = IntArray(26)

            var res = 0
            var currMax = 0
            var start = 0

            for (end in 0..s.length - 1 ) {
                val count = ++freq[s[end] - 'A']
                currMax = Math.max(currMax, count)

                if (end - start + 1 > currMax + k) {
                    freq[s[start] - 'A']--
                    start++
                }

                res = Math.max(res, end - start + 1)
            }

            return res
        }
        fun characterReplacement1(s: String, k: Int): Int {
            var q = LinkedList<Pair<Int, Int>>()

            val map = mutableMapOf<Char,Int>()
            var maxf = 0
            var res = 0
            var l = 0
            var r = 0
            while (l < s.length && r < s.length) {
                map[s[r]] = map.getOrDefault(s[r], 0) + 1
                maxf = max(maxf, map.getOrDefault(s[r], 0))

                while (l < s.length && (r - l + 1) - maxf > k) {
                    map[s[l]] = map.getOrDefault(s[l], 0) - 1
                    l++
                }
                res = max(res, (r - l + 1))
                r++
            }
            return res
        }

    }


}