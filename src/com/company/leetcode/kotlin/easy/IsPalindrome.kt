package com.company.leetcode.kotlin.easy

class IsPalindrome {

/**
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Example 4:
 * Input: s = ".,"
 * Output: true
 * Explanation: Same as Example 3
 *
 * Constraints:
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 *
 * Hint:
 *  // Returns true if this character is a letter or digit.
 *  fun Char.isLetterOrDigit(): Boolean
 *
 */

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(isPalindrome("A man, a plan, a canal: Panama"))
            println(isPalindrome("race a car"))
            println(isPalindrome(" "))
            println(isPalindrome(".,"))
        }

        private fun isPalindrome(s: String): Boolean {
            var i = 0
            var j = s.length - 1
            while (i < j) {
                while (!isLetterOrDigit(s[i])) {
                    i++
                    if (i > j) return true
                }
                while (!isLetterOrDigit(s[j])) {
                    j--
                }
                if ( s[i].lowercase() != s[j].lowercase()) return false
                i++
                j--
            }
            return true
        }

        private fun isLetterOrDigit(c : Char) : Boolean {
            return ((c in 'a' .. 'z') || (c in 'A' .. 'Z') || (c in '0' .. '9'))
        }

        private fun isPalindrome2(s: String): Boolean {
            val isLetterOrDigitOnly = s.lowercase().filter { it.isLetterOrDigit() }
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