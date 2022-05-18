package com.company.algoexpert.kotlin.arrays.medium

class MonotonicArray {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = mutableListOf(-1, -1, -1, -1, -1, -1, -1, -1)

            val solution1 = Solution1()
            println(solution1.isMonotonic(list))
        }


    }

    class Solution1 {
        fun isMonotonic(array: List<Int>): Boolean {

            if (array.size < 3) {
                return true
            }
            var i = 0
            while (i < array.size - 1) {
                if (array[i] < array[i + 1]) {
                    return decA(array, i + 1)
                } else if (array[i] > array[i + 1]) {
                    return incA(array, i + 1)
                } else {
                    i++
                }
            }
            return true
        }

        fun decA(array: List<Int>, ind: Int): Boolean {
            for (i in ind until array.size - 1) {
                if (array[i] > array[i + 1]) {
                    return false
                }
            }
            return true
        }

        fun incA(array: List<Int>, ind: Int): Boolean {
            for (i in ind until array.size - 1) {
                if (array[i] < array[i + 1]) {
                    return false
                }

            }
            return true
        }
    }

    class Solution2 {
        // O(n) time | O(1) space - where n is the length
        fun isMonotonic(array: List<Int>): Boolean {
            if (array.size <= 2) return true
            var direction = array[1] - array[0]
            for (i in 2 until array.size) {
                if (direction == 0) {
                    direction = array[i] - array[i - 1]
                    continue
                }
                if (breaksDirection(direction, array[i - 1], array[1])) {
                    return false
                }
            }
            return true
        }

        private fun breaksDirection(direction: Int, previousInt: Int, currentInt: Int): Boolean {
            val difference = currentInt - previousInt
            if (direction > 0) return difference < 0
            return difference > 0
        }
    }

    class Solution3 {

        // O(n) time | O(1) space - where n is the length of the array
        fun isMonotonic(array: List<Int>): Boolean {
            var isNonDecreasing = true
            var isNonIncreasing = true
            for (i in 1 until array.size) {
                if (array[i] < array[i - 1]) isNonDecreasing = false
                if (array[i] > array[i - 1]) isNonIncreasing = false
            }
            return isNonDecreasing || isNonIncreasing
        }
    }
}