package com.company.leetcode.kotlin.linkedlist.easy

class ReverseLinkedList {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val node = ListNode(1)
            node.next = ListNode(2)
            node.next?.next = ListNode(3)
            node.next?.next!!.next = ListNode(4)
            node.next?.next!!.next?.next = ListNode(5)
            println(reverseList(node)?.`val` ?: 0)
        }
        private fun reverseList(head: ListNode?): ListNode? {
            if (head?.next == null)
                return head


            val newHead = reverseList(head.next)
            head.next!!.next = head
            head.next = null

            return newHead
        }
    }
}

 class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }