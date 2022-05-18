package com.company.algoexpert.kotlin.arrays.medium

class MoveElementToEnd {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = mutableListOf(2, 1, 2, 2, 2, 3, 4, 2)
            println(moveElementToEnd(list, 2))
        }

        private fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
            // Write your code here.
            var i = 0
            var j = array.size - 1
            while (i < j) {
                val p1 = array[i]
                while (array[j] == toMove && i < j) {
                    j--
                }
                if (p1 == toMove) {
                    swap(array, i, j)
                }
                i++
            }
            return array
        }

        private fun swap(array: MutableList<Int>, i: Int, j: Int) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }

    }
}