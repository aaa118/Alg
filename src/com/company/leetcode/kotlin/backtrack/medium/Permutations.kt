package com.company.leetcode.kotlin.backtrack.medium

class Permutations {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = intArrayOf(1, 2, 3)
            println(permute(array))

        }
        private fun permute(nums: IntArray): List<List<Int>> {
            val res = mutableListOf<List<Int>>()
            val used = mutableSetOf<Int>()
            fun backTrack(used: MutableSet<Int>) {
                if (nums.size == used.size) {
                    res.add(used.toList())
                    return
                }
                for (num in nums) {
                    if (used.contains(num)) {
                        continue
                    }
                    used.add(num)
                    backTrack(used)
                    used.remove(num)
                }
            }
            backTrack(used)
            return res
        }
    }
}