package com.company.leetcode.kotlin.tree.medium

import com.company.leetcode.kotlin.tree.TreeNode
import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 *
 */
class BinaryTreeLevelOrderTraversal {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            var res = mutableListOf<List<Int>>()
            if (root == null) return res
            var curr = root
            var q = LinkedList<TreeNode?>()
            q.add(curr)

            while(q.isNotEmpty()) {
                var size = q.size
                var list = mutableListOf<Int>()
                repeat(size) {
                    val node = q.pop()
                    list.add(node!!.`val`)
                    if (node?.left != null) q.add(node?.left)
                    if (node?.right != null) q.add(node?.right)
                }
                res.add(list)
            }
            return res
        }
    }
}