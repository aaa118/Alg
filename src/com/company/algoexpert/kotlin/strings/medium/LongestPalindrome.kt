package com.company.algoexpert.kotlin.strings.medium

class LongestPalindrome {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(longestPalindromicSubstring2("abaxyzzyxf"))
            println(longestPalindromicSubstring2("b12365456321b"))
        }

        fun longestPalindromicSubstring(string: String): String {
            // Write your code here.
            var lS = ""

            if (string.length == 1) return string

            for (i in 0 until string.length) {
                var j = string.length - 1
                while (i < j) {
                    if (string[i] != string[j]) {
                        j--
                    } else {
                        val sS = string.substring(i, j + 1)
                        val isT = checkP(sS)
                        if (isT && sS.length > lS.length) {
                            lS = sS
                        }
                        break
                    }
                }

            }
            return lS
        }

        private fun checkP(sS: String): Boolean {
            var j = sS.length - 1
            var i = 0
            while (i < j) {
                if (sS[i] == sS[j]) {
                    i++
                    j--
                } else {
                    return false
                }
            }
            return true
        }

        private fun longestPalindromicSubstring2(string: String): String {
            // Write your code here.
            var lS = Pair(0, 1)
            var l = ""
            for (i in string.indices) {
                val b1 = checkP(i - 1, i + 1, string)
                if (b1.second - lS.second > 0 && b1.first - lS.first > 0) {
                    l = string.substring(b1.first + 1, b1.second)
                }
                val b2 = checkP(i, i + 1, string)
                if (b2.second - lS.second > 0 && b2.first - lS.first > 0) {
                    l = string.substring(b2.first + 1, b2.second)
                }
            }
            return l
        }

        private fun checkP(i: Int, j: Int, string: String): Pair<Int, Int> {
            if (i < 0) return Pair(0, 0)
            var _i = i
            var _j = j
            var isP = false
            while (_i >= 0 && _j < string.length) {
                if (string[_i] == string[_j]) {
                    isP = true
                    _i--
                    _j++
                } else if (isP) {
                    return Pair(_i, _j)
                } else {
                    return Pair(0, 1)
                }

            }
            return Pair(0, 1)
        }
    }
}