package com.company.leetcode.kotlin.medium

class ContainerWithWater {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(1,8,6,2,5,4,8,3,7)
            maxArea(nums)

        }

        fun maxArea(height: IntArray): Int {
            if (height.size == 2) {
                if (height[0] < height[1]) {
                    return height[0]* height[0]
                } else {
                    return height[1]* height[1]
                }
            }

            var i = 0
            var j = height.size - 1
            var areaF = 0

            while (i < j) {
                val f = height[i]
                val s = height[j]
                val min = Math.min(f, s)
                val area = s * (j - i)
                if (area > areaF) {
                    areaF = area
                }
                if (f < s) {
                    ++i
                } else {
                    --j
                }

            }
            return areaF
        }
    }

    data class Node(
        val value: Int,
        val min: Int,
        var node: Node? = null,
    )

    var cMin = Integer.MAX_VALUE
    var top: Node? = null

    fun push(value: Int) {
        val min = if (value < cMin) value else cMin
        val node = Node(value, min)
        node.node = top
        top = node
    }

    fun pop() {
        top = top?.node
    }

    fun top(): Int {
        return top?.value ?: throw IllegalStateException("empty")
    }

//    fun getMin(): Int {
//        top?.min ?:throw IllegalStateException("empty")
//    }
}