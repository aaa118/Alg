package com.company.leetcode.kotlin.medium

class PermutationInAString {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(checkInclusion("ab", "eidbaooo"))

        }
        fun checkInclusion(s1: String, s2: String): Boolean {
            if (s1.length > s2.length) return false
            var s1A = IntArray('z' - 'a' + 1)
            var s2A = IntArray('z' - 'a' + 1)

            for (i in s1.indices) {
                s1A['z' - s1[i]]++
                s2A['z' - s2[i]]++
            }
            for (i in 0 until s2.length - s1.length) {
                if (s1A.contentEquals(s2A)) return true

                s2A['z' - s2[i]]--
                s2A['z' - s2[i + s1.length]]++
            }
            return s1A.contentEquals(s2A)
        }
    }
}