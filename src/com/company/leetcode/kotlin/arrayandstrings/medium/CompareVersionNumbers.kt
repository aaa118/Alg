package com.company.leetcode.kotlin.arrayandstrings.medium

import kotlin.math.max

/**
 * https://leetcode.com/problems/compare-version-numbers/
 */
class CompareVersionNumbers {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(compareVersion("1.2", "1.10"))
        }

        fun compareVersion(version1: String, version2: String): Int {
            var nums1 = version1.split(".").map { it.toInt() }
            var nums2 = version2.split(".").map { it.toInt() }
            println(nums1)
            println(nums2)
            val l = max(nums1.size, nums2.size)
            for (i in 0 until l) {
                val i1 = nums1.getOrElse(i) { 0 }
                val i2 = nums2.getOrElse(i) { 0 }
                when {
                    i1 > i2 -> return 1
                    i1 < i2 -> return -1
                }
            }
            return 0
        }
    }
}