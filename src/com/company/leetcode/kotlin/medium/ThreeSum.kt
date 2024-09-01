package com.company.leetcode.kotlin.medium

class ThreeSum {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val nums = intArrayOf(-1,0,1,2,-1,-4)
//            val nums = intArrayOf(0,1,1)
//            val nums = intArrayOf(0,0, 0)
            val nums = intArrayOf(0,0,0,0)
            println(threeSum(nums))
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
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