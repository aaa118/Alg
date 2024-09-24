package com.company.general.kotlin.arrays

class ComputeLeftAndRightSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(2, 3, 4, 1, 4, 5)
            val arr1 = intArrayOf(1, 1, 1)
            val size = arr.size
            println(findElement(arr, size))
            println(findElement(arr1, 3))
        }

        fun findElement(arr: IntArray, size: Int): String {
            var rightSum = 0
            var leftSum = 0

            // Computing rightSum
            for (i in 1 until size) {
                rightSum += arr[i]
            }

            // Checking the point of partition i.e. leftSum == rightSum
            var i = 0
            var j = 1
            while (j < size) {
                rightSum -= arr[j]
                leftSum += arr[i]

                if (leftSum == rightSum) {
                    return "YES"
                }

                i++
                j++
            }

            return "NO"
        }


    }
}