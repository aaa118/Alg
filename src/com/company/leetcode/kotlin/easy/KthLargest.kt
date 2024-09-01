package com.company.leetcode.kotlin.easy

import java.util.*


class KthLargest(k: Int, nums: IntArray) {

    val priorityQueue = PriorityQueue<Int>()
    var _k = 0

    init {
        addAll(nums)
        _k = k
    }

    fun addAll(nums: IntArray) {
        for (num in nums) {
            priorityQueue.offer(num)
        }
        while (priorityQueue.size > _k) {
            priorityQueue.poll()
        }
    }

    fun add(`val`: Int): Int {
        priorityQueue.offer(`val`)

        while (priorityQueue.size > _k) {
            priorityQueue.poll()
        }
        return priorityQueue.peek()

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            var obj = KthLargest(3, nums)

        }
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */

