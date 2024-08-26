package com.company.leetcode.kotlin.easy

class TwoSum {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val intArray = intArrayOf(2,7,11,15)
            val target = 9
            println(twoSum(intArray, target).toList().toString())
        }


        private fun twoSum(nums: IntArray, target: Int): IntArray {
            val solMap = mutableMapOf<Int, Int>()
            for (i in nums.indices) {
                val diff = target - nums[i]
                if (solMap.containsKey(diff)) {
                    val key = solMap[diff]
                    if (key != null) return intArrayOf(key, i)
                } else {
                    solMap[nums[i]] = i
                }
            }
            return intArrayOf()
        }

    }

}