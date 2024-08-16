package com.company.leetcode.kotlin.medium

class KokoEatingBananas {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val nums = intArrayOf(3,6,7,11)
//            println(minEatingSpeed(nums, 8))
            val nums = intArrayOf(805306368,805_306_368,805306368)
            println(minEatingSpeed(nums, 1_000_000_000))
//            val nums = intArrayOf(831_235_932,437082868,576572631,529869153,55330371,511060323,581115062,931692072,600856556,519045509,504164418,431105822,580257183)
//            println(minEatingSpeed(nums, 964_065_706))
        }

        private fun minEatingSpeed(piles: IntArray, h: Int): Int {
            var min = 1
            var max = piles.maxOrNull() ?: Int.MIN_VALUE
            var k = Int.MAX_VALUE
//            if (h > max) return piles.size
            while (min <= max) {
                val mid = (min + max) / 2
                var sum : Double = 0.0
                for (p in piles) {
                    val speed = Math.ceil(p / mid.toDouble())
                    sum += speed
                }
                if (sum > h) {
                    min = mid + 1
                } else {
                    max = mid - 1
                    k = Math.min(k, mid)
                }

            }
            return k
        }
    }
}