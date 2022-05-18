package com.company.general.kotlin

class ShiftArray {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val array = intArrayOf(1, 2, 3, 4, 5)
            println(shiftArray(array, 2))

        }

        private fun shiftArray(array: IntArray, n: Int): List<Int> {
            var n1 = n
            while (n1 > 0) {
                for (i in array.size - 1 downTo 1) {
                    val temp = array[i - 1]
                    array[i - 1] = array[i]
                    array[i] = temp
                }
                n1--
            }

            return array.asList()
        }
    }
}