package com.company.hackerRank.kotlin

class TheBirthdayBar {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val arrayOfDates = arrayOf(1, 2, 1, 3, 2)
            val arrayOfDates = arrayOf(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)
//            val d = 3
//            val m = 2
            val d = 18
            val m = 7

            println(birthday(arrayOfDates, d, m))

        }


//        private fun birthday(s: Array<Int>, d: Int, m: Int): Int {
//            var counter = 0
//            for (i in s.indices) {
//                if (m == 1) {
//                    if (s[i] == d) {
//                        counter++
//                    }
//                }
//
//                var len = 1
//                var index = i
//                var rSum = s[index]
//                while (len < m && index < s.size - 1 && rSum < d) {
//                    val sum = s[index + 1] + rSum
//                    len++
//                    if (sum == d && len == m) {
//                        counter++
//                    }
//                    index++
//                    rSum = sum
//                }
//                len = 1
//
//            }
//            return counter
//        }

        fun birthday(s: Array<Int>, d: Int, m: Int): Int {
            var sum = 0
            var ways = 0
            for (i in 0 until m) {
                sum += s[i]
            }
            for (i in 0 until s.size - m + 1) {
                if (sum == d) {
                    ways++
                }
                if (i + m < s.size) {
                    sum = sum - s[i] + s[i + m]
                }
            }
            return ways
        }
    }


}