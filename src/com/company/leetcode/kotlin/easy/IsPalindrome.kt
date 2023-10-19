package com.company.leetcode.kotlin.easy

class IsPalindrome {


    companion object {


        @JvmStatic
        fun main(args: Array<String>) {

            isPalindrome("race a car")
            println(isPalindrome("A man, a plan, a canal: Panama"))

        }

        private fun isPalindrome(s: String): Boolean {
            val isLetterOrDigitOnly = s.filter { it.isLetterOrDigit() }.lowercase()
            var i = 0
            var j = isLetterOrDigitOnly.length - 1
            while (i < j) {
                if (isLetterOrDigitOnly[i] != isLetterOrDigitOnly[j]) {
                    return false
                }
                i++
                j--
            }
            return true
        }
    }
}