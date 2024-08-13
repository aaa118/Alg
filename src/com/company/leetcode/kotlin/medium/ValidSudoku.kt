package com.company.leetcode.kotlin.medium

class ValidSudoku {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun isValidSudoku(board: Array<CharArray>): Boolean {
            val rowRecord = Array(9) { mutableSetOf<Int>() }
            val columnRecord = Array(9) { mutableSetOf<Int>() }
            val subBoxRecord = Array(9) { mutableSetOf<Int>() }


            for (i in 0 until 9) {
                for (j in 0 until 9) {
                    if (!board[i][j].isDigit()) continue
                    val value = Character.getNumericValue(board[i][j])
                    if (value in columnRecord[i]) return false
                    else columnRecord[i].add(value)
                    // rows
                    if (value in rowRecord[i]) return false
                    else rowRecord[i].add(value)
//
//                    if (value in subBoxRecord[j / 3][i / 3]) return false
//                    // add the element to the hashset of the corresponding sub 3x3 matrix
//                    subBoxRecord[j / 3][i / 3].add(value)

                }
            }
            return true


        }
    }
}