package com.company.leetcode.kotlin.medium

class Search2DMatrix {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arrrOfArr = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60) )
            println(searchMatrix(arrrOfArr, 13))

        }

        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            var rowStart = 0
            var rowEnd = matrix.size - 1
            while (rowStart <= rowEnd) {
                var rM = (rowStart + rowEnd) / 2
                var rowArr = matrix[rM]
                if (rowArr[rowArr.size - 1] > target && rowArr[0] > target) {
                    rowEnd = rM - 1
                } else if (rowArr[rowArr.size - 1] < target && rowArr[0] < target) {
                    rowStart = rM + 1
                } else if (rowArr[rowArr.size - 1] >= target && rowArr[0] <= target) {
                    var cR = matrix[rM]
                    var i = 0
                    var j = cR.size - 1
                    while (i <= j) {
                        var m = (i + j) / 2
                        if (cR[m] > target) {
                            j = m - 1
                        } else if (cR[m] < target) {
                            i = m + 1
                        } else if (cR[m] == target) {
                            return true
                        } else {
                            return false
                        }
                    }
                    return false

                } else {
                    return false
                }
            }
            return false
        }
    }
}