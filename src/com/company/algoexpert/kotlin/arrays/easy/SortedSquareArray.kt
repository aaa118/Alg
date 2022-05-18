package com.company.algoexpert.kotlin.arrays.easy

class SortedSquareArray {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val list = mutableListOf<Int>()
            list.add(1)
            list.add(1)
            println(sortedSquaredArray(list))
        }

        private fun sortedSquaredArray(array: List<Int>): List<Int> {
            val arr = IntArray(array.size)
            var lInd = array.size - 1
            var sInd = 0

            for (i in arr.size -1 downTo 0) {
                if (Math.abs(array[lInd]) > Math.abs(array[sInd])) {
                    arr[i] = array[lInd] * array[lInd]
                    lInd--
                } else {
                    arr[i] = array[sInd] * array[sInd]
                    sInd++
                }
            }
            return arr.toMutableList()
        }
    }
}