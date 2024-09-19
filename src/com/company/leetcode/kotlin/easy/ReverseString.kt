package com.company.leetcode.kotlin.easy

class ReverseString {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
         g<   val s = charArrayOf('h', 'e', 'l', 'l', 'o')
//            s.reverse()
            reverseString(s)
            println(s)
        }

        private fun reverseString(s: CharArray) {
            val midPoint = (s.size / 2) - 1
            if (midPoint < 0) return
            var reverseIndex = s.lastIndex
            for (index in 0..midPoint) {
                val tmp = s[index]
                s[index] = s[reverseIndex]
                s[reverseIndex] = tmp
                reverseIndex--
            }

        }

        private fun reverseString1(s: CharArray) {
            var start = 0
            var end = s.size - 1

            while (start < end) {
                val temp = s[start]
                s[start] = s[end]
                s[end] = temp
                start++
                end--
            }
        }
    }


}