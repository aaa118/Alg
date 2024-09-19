package com.company.leetcode.kotlin.priorityqueue.medium

import java.util.*

class MeetingRoomsII {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
        fun minMeetingRooms(intervals: Array<IntArray>): Int {
            intervals.sortBy { it[0] } // sort by starting time

            val minHeap = PriorityQueue<Int>() // store end meetings time
            var peak = 0
            for ((start, end) in intervals) {
                while (minHeap.isNotEmpty() && minHeap.peek() <= start) {
                    minHeap.poll() // Use poll() to remove the element
                }
                minHeap.offer(end) // Use add() to insert an element
                peak = maxOf(peak, minHeap.size)
            }
            return peak
        }
    }
}