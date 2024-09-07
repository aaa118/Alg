package com.company.leetcode.kotlin.slidingwindow.hard

class MinimumWindowSubString {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(minWindow("ADOBECODEBANC", "ABC"))

        }
        fun minWindow(s: String, t: String): String {
            var window = mutableMapOf<Char, Int>()
            var countT = mutableMapOf<Char, Int>()

            for (char in t) {
                countT[char] = countT.getOrDefault(char, 0) + 1
            }
            var l = 0
            var r = 0
            var n = 0
            var h = countT.size
            var resL = Int.MAX_VALUE
            var res = Pair(-1, -1)

            while (l < s.length && r < s.length) {
                window[s[r]] = window.getOrDefault(s[r], 0) + 1
                if (countT.contains(s[r])) {
                    var count = countT.getOrDefault(s[r], 0)
                    var curr = window.getOrDefault(s[r], 0)
                    if (curr == count) n++
                }
                while (l < s.length && n == h) {
                    var currL = r - l + 1
                    if (currL < resL) {
                        resL = currL
                        res = Pair(l, r)
                    }
                    window[s[l]] = window.getOrDefault(s[l], 0) - 1
                    if (countT.contains(s[l])) {
                        n--
                    }
                    l++
                }
                r++
            }
            return if (resL == Int.MAX_VALUE) "" else s.substring(res.first, res.second + 1)
        }
    }
}