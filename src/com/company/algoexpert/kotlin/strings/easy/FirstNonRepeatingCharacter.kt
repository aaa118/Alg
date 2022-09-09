package com.company.algoexpert.kotlin.strings.easy

class FirstNonRepeatingCharacter {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun firstNonRepeatingCharacter(string: String): Int {
            // Write your code here.

            val hMap = HashMap<Char, Int>()
            for (ch in string) {
                if (hMap.contains(ch)) {
                    var int = hMap[ch]
                    if (int != null) {
                        hMap[ch] = int + 1
                    }
                }  else {
                    hMap[ch] = 1
                }
            }

            for (i in string.indices) {

            }

                return -1
        }
    }
}