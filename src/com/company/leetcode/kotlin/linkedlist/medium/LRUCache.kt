package com.company.leetcode.kotlin.linkedlist.medium

class LRUCache {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cache = LRUCacheImpl(2)
            cache.put(1, 1)
            cache.put(2, 2)
            println(cache.get(1))
            cache.put(3, 3)
            println(cache.get(2))
            cache.put(4, 4)
            println(cache.get(1))
            println(cache.get(3))
            println(cache.get(4))
        }
    }

    class LRUCacheImpl(private val capacity: Int) {

        // Just a node object for our list
        data class Node(
            val key: Int,
            val value: Int,
            var prev: Node?,
            var next: Node?
        )

        private val map = HashMap<Int, Node>()

        private var first: Node? = null
        private var last: Node? = null
        private var size = 0

        fun get(key: Int): Int =
            if (map.containsKey(key)) {
                // if we've found the key in the map it means that we have a such key in the list

                // remove node to the head (remove + add to the head)
                val removedNode = removeKey(key)
                removedNode?.also { add(key, removedNode.value) }

                map[key]?.value ?: -1
            } else {
                -1
            }

        fun put(key: Int, value: Int) {
            if (map.containsKey(key)) {
                // if we currently have such key we remove it before add to the head avoid duplication
                removeKey(key)
            }
            add(key, value)

            // trim size if we out of capacity
            trimSize()
        }

        /**
         * add node to the list
         **/
        private fun add(key: Int, value: Int) {
            // new first (head) node
            val newFirst = Node(
                key = key,
                value = value,
                prev = first,
                next = null
            )

            // replace current first (head) with the new one
            first?.next = newFirst
            first = newFirst

            // if we haven't set last (tail) node previously we should set it up
            if (last == null) {
                last = first
                last?.prev = null
            }

            // increase the size of our list
            size++;

            // update map
            map[key] = newFirst
        }

        private fun removeKey(key: Int): Node? =
            map[key]?.also { node ->

                // found nodes before and after current one and connect them
                val prev = node?.prev
                val next = node?.next
                prev?.next = next
                next?.prev = prev

                // check if the node that we have to remove is the first (head) one
                if (first == node) {
                    first = prev
                }

                // check if the node that we have to remove is the last (tail) one
                if (last == node) {
                    last = next
                }

                // decrice size of the list
                size--

                // remove it from map
                map.remove(key)
            }

        private fun trimSize() {
            if (size > capacity) {
                // remove last node key from map
                last?.key?.also { map.remove(it) }

                // remove the last (tail) node from the list
                val next = last?.next
                last = next
                last?.prev = null

                // reduce size of the list
                size--
            }
        }
    }
}