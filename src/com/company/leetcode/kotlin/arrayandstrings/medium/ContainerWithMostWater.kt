package com.company.leetcode.kotlin.arrayandstrings.medium

import kotlin.math.max
import kotlin.math.min

class ContainerWithMostWater {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun maxArea(height: IntArray): Int {
            var l = 0
            var r = height.size - 1
            var res = 0
            while (l < r) {
                val lh = height[l]
                val rh = height[r]
                val area = (r - l) * min(lh, rh)
                res = max(area, res)
                if (lh < rh) {
                    l++
                } else {
                    r--
                }
            }
            return res
        }
    }

}