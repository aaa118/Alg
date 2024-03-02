package com.company.leetcode.kotlin.medium

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
class IsValidSudoku {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board1 = arrayOf(charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'), charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'), )
//            val board2 =
//                [
//                    [".",".","4",".",".",".","6","3","."],
//                    [".",".",".",".",".",".",".",".","."],
//                    ["5",".",".",".",".",".",".","9","."],
//                    [".",".",".","5","6",".",".",".","."],
//                    ["4",".","3",".",".",".",".",".","1"],
//                    [".",".",".","7",".",".",".",".","."],
//                    [".",".",".","5",".",".",".",".","."],
//                    [".",".",".",".",".",".",".",".","."],
//                    [".",".",".",".",".",".",".",".","."]
//                ]
            println(isValidSudoku(board1))
        }

        private fun isValidSudoku(board: Array<CharArray>): Boolean {
            val col: Array<MutableSet<Char>> = Array(9) { hashSetOf() }
            val row: Array<MutableSet<Char>> = Array(9) { hashSetOf() }
            val squares: Array<Array<MutableSet<Char>>> = Array(3) { Array(3) { hashSetOf() } }

            for (i in 0 until 9) {
                for (j in 0 until 9) {
                    val c = board[i][j]
                    if (c.isDigit()) {
                        val hasAdded = col[i].add(c)
                        if (!hasAdded) return false
                        val hasAddedRow = row[i].add(c)
                        if (!hasAddedRow) return false
                        if (!squares[i/3][j/3].add(c)) return false
                    }
                }
            }
            return true
        }
    }
}