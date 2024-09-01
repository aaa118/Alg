package com.company.leetcode.kotlin.easy

class CheckChessBoard {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(checkTwoChessboards("a1", "c3"))

        }

        fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean {
            var char1 = coordinate1[0]
            var num1 = coordinate1[1].code - '0'.code
            var num1A = char1.code - '0'.code
            var char2 = coordinate2[0]
            var num2 = coordinate2[1].code - '0'.code
            var num2A = char2.code - '0'.code
            println( "$num1 $num2" )
            var isWhite1 = false
            if (num1A %2 != 0 && num1 % 2 == 0) {
                isWhite1 = true
            } else if (num1A %2 == 0 && num1 % 2 != 0) {
                isWhite1 = true
            }
            var isWhite2 = false
            if (num2A %2 != 0 && num2 % 2 == 0) {
                isWhite2 = true
            } else if (num2A %2 == 0 && num2 % 2 != 0) {
                isWhite2 = true
            }
            println( "$isWhite1 $isWhite2" )

            return isWhite1 == isWhite2
        }

    }
}