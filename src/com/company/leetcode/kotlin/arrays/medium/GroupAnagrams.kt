package com.company.leetcode.kotlin.arrays.medium

class GroupAnagrams {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var array = arrayOf("eat","tea","tan","ate","nat","bat")
            println(groupAnagrams(array))

        }
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = mutableMapOf<String, MutableList<String>>()
            for (str in strs){
                val key = buildKey(str)
                if(map.contains(key)){
                    map[key]!!.add(str)
                } else {
                    map[key] = mutableListOf(str)
                }
            }
            return map.values.toList()
        }

        private fun buildKey(str: String): String {
            val arr = CharArray(26,{'a'})
            for (ch in str){
                arr[ch - 'a']++
            }
            return String(arr)
        }
    }
}