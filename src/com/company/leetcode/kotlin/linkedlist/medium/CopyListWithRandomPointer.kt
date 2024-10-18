package com.company.leetcode.kotlin.linkedlist.medium

class CopyListWithRandomPointer {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun copyRandomList(node: Node?): Node? {
            // Visited map to hold old node reference as "key" and new node reference as the "value"
            var map = mutableMapOf<Node?, Node?>()
            var curr = node
            while (curr != null) {
                val copy = Node(curr.`val`)
                map[curr] = copy
                curr = curr.next
            }

            curr = node
            // Iterate on the linked list until all nodes are cloned.
            while (curr != null) {
                val copy = map.getOrDefault(curr, null)
                // Get the clones of the nodes referenced by random and next pointers.
                copy!!.next = map.getOrDefault(curr.next, null)
                copy.random = map.getOrDefault(curr.random, null)
                curr = curr.next
            }
            return map.getOrDefault(node, null)
        }

         class Node(var `val`: Int) {
               var next: Node? = null
               var random: Node? = null
           }
    }
}