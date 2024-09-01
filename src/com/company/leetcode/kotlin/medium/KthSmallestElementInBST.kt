package com.company.leetcode.kotlin.medium

import com.company.leetcode.kotlin.medium.ValidBST.Companion.isValidBST
import com.company.leetcode.kotlin.medium.ValidBST.TreeNode

class KthSmallestElementInBST {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(3)
            root.left = TreeNode(1)
            root.left!!.left = null
            root.left!!.left = TreeNode(2)
            root.right = TreeNode(4)
            println(kthSmallest(root, 1))

        }

        fun kthSmallest(root: TreeNode?, k: Int): Int {
            if (root == null) return 0
            var list = mutableListOf<Int>()
            dfs(root, list)
            return list[k - 1]
        }
        private fun dfs(root: TreeNode?, list: MutableList<Int>) {
            while (root != null) {
                dfs(root.left, list)
                list.add(root.`val`)
                dfs(root.right, list)
                list.add(root.`val`)
            }
        }
    }
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}