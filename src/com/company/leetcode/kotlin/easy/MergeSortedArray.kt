package com.company.leetcode.kotlin.easy

class MergeSortedArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intArray1 = intArrayOf(4,5,6,0,0,0)
            val m = 3
            val intArray2 = intArrayOf(1,2, 3)
            val n = 3

            println(merge(intArray1, m, intArray2, n))
        }

        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var n1 = n - 1
            var i = nums1.size - 1
            var m1 = m - 1
            // if (m == 0) nums1 = nums2
            while (i >= 0 && n1 >= 0) {
//                if (m1 == -1) {
//                    nums1[i] = nums2[n1]
//                    break
//                }
                if (nums2[n1] > nums1[i]) {
                    nums1[i] = nums2[n1]
                    n1--
                } else {
                    var temp = nums1[i]
                    nums1[i] = nums1[m1]
                    nums1[m1] = temp
                    m1--
                }
                i--
            }
            println(nums1.toList())
        }
    }
}