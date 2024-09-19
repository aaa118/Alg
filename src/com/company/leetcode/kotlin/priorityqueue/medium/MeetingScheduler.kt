package com.company.leetcode.kotlin.priorityqueue.medium

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/meeting-scheduler/?envType=weekly-question&envId=2024-09-08
 *
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration $duration, return the
 * earliest time slot that works for both of them and is of duration $duration.
 *
 * If there is no common time slot that satisfies the requirements, return an empty array.
 *
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 *
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two
 * time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 *
 * Example 1:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 *
 * Example 2:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 *
 * Constraints:
 *
 * 1 <= slots1.length, slots2.length <= 104
 * slots1[i].length, slots2[i].length == 2
 * slots1g[i][0] < slots1[i][1]
 * slots2[i][0] < slots2[i][1]
 * 0 <= slots1[i][j], slots2[i][j] <= 109
 * 1 <= duration <= 106
 */
class MeetingScheduler {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
            var stackOfLRU = LinkedList<Int>()
            stackOfLRU.push(1)
            stackOfLRU.push(2)
            stackOfLRU.addFirst(3)
            println(stackOfLRU.peek())
            var map = HashMap<Int, Int>(5).toMutableMap()
            println(map.values.size)

        }

        fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
            val minHeap = PriorityQueue<IntArray> { s1, s2 -> s1[0] - s2[0] }
            for (timeArr in slots1) {
                if (timeArr[1] - timeArr[0] >= duration) minHeap.add(timeArr)
            }
            for (timeArr in slots2) {
                if (timeArr[1] - timeArr[0] >= duration) minHeap.add(timeArr)
            }
            while (minHeap.size > 1) {
                val (s1, e1) = minHeap.poll()
                val (s2, e2) = minHeap.peek()
                if (e1 >= (s2 + duration)) return mutableListOf(s2, s2 + duration)
            }
            return mutableListOf()
        }
    }
}