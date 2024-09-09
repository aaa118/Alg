package com.company.leetcode.kotlin.linkedlist.hard

import kotlin.math.max
import kotlin.math.min

/**
 *
 */
class LFUCache {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        class LFUCacheImpl(private val capacity: Int) {
            var minFrequency = 0
            val keyToValueFreq = mutableMapOf<Int, Pair<Int, Int>>()
            val frequencyToValues = mutableMapOf<Int, LinkedHashSet<Int>>()

            fun get(key: Int): Int {
                if (capacity == 0) {
                    return -1
                }
                val entry = keyToValueFreq[key] ?: return -1
                val (currentValue, currentFrequency) = entry
                increaseFrequency(key, currentValue, currentFrequency)
                return currentValue
            }

            private fun increaseFrequency(key: Int, value: Int, currentFrequency: Int) {
                frequencyToValues.computeIfAbsent(currentFrequency + 1) { LinkedHashSet() }.add(key)
                frequencyToValues.getOrDefault(currentFrequency + 1, LinkedHashSet()).add(key)
                keyToValueFreq[key] = value to currentFrequency + 1
                frequencyToValues[currentFrequency]?.remove(key)
                if ((frequencyToValues[currentFrequency]?.size ?: 0) == 0) {
                    if (minFrequency == currentFrequency) {
                        minFrequency = currentFrequency + 1
                    }
                    frequencyToValues.remove(currentFrequency)
                }
            }

            fun put(key: Int, value: Int) {
                if (capacity == 0) {
                    return
                }
                val entry = keyToValueFreq[key]
                if (entry != null) {
                    val (_, currentFrequency) = entry
                    increaseFrequency(key, value, currentFrequency)
                } else {
                    if (keyToValueFreq.size == capacity) {
                        val keysWithMinFrequency = frequencyToValues.getOrDefault(minFrequency, LinkedHashSet())
                        keyToValueFreq.remove(keysWithMinFrequency.first())
                        keysWithMinFrequency.remove(keysWithMinFrequency.first())
                        if (keysWithMinFrequency.size == 0) {
                            frequencyToValues.remove(minFrequency)
                        }
                    }
                    frequencyToValues.computeIfAbsent(1) { LinkedHashSet() }.add(key)
                    minFrequency = 1
                    keyToValueFreq[key] = value to 1
                }
            }
        }
    }
}