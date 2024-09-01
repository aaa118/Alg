package com.company.general.kotlin

class LineSegments {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val arrayOfL =
                arrayOf(intArrayOf(16, 18), intArrayOf(6, 8), intArrayOf(2, 10), intArrayOf(20, 26), intArrayOf(5, 14), intArrayOf(25,30), intArrayOf(21, 24))

            for (array in findContinuousLines(arrayOfL)) {
                println(array.contentToString())
            }
        }

        private fun findContinuousLines(arrayOfL: Array<IntArray>): Array<IntArray> {

            arrayOfL.sortBy { it[0] }

            val finalArray = Array(arrayOfL.size) { IntArray(arrayOfL[0].size) }

            var firstElement = arrayOfL[0][0]
            var lastSegment = arrayOfL[0][1]
            var positionToAddAt = 0
            var last1stEAdded = 0
            var last2ndEAdded = 0
            for (intArray in arrayOfL) {
                if (intArray[1] > lastSegment && intArray[0] < lastSegment) {
                    lastSegment = intArray[1]
                } else if (intArray[1] > lastSegment && intArray[0] > lastSegment) {
                    finalArray[positionToAddAt] = intArrayOf ( firstElement, lastSegment)
                    last1stEAdded = firstElement
                    last2ndEAdded = lastSegment
                    positionToAddAt++
                    firstElement = intArray[0]
                    lastSegment = intArray[1]
                }
            }
            if (firstElement > last1stEAdded && lastSegment > last2ndEAdded) {
                finalArray[positionToAddAt] = intArrayOf ( firstElement, lastSegment)
            }

            return finalArray.filter { array -> (array[0] > 0 && array[1] > 0) }.toTypedArray()

        }
    }
}