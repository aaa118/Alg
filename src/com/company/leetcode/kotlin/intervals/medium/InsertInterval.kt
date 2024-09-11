package com.company.leetcode.kotlin.intervals.medium

import kotlin.math.max
import kotlin.math.min

/**
 *
 */
class InsertInterval {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            var newInt = newInterval
            var res = mutableListOf<IntArray>()
            for (i in intervals.indices) {
                if (newInt[1] < intervals[i][0]) {
                    res.add(newInt)
                    for (j in i until intervals.size) res.add(intervals[j])
                    return res.toTypedArray()
                } else if (newInt[0] > intervals[i][1]) {
                    res.add(intervals[i])
                } else {
                    // is Overlapping
                    newInt = intArrayOf(min(newInt[0], intervals[i][0]), max(newInt[1], intervals[i][1]))
                }
            }
            res.add(newInt)
            return res.toTypedArray()
        }

        fun insert2(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val result = mutableListOf<IntArray>()
            var i = 0
            val n = intervals.size

            // Add all intervals that come before newInterval
            while (i < n && intervals[i][1] < newInterval[0]) {
                result.add(intervals[i])
                i++
            }

            // Merge overlapping intervals
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = minOf(newInterval[0], intervals[i][0])
                newInterval[1] = maxOf(newInterval[1], intervals[i][1])
                i++
            }
            result.add(newInterval)

            // Add remaining intervals
            while (i < n) {
                result.add(intervals[i])
                i++
            }

            return result.toTypedArray()
        }
    }

}