package com.company.leetcode.kotlin.medium.stack

import com.company.leetcode.java.ListNode
import java.util.*

class BasicCalculator2 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(calculate("3+2*2"))
        }

        fun calculate(s: String): Int {
            val stack = Stack<Int>()

            var exp = '+'
            var digit = 0

            for (i in s.indices) {
                val ch = s[i]
                if (ch.isDigit()) {
                    digit = digit * 10 + ch.toInt() - '0'.toInt()
                }
                if (!ch.isDigit() && ch != ' ' || i == s.length - 1) {
                    when (exp) {
                        '+' -> stack.add(digit)
                        '-' -> stack.add(-digit)
                        '*' -> stack.add(stack.pop() * digit)
                        '/' -> stack.add(stack.pop() / digit)
                    }
                    exp = ch
                    digit = 0
                }
            }

            return stack.sum()

        }
    }
}

class Trie() {
    class TrieNode {
        val child = mutableMapOf<Char, TrieNode>()
        var isWord = false
    }
    private var root = TrieNode()
    fun insert(word: String) {
        var curr = root
        for (c in word) {
            if (root.child.containsKey(c)) {
                curr = curr.child.getOrDefault(c, TrieNode())
            } else {
                root.child[c] = TrieNode()
            }
        }
        root.isWord = true
    }


}