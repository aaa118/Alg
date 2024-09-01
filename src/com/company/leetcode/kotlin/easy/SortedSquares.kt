package com.company.leetcode.kotlin.easy

class SortedSquares {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intArray = intArrayOf(-4,-1,0,3,10)
            val intArray1 = intArrayOf(-7,-6,2,3,4)


            println(sortedSquares(intArray1).asList())

        }

        private fun sortedSquares(arr: IntArray): IntArray {
            val nums = IntArray(arr.size)
            var l = 0
            var r = nums.size - 1
            var i = nums.size - 1

            while (l <= r) {
                if (arr[l] * arr[l] > arr[r] * arr[r]) {
                    nums[i] = arr[l] * arr[l]
                    l++
                } else {
                    nums[i] = arr[r] * arr[r]
                    r--
                }
                i--
            }

            return nums

        }
    }
}