package com.company.leetcode.kotlin.arrayandstrings.medium

import kotlin.math.max
import kotlin.math.min

class ThreeSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(threeSum(intArrayOf(-1,0,1,2,-1,-4)))
            println(threeSum(intArrayOf(-2,0,0,2,2)))
            println(threeSum(intArrayOf(0,0,0)))
        }
        private fun threeSum(nums: IntArray): List<List<Int>> {
            val res = mutableListOf<List<Int>>()
            nums.sort()
            var i = 0
            while (i < nums.size - 1) {
                var l = i + 1
                var r = nums.size - 1
                while (l < r) {
                    val sum = nums[i] + nums[l] + nums[r]
                    if (sum > 0) {
                        r--
                    } else if (sum < 0) {
                        l++
                    } else {
                        res.add(mutableListOf(nums[i],nums[l], nums[r]))
                        while (l + 1 < nums.size - 1 && nums[l] == nums[l + 1]) l++
                        l++
                        while (r - 1 > 0 && nums[r] == nums[r - 1]) r--
                        r--
                    }
                }
                while (i + 1 < nums.size - 1 && nums[i] == nums[i + 1]) i++
                i++
            }
            return res
        }

        fun threeSum2(nums: IntArray): List<List<Int>> {
            val answer: MutableList<MutableList<Int>> = mutableListOf()
            for (i in nums.indices)
                nums.sort()
            val s = 0
            var i = s
            var j = s + 1
            var k = nums.size - 1
            if (nums.size == 3) {
                val sum = nums[0] + nums[1] + nums[2]
                if (sum != 0) {
                    return answer
                } else {
                    answer.add(mutableListOf(nums[0], nums[1], nums[2]))
                    return answer
                }
            }
            while (i < nums.size - 2) {
                while (j < k) {
                    val sum = nums[i] + nums[j] + nums[k]
                    if (sum > 0) {
                        k--
                    } else if (sum < 0) {
                        j++
                    } else {
                        answer.add(mutableListOf(nums[i], nums[j], nums[k]))
                        k--
                        j++
                        while (j<k && nums[j] == nums[j-1]) {
                            j++
                        }
                        while (k>j && nums[k]== nums[k+1]) {
                            k--
                        }
                    }
                }
                i++
                while (i < nums.size - 1 && nums[i] == nums[i-1]) {
                    i++
                }
                j = i + 1
                k = nums.size - 1

            }
            return answer
        }
    }
}