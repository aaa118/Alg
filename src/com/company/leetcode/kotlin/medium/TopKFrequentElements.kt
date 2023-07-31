package com.company.leetcode.kotlin.medium

class TopKFrequentElements {




    fun main() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1)
        println(topKFrequent(nums, 1))
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val res = mutableListOf<Int>()
        val count = mutableMapOf<Int, Int>()
        val freq = MutableList<MutableList<Int>>(nums.size) {
            mutableListOf()
        }


        for (num in nums) {

            count[num] = count.getOrDefault(num, 0) + 1
        }

        println("count $count")


        for ((key, v) in count) {
            println("key $key, v $v")
            // as index starts with 0
            freq[v - 1].add(key)
        }

        println("freq $freq")

        for (i in freq.size - 1 downTo 0) {
            println("i $i")
            for (n in freq[i]) {
                println("n $n")
                res.add(n)
                if (res.size == k) {
                    return res.toIntArray()
                }
            }
        }

        return intArrayOf()

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val topKFrequent = TopKFrequentElements()
            val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1)
            println(topKFrequent.topKFrequent(nums, 1).asList())
        }
    }
}