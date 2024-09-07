package com.company.leetcode.kotlin.arrayandstrings.medium

import kotlin.math.max
import kotlin.math.min

class GroupAnagrams {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = arrayOf("eat","tea","tan","ate","nat","bat")
            println(groupAnagrams(array))
        }

        private fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = mutableMapOf<String, MutableList<String>>()

            for (s in strs) {
                val key = buildKey(s)
                if (map.containsKey(key)) {
                    map[key] = map.getOrDefault(key, mutableListOf()).apply { add(s) }
                } else {
                    map[key] = mutableListOf(s)
                }
            }
            return map.values.toList()
        }

        private fun buildKey(str: String): String {
            val arr = CharArray(26)
            for (ch in str){
                arr[ch - 'a']++
                println(arr.toList())
            }
            return String(arr)
        }
    }
}