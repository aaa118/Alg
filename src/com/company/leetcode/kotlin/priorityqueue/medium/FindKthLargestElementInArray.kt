package com.company.leetcode.kotlin.priorityqueue.medium

import java.util.*
import kotlin.random.Random


/**
 *
 */
class FindKthLargestElementInArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var array = intArrayOf(3,2,1,5,6,4)
            println(findKthLargest1(array, 2))
            println(findKthLargest2(array, 2))
            println(findKthLargest3(array, 2))
            println(findKthLargest4(array, 2))
        }

        /**
         * Quick Select in place traversal
         */
        fun findKthLargest4(nums: IntArray, k: Int): Int {
            val list = mutableListOf<Int>()
            for (num in nums) {
                list.add(num)
            }
            return quickSelect(list, k)
        }

        fun quickSelect(list1: MutableList<Int>, k: Int): Int {
            val list = list1
            val pivotIndex = Random.nextInt(list1.size)
            val pivot = list.get(pivotIndex)
            val l = mutableListOf<Int>()
            val m = mutableListOf<Int>()
            val r = mutableListOf<Int>()

            for (num in list) {
                if (num > pivot) {
                    l.add(num)
                } else if (num < pivot) {
                    r.add(num)
                } else {
                    m.add(num)
                }
            }
            if (k <= l.size) return quickSelect(l, k)
            if (l.size + m.size < k) return quickSelect(r, k - l.size - m.size)
            return pivot
        }
        /**
         * Using MinHeap
         */
        fun findKthLargest3(nums: IntArray, k: Int): Int {
            val heap = PriorityQueue<Int> { a, b -> a - b }

            for (num in nums) {
                heap.add(num)
                if (heap.size > k) heap.poll()
            }

            return heap.peek()
        }

        /**
         * Using Max Heap
         */
        fun findKthLargest1(nums: IntArray, k: Int): Int {
            val heap = PriorityQueue<Int> { a, b -> b - a }

            for (num in nums) {
                heap.add(num)
            }

            var i = 1
            while (k > i) {
                heap.poll()
                i++
            }
            return heap.peek()
        }

        /**
         * Using QuickSelect
         */
        fun findKthLargest2(nums: IntArray, k: Int): Int {
            return pivotSearch(0, nums.size - 1, nums, k)
        }

        private fun pivotSearch(l: Int, r: Int, nums: IntArray, k: Int): Int {
            var p = l
            var pivot = r
            for (i in l .. r) {
                if (nums[i] < nums[pivot]) {
                    var temp = nums[i]
                    nums[i] = nums[p]
                    nums[p] = temp
                    p++
                }
            }
            val temp = nums[p]
            nums[p] = nums[pivot]
            nums[pivot] = temp
            return if (p > nums.size - k) pivotSearch(l, p - 1, nums, k)
            else if (p < nums.size - k) pivotSearch(p + 1, r, nums, k)
            else return nums[p]
        }
    }

}