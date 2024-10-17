package com.company.leetcode.kotlin.backtrack.medium

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/subsets/description/
 */
class Subsets {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(subsets(intArrayOf(1, 2, 3)))

            var dir = listOf(
                0 to 1,
                0 to -1,
                -1 to 0,
                -1 to -1,
                -1 to 1,
                1 to -1,
                1 to 0,
                1 to 1
            )
        }

        private fun subsets(nums: IntArray): List<List<Int>> {
            val res = mutableListOf<List<Int>>()
            val subset = mutableListOf<Int>()

            fun dfs(i: Int) {
                if (i >= nums.size) { res.add(subset.toList()); return }
                dfs(i+1)
                subset.add(nums[i])
                dfs(i+1)
                subset.remove(subset[subset.size - 1])
            }

            dfs(0)
            return res
        }
    }
}