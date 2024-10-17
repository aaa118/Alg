package com.company.advancedAlgo.arrays

import kotlin.math.max

/**
 *
 */
class Kadanes {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        fun kadanes(nums: IntArray): Int {
            var maxSum = nums[0]
            var curSum = 0

            for (n in nums) {
                curSum = max(curSum.toDouble(), 0.0).toInt()
                curSum += n
                maxSum = max(maxSum.toDouble(), curSum.toDouble()).toInt()
            }
            return maxSum
        }

        /**
         * Sliding window variation
         */
        fun slidingWindow(nums: IntArray): IntArray {
            var maxSum = nums[0]
            var curSum = 0
            var maxL = 0
            var maxR = 0
            var L = 0

            for (R in nums.indices) {
                if (curSum < 0) {
                    curSum = 0
                    L = R
                }
                curSum += nums[R]
                if (curSum > maxSum) {
                    maxSum = curSum
                    maxL = L
                    maxR = R
                }
            }
            return intArrayOf(maxL, maxR)
        }

    }
}