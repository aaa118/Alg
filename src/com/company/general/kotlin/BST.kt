package com.company.general.kotlin

import java.util.*


class TreeNode(var `val`: Int, val list: Collections) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class BST(val intValue: Int) {
    var left: BST? = null
    var right: BST? = null

    fun rightSideView(root: TreeNode?): List<Int> {
        val finalList = ArrayList<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.size > 0) {
            val node = queue.poll()
            if (node?.`val` != null) {
                finalList.add(node.`val`)
            }
            if (node.right != null) queue.add(node.right)
        }
        return finalList

    }


    fun insert(root: BST?, value: Int): BST {
        if (root == null) {
            return BST(value)
        }
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.size

        val len = queue.size
        for (i in 0 until len) {

        }

        var queue1: Queue<TreeNode> = LinkedList<TreeNode>()
        var queue2: Queue<TreeNode> = LinkedList<TreeNode>()

//        queue1.add(p)
//        queue2.add(q)
//        if (queue1.size != queue2.size) return false
//
//        while (queue1.size > 0) {
//            val len = queue1.size
//            for (i in 0 until len) {
//                val node1 = queue1.poll()
//                val node2 = queue2.pop()
//            }
//        }

        if (value > root.intValue) {
            root.right = insert(root.right, value)
        } else {
            root.left = insert(root.left, value)
        }
        return root
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}