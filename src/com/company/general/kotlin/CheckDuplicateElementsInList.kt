package com.company.general.kotlin

class CheckDuplicateElementsInList {


// To execute Kotlin code, please define a top level function named main

    /**
    Write a function that takes two int array which are the bus schedules
    return type is up to you!

    bus1 = {615, 650, 810, 900, 1201, 900, 1600, ....} M + MLogM
    bus2 = {600, 635, 810, 901, 900, 201, 1604, 900, ....} N + NlogN

    output = {810, 1201, 900, 900}
     **/


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array1 = arrayOf(615, 650, 810, 900, 1201, 900, 1600)
            val array2 = arrayOf(600, 635, 810, 901, 900, 201, 1604, 900)

            println(checkDuplicate(array1, array2))
        }

        fun checkDuplicate(array1: Array<Int>, array2: Array<Int>): MutableList<Int> {

// array1.sort()
// array2.sort()

            val dupList = mutableListOf<Int>()


// var j = 0
// var i = 0

            var hashMap = mutableMapOf<Int, Int>()

            for (i in array1) {
                if (hashMap.contains(i)) {
                    var value = hashMap[i]
                    if (value != null) hashMap[i] = value + 1
                } else {
                    hashMap[i] = 1
                }
            }


            for (j in array2) {
                if (hashMap.contains(j)) {
                    var value = hashMap[j]
                    if (value != 0) dupList.add(j)
                    if (value != null) hashMap[j] = value - 1
                }
            }

//     var time1 = 0
//     var time2 = 0

// while (i < array1.size) {
//         time1 = array1[i]
//         time2 = array2[j]
//     if (time1 < time2) {
//         i++
//     } else if (time1 == time2) {
//       dupList.add(time1)
//         i++
//         j++
//     }
//     while (time1 > time2) {
//        j++
//        time2 = array2[j]
//      }
//   }

            return dupList

        }
    }

    fun main() {
        // for (i in 1..5) println("Hello, World!")


    }


    /**
    bus1 = {1600}
    bus2 = {600, 635, 810, 901, 1201, 1600}

     **/
}