package com.company.leetcode.kotlin.backtrack.medium

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinationsOfPhoneNumber {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(letterCombinations("23"))
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
                    return
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