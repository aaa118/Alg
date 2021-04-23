package com.company.hackerRank.kotlin

class TheBirthdayBar {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayOfDates = arrayOf(1, 2, 1, 3, 2)
            val d = 3
            val m = 2

            println(birthday(arrayOfDates, d, m))

        }


        private fun birthday(s: Array<Int>, d: Int, m: Int): Int {
            var counter = 0
            for (i in s.indices) {
                if (m == 1) {
                    if (s[i] == d) {
                        counter++
                    }
                }

                var len = i + 1
                var index = i
                while (len < m) {
                    var rSum = s[index]
                    val sum = s[index + 1] + rSum
                    len++
                    if (sum == d && len == m) {
                        counter++
                        continue
                    }
                    index++
                    rSum = sum
                }

            }

            return counter

        }
    }


}