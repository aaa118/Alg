package com.company.general.kotlin.arrays

class QuickSort {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//        int[] inputArray = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
//        int[] inputArray = {8, 5, 2, 9, 6, 3};
            val inputArray = intArrayOf(8, 5, 2, 9, 7, 6, 3)


            println(quickSort(inputArray.toList() as MutableList<Int>, 0, inputArray.size - 1))
        }

        private fun quickSort(unsortedList: MutableList<Int>, i: Int, endIndex: Int): MutableList<Int> {
            var startIndex = i
            var pivotIndex = startIndex


            for (index in unsortedList.indices) {
                val num = unsortedList[index]
                val pivotNum = unsortedList[pivotIndex]
                if (num < pivotNum) {
                    swap(index, pivotIndex, unsortedList)
                    pivotIndex = index
                }
            }
            println(unsortedList)
            if (startIndex < endIndex) {
                startIndex++
            } else {
                return unsortedList
            }
            quickSort(unsortedList, startIndex, endIndex)
            return unsortedList
        }

        private fun swap(i: Int, i1: Int, unsortedList: MutableList<Int>) {
            val temp = unsortedList[i1]
            unsortedList[i1] = unsortedList[i]
            unsortedList[i] = temp
        }
    }
}