package com.company.leetcode.kotlin.easy

import java.util.*

class Anagram {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = mutableMapOf<String, MutableList<String>>()

        for ( word in strs) {
            val chars = word.toCharArray()
            Arrays.sort(chars)

            val sortedString = String(chars)

            if (!map.containsKey(sortedString)) {
                map.put(sortedString,  ArrayList())
            }

            map[sortedString]?.add(word)

            map[sortedString]




        }


        return  ArrayList(map.values)

    }



        fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val hashMap1 = mutableMapOf<Char, Int>()
        val hashMap2 = mutableMapOf<Char, Int>()





        for (i in s.indices) {
            if (hashMap1.containsKey(s[i])) {
                var value = hashMap1[s[i]] ?: 0
                hashMap1[s[i]] = ++value
            } else {
                hashMap1[s[i]] = 1
            }
            if (hashMap2.containsKey(t[i])) {
                var value = hashMap2[t[i]] ?: 0
                hashMap2[t[i]] = ++value
            } else {
                hashMap2[t[i]] = 1
            }
        }

        for ((key, _) in hashMap1) {
            if (hashMap1[key] == null || hashMap2[key] == null) {
                return false
            }
            if (hashMap1[key] != hashMap2[key]) {
                return false
            }

        }
        return true
    }
}