package com.company.leetcode.kotlin.medium

class FindMinInRotatedSortedArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val intArray = intArrayOf(3,4,5,1,2)
            val intArray = intArrayOf(5,1,2,3,4)
            println(findMin(intArray))
        }
        private fun findMin(nums: IntArray): Int {
            var l = 0; var r = nums.size - 1
            if (nums.size == 1) return nums[0]
            if (nums.size == 2) return Math.min(nums[0], nums[1])
            if (nums[0] < nums[nums.size - 1]) return nums[l]

            var pS = Int.MAX_VALUE
            while (l <= r) {
                val m = (l + r) / 2
                if (nums[m] > nums[l]) {
                    l = m + 1
                } else {
                    r = m - 1
                }
                if (nums[m] < pS) pS = nums[m]
            }
            return pS
        }
    }
}