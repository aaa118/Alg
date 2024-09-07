package com.company.leetcode.kotlin.easy

class MergeSortedArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intArray1 = intArrayOf(4,5,6,0,0,0)
            val m = 3
            val intArray2 = intArrayOf(1,2, 3)
            val n = 3
            var map = mutableMapOf<Char, List<Char>>()
            map['2'] = mutableListOf('a','b','c',)

            println(merge(intArray1, m, intArray2, n))
        }

        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var n1 = n - 1
            var i = nums1.size - 1
            var m1 = m - 1
            // if (m == 0) nums1 = nums2
            while (i >= 0 && n1 >= 0) {
//                if (m1 == -1) {
//                    nums1[i] = nums2[n1]
//                    break
//                }
                if (nums2[n1] > nums1[i]) {
                    nums1[i] = nums2[n1]
                    n1--
                } else {
                    var temp = nums1[i]
                    nums1[i] = nums1[m1]
                    nums1[m1] = temp
                    m1--
                }
                i--
            }
            println(nums1.toList())
        }

        fun letterCombinations(digits: String): List<String> {
            if (digits.isEmpty()) return emptyList()
            var map = mutableMapOf<Char, List<Char>>()
            map['2'] = mutableListOf('a','b','c')
            map['3'] = mutableListOf('d','e','f')
            map['4'] = mutableListOf('g','h','i')
            map['5'] = mutableListOf('j','k','l')
            map['6'] = mutableListOf('m','n','o')
            map['7'] = mutableListOf('p','q','r', 's')
            map['8'] = mutableListOf('t','u','v')
            map['9'] = mutableListOf('w','x','y', 'z')
            var res = mutableListOf<String>()
            var temp = StringBuilder()
            fun dfs(i: Int) {
                if (i >= digits.length) {
                    res.add(temp.toString())
                }
                var list = map[digits[i]]

                for (j in list!!) {
                    temp.append(j)
                    dfs(i + 1)
                    temp.deleteCharAt(temp.length - 1)
                }
            }
            dfs(0)
            return res
        }
    }
}