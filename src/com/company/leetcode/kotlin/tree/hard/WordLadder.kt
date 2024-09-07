package com.company.leetcode.kotlin.tree.hard

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 *
 */
class WordLadder {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ladderLength("hit", "cog", mutableListOf("hot","dot","dog","lot","log","cog")))
        }

        fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
            var q = LinkedList<String>()
            var words = wordList.toMutableSet()
            words.remove(beginWord)
            q.add(beginWord)
            var level = 0

            while (q.isNotEmpty()) {
                val size = q.size
                level++
                repeat(size) {
                    val currentWord = q.poll()
                    if (currentWord.equals(endWord)) return level
                    val neighbors = getNeighbors(currentWord)
                    for (nei in neighbors) {
                        if (words.contains(nei)) {
                            words.remove(nei)
                            q.add(nei)
                        }
                    }
                }
            }
            return 0
        }
        fun getNeighbors(str: String) : List<String> {
            // Convert input string into a char array
            val chars = str.toCharArray()
            val res = mutableListOf<String>()
            // Go through each of the indices
            for (i in chars.indices) {
                val temp = chars[i]
                // putting all 26 letters in that position
                for (j in 'a' .. 'z') {
                    // Each time we put a letter in, we convert the current char array into a string
                    chars[i] = j
                    val neighbor = String(chars)
                    // add to output list
                    res.add(neighbor)
                }
                // After processing an index, set it back to the character it originally contained.
                chars[i] = temp
            }
            return res
        }
    }
}