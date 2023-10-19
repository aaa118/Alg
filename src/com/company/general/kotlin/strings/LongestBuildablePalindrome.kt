package com.company.general.kotlin.strings

/*
Write a function that will generate one of the longest possible palindromes buildable from the characters within a given string

For example:
abczyx => a (any one of the characters would have been fine)
bbaac => abcba
aabbcc => abccba
bbbbbaac  => bbacabb
*/
class LongestBuildablePalindrome {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(longestPalindrome("bbbbbaac"))
            println(longestPalindrome("aabbcc"))
            println(longestPalindrome("bbaac"))
            println(longestPalindrome("abczyx"))

            println(largestPalindrome("bbbbbaac"))
            println(largestPalindrome("aabbcc"))
            println(largestPalindrome("bbaac"))
            println(largestPalindrome("abczyx"))
        }

        private fun longestPalindrome(string: String): String {
            val hashSet = mutableSetOf<Char>()
            val stringBuilder = StringBuilder()
            for (i in string) {
                if (hashSet.contains(i)) {
                    stringBuilder.append(i.toString())
                    stringBuilder.append(i.toString())
                    hashSet.remove(i)
                } else {
                    hashSet.add(i)
                }
            }
            if (hashSet.size > 0) {
                stringBuilder.append(hashSet.first().toString())
            }
            val length = stringBuilder.length
            val finalString = StringBuilder(stringBuilder.length)

            var i = 0
            while (i < length) {
                if (i % 2 == 0) {
                    finalString.append(stringBuilder[i])
                }
                i++
            }
            var j = length - 1
            while (j > 0) {
                if (j % 2 != 0) {
                    finalString.append(stringBuilder[j])
                }
                j--
            }
            return finalString.toString()
        }

        private fun largestPalindrome(string: String): String {
            val pairedChars = mutableListOf<Char>()
            val stringAsChars = string.toCharArray()
            val leftoverChars = string.toMutableList()
            for ((letterIndex, letter) in stringAsChars.toSet().withIndex()) {
                val size = stringAsChars.filter { it == letter }.size
                if (size >= 1) {
                    // println("Size is $size > 1 for letter $letter, checking pairs")
                    val numPairs = size / 2
                    // println("numPairs = $numPairs for letter $letter")
                    for (i in 1..numPairs) {
                        pairedChars.add(letter)
                        leftoverChars.remove(letter)
                        leftoverChars.remove(letter)
                        // println("added letter $letter to pairedChars: $pairedChars\nand removed from leftoverChars $leftoverChars")
                    }
                }
            }
            var palindrome = ""
            println("leftoverChars from $string = $leftoverChars")
            if (leftoverChars.size > 0) {
                palindrome = leftoverChars[0].toString()
            }

            for (pairedChar in pairedChars) {
                palindrome = "${pairedChar}${palindrome}${pairedChar}"
            }
            // println("Palindrome from pairs: $palindrome")

            if (palindrome.isEmpty() && string.isNotEmpty()) {    //take any char
                // println("Palindrome needs any char")
                palindrome = string.substring(0, 1)
            }
//        println("largestPalindrome($string) = $palindrome")
//            Log.d("sandboxlog", "largestPalindrome($string) = $palindrome")

            return palindrome
        }
    }


}
