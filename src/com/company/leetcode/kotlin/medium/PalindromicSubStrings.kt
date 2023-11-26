package com.company.leetcode.kotlin.medium

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 */
class PalindromicSubStrings {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(countSubstrings("aaa"))
        }

        private val arrayOfString = mutableListOf<String>()
        private var pString = ""

        private fun countSubstrings(s: String): Int {
            for (i in s.indices) {
                checkP(i, i, s)
                checkP(i, i + 1, s)
            }
            return arrayOfString.size
        }

        private fun checkP(fI: Int, sI: Int, s: String) {
            var _fI = fI
            var _sI = sI
            while (_fI >= 0 && _sI < s.length && s[_fI] == s[_sI]) {
                pString = s.substring(_fI, _sI + 1)
                arrayOfString.add(pString)
                _fI--
                _sI++
            }
        }
    }
}