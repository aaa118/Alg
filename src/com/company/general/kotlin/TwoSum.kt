package com.company.general.kotlin

class TwoSum {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val intArray = intArrayOf(2,7,11,15)
            val target = 9
            println(twoSum(intArray, target).toList().toString())

        }


        fun twoSum(nums: IntArray, target: Int): IntArray {

            val solMap = mutableMapOf<Int, Int>()

            for (i in nums.indices) {
                if (solMap.containsKey(nums[i] - target)) {
                    val key = solMap[nums[i]]
                    if (key != null) return intArrayOf(key, i)
                } else {
                    solMap[nums[i]] = i
                }
            }

            return intArrayOf()
        }

    }

}