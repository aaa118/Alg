package com.company.general.kotlin.strings

class LongestPalindromeSubString {

    companion object {

        private var res = ""
        private var longResLength = -1

        @JvmStatic
        fun main(args: Array<String>) {


//            println(checkLongestPalindromeSubString("babad"))
//            println(checkLongestPalindromeSubString("cbbd"))
//            println(longestPalindrome("aaaa"))
            println(longestPalindrome("cbbd"))
            println(longestPalindrome("babad"))
            var string = "asenta a tna n AA"

        }


        private fun longestPalindrome(string: String): String {


            for (char in string) {
                char.lowercaseChar()
                char.isLetterOrDigit()
            }
            for (index in string.indices) {
                checkP(index, index, string)
                checkP(index, index + 1, string)
            }
            return res
        }

        private fun checkP(fIndex: Int, sIndex: Int, string: String) {
            var i = fIndex
            var j = sIndex
            while (i >= 0 && j < string.length && string[i] == string[j]) {
                if (j - i + 1 > longResLength) {
                    res = string.substring(i, j + 1)
                    longResLength = j - i + 1
                }
                i--
                j++
            }
        }
    }
}