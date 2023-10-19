package com.company.leetcode.kotlin.easy

import java.util.*
import kotlin.collections.ArrayDeque

class ValidParentheses {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(isValid("()[]{}"))
            println(isValid("([)]"))



        }

        fun isValid(s: String): Boolean {
            val hashMap = hashMapOf(")" to "(", "}" to "{", "]" to "[")

            val stack=  ArrayDeque<Char>()
            for (i in s.indices) {
                if (stack.isNotEmpty() && (s[i] == ')' || s[i] == '}' || s[i] == ']')) {
                    val openB = stack.last()
                    val openBInMap = hashMap[s[i].toString()]
                    if (openB.toString() == openBInMap) stack.removeLast() else stack.add(s[i])
                } else {
                    stack.add(s[i])
                }
            }
            return stack.isEmpty()
        }

        private fun getOpenBracket(char: Char): Char {
            return when (char) {
                ')' -> '('
                '}' -> '{'
                ']' -> '['
                else -> {
                    '['
                }
            }
        }
    }
}