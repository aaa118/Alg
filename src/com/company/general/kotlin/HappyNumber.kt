package com.company.general.kotlin

class HappyNumber {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(getSum(19))

        }

        fun getSum(i: Int): Boolean {
            var sum = i
            var x = i
            while (sum > 9) {
                sum = 0
                while (x > 0) {
                    var a = x % 10
                    sum += a * a
                    x /= 10
                }
                if (sum == 1 ) return true
                x = sum
            }

            return false
        }
    }


}