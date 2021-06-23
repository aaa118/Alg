package com.company.general.kotlin

import java.io.File
import java.math.BigInteger
import java.util.*


class CountSplitInversions {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val fileName = "src/test.txt"

            val lines: List<String> = File(fileName).readLines()

            val list = mutableListOf<BigInteger>()

            val arr = LongArray(100000)
            lines.forEach { line ->
//                var i = 0
//                arr[i] = line.toLong()
//                i++


//                println(line)

                list.add(line.toBigInteger())

            }
//            println(list.toString())
//            val arr = list.toIntArray()
//            val arr = intArrayOf(4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54)
//            val arr = IntArray(list.size) { it }
//            for (int in arr) {
//                println(int)
//            }
//            println(arr.toString())

//            println(CountingInversions.getInvCount(arr.size, arr))





//            println(mergeSortAndCount(arr, 0, arr.size - 1))
            println(mergeSortAndCount(list, 0, list.size - 1))
//            println(getInvCount(arr.size - 1, arr))
        }

        fun getInvCount(n: Int, arr: IntArray): Int {
            var inv_count = 0
            for (i in 0 until n - 1) for (j in i + 1 until n) if (arr.get(i) > arr.get(j)) inv_count++
            return inv_count
        }



        // Function to count the number of inversions
        // during the merge process
        private fun mergeAndCount(arr: MutableList<BigInteger>, l: Int,
                                  m: Int, r: Int): Int {

            // Left subarray
//            val left = Arrays.copyOfRange(arr, l, m + 1)
            val left = arr.subList(l, m + 1)

            // Right subarray
//            val right = Arrays.copyOfRange(arr, m + 1, r + 1)
            val right = arr.subList(m + 1, r + 1)
            var i = 0
            var j = 0
            var k = l
            var swaps = 0
            while (i < left.size && j < right.size) {
                if (left[i] <= right[j]) arr[k++] = left[i++] else {
                    arr[k++] = right[j++]
                    swaps += m + 1 - (l + i)
                }
            }
            while (i < left.size) arr[k++] = left[i++]
            while (j < right.size) arr[k++] = right[j++]
            return swaps
        }

        // Merge sort function
        private fun mergeSortAndCount(arr: MutableList<BigInteger>, l: Int,
                                      r: Int): Int {

            // Keeps track of the inversion count at a
            // particular node of the recursion tree
            var count = 0
            if (l < r) {
                val m = (l + r) / 2

                // Total inversion count = left subarray count
                // + right subarray count + merge count

                // Left subarray count
                count += mergeSortAndCount(arr, l, m)

                // Right subarray count
                count += mergeSortAndCount(arr, m + 1, r)

                // Merge count
                count += mergeAndCount(arr, l, m, r)
            }
            return count
        }
    }
}