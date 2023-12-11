package com.company.leetcode.kotlin.easy

class IsPalindrome {

    /**
     *
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
     * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     *
     *
     * Constraints:
     *
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
        }

        private fun isPalindrome(s: String): Boolean {
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