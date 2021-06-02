package com.company.hackerRank.kotlin

class DivisibleSumPairs {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val arrays = arrayOf(1, 3, 2, 6, 1, 2)
//            val d = 3
//            val m = 2
            val k = 3
            val n = 6
            println(divisibleSumPairs(n, k, arrays))

        }

        fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
            val bucket = IntArray(k)
            var count = 0
            for (value in ar) {
                val modValue = value % k
                count += bucket[(k - modValue) % k] // adds # of elements in complement bucket
                bucket[modValue]++ // saves in bucket
            }
            return count
        }
    }
}