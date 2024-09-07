package com.company.leetcode.kotlin.arrayandstrings

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max

class ReorganizeString {
    companion object {



    }
    fun reorganizeString(s: String): String {
        val charsCount = HashMap<Char, Int>()
        var maxCount = 0
        for (i in s.indices) {
            charsCount[s[i]] = (charsCount[s[i]] ?: 0) + 1
            if (charsCount[s[i]]!! > maxCount) {
                maxCount = charsCount[s[i]]!!
            }
            s[i].isDigit()
        }
        val linkedL = LinkedList<IntArray>()
        linkedL.last[1]
        if (maxCount <= 1) {
            return s
        }
        if (maxCount - 1 > s.length - maxCount) {
            return ""
        }
        val maxHeap = PriorityQueue<Pair<Char, Int>> { pairOne, pairTwo ->
            pairTwo.second - pairOne.second
        }
        charsCount.entries.forEach { entry ->
            maxHeap.add(entry.key to entry.value)
        }
        val result = StringBuilder()
        while (maxHeap.size > 1) {
            val maxCount1 = maxHeap.poll()
            val maxCount2 = maxHeap.poll()
            result.append("${maxCount1.first}${maxCount2.first}")
            if (maxCount1.second > 1) {
                maxHeap.add(maxCount1.first to maxCount1.second - 1)
            }
            if (maxCount2.second > 1) {
                maxHeap.add(maxCount2.first to maxCount2.second - 1)
            }
        }
        if (maxHeap.isNotEmpty()) {
            result.append(maxHeap.poll().first)
        }
        return result.toString()
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val linkedL = LinkedList<IntArray>()
        for (arr in intervals) {
            if (linkedL.isEmpty() || linkedL.last().get(1) < arr[0]) {
                linkedL.add(arr)
            } else {
                linkedL.last()[1] = max(arr[1], linkedL.last().get(1))
            }
        }
        return linkedL.toTypedArray()
    }

}