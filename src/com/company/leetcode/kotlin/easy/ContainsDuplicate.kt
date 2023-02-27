package com.company.leetcode.kotlin.easy

class ContainsDuplicate {

    fun containsDuplicate(nums: IntArray): Boolean {
        val finalMap = mutableMapOf<Int, Boolean>()
        for (i in nums) {
            if (finalMap.containsKey(i)) return true
            else finalMap[i] = false
        }
        return false
    }
}