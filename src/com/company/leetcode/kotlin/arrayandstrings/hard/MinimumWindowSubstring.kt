package com.company.leetcode.kotlin.arrayandstrings.hard

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
class MinimumWindowSubstring {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minWindow("ADOBECODEBANC", "ABC"))
            println(minWindow("a", "aa"))
            println(minWindow("a", "a"))
        }

        private fun minWindow(s: String, t: String): String {
            val mapt = mutableMapOf<Char, Int>()
            val maps = mutableMapOf<Char, Int>()
            for (c in t) {
                mapt[c] = mapt.getOrDefault(c, 0) + 1
            }
            val tl = mapt.size
            var sl = 0
            var l = 0
            var r = 0
            var res = Int.MAX_VALUE
            var resP = Pair(-1, - 1)
            while (l < s.length && r < s.length) {
                val cr = s[r]
                maps[cr] = maps.getOrDefault(cr, 0) + 1
                if (mapt.containsKey(cr)) {
                    val countT = mapt.getOrDefault(cr, 0)
                    val countS = maps.getOrDefault(cr, 0)
                    if (countT == countS) sl++

                }
                while (l < s.length && sl == tl) {
                    val temp = r - l + 1
                    if (temp < res) {
                        resP = Pair(r + 1, l)
                        res = temp
                    }

                    val cl = s[l]
                    maps[cl] = maps.getOrDefault(cl, 0) - 1
                    if (mapt.containsKey(cl) && maps.getOrDefault(cl, 0) < mapt.getOrDefault(cl, 0)) {
                        sl--
                    }
                    l++
                }
                r++
            }
            return if (res == Int.MAX_VALUE) return "" else s.substring(resP.second, resP.first)
        }
    }
}