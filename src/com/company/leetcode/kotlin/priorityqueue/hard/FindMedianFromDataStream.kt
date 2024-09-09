package com.company.leetcode.kotlin.priorityqueue.hard

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
class FindMedianFromDataStream {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        /**
         * Your MedianFinder object will be instantiated and called as such:
         * var obj = MedianFinder()
         * obj.addNum(num)
         * var param_2 = obj.findMedian()
         */
        class MedianFinder() {
            /*
               The maxHeap has smaller values and is sorted from smaller to larger, so that we have access to the
               largest element from the smaller half of the elements.
             */
            val maxHeap = PriorityQueue<Int> { a, b -> b - a }

            /*
               The minHeap has larger values and is sorted from larger to smaller, so that we have access to
               the smallest element from the larger half of the elements.
             */
            val minHeap = PriorityQueue<Int> { a, b -> a - b }
            var len = 0

            fun addNum(num: Int) {
                // If the number being inserted is larger than the largest value in the smaller heap (the top value),
                // then it should go in the larger heap.
                // Otherwise it goes in the smaller heap
                if (minHeap.size > 0 && num > maxHeap.peek()) {
                    minHeap.add(num)
                } else {
                    maxHeap.add(num)
                }
                /*
                Now the values are divided into the
                larger and smaller heaps appropriately
                but we need to check if one is too big.

                Each heap should have the same amount, or
                one of them can be consistently 1 bigger
                (in this case I chose the smaller heap
                to be allowed to be 1 bigger).
                If the larger heap has more values, smallest
                value of the larger heap (the top of the heap)
                needs to be moved to the smaller heap to
                maintain the correct size for each.
                */
                if (maxHeap.size < minHeap.size) {
                    maxHeap.add(minHeap.poll())
                } else if (maxHeap.size > minHeap.size + 1) {
                    minHeap.add(maxHeap.poll())
                }
                len++
            }

            fun findMedian(): Double {
                if (len % 2 == 0) {
                    return (maxHeap.peek() + minHeap.peek()).toDouble() / 2
                } else {
                    return maxHeap.peek().toDouble()
                }

            }

        }

    }
}