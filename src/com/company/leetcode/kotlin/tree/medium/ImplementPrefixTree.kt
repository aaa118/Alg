package com.company.leetcode.kotlin.tree.medium

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 *
 * Case 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 */
class ImplementPrefixTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = Trie()
            obj.insert("apple")
            println(obj.search("apple"))
        }
        class Trie() {
            class TrieNode() {
                val child = mutableMapOf<Char, TrieNode>()
                var isWord = false
            }
            var root = TrieNode()

            fun insert(word: String) {
                var curr = root
                for (c in word) {
                    if (!curr.child.containsKey(c)) {
                        curr.child[c] = TrieNode()
                    }
                    curr = curr.child.getOrDefault(c, TrieNode())
                }
                curr.isWord = true
            }

            fun search(word: String): Boolean {
                var curr = root
                for (c in word) {
                    if (!curr.child.containsKey(c)) {
                        return false
                    }
                    curr = curr.child.getOrDefault(c, TrieNode())

                }
                return curr.isWord
            }

            fun startsWith(prefix: String): Boolean {
                var curr = root
                for (c in prefix) {
                    if (!curr.child.containsKey(c)) {
                        return false
                    }
                    curr = curr.child.getOrDefault(c, TrieNode())

                }
                return true
            }
        }

    }
}