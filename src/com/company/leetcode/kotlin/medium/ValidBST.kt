package com.company.leetcode.kotlin.medium

class ValidBST {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val root = TreeNode(2)
//            root.left = TreeNode(1)
//            root.right = TreeNode(3)

            val root = TreeNode(5)
            root.left = TreeNode(1)
            root.left!!.left = null
            root.left!!.right = null
            root.right = TreeNode(4)
            root.right!!.left = TreeNode(3)
            root.right!!.right = TreeNode(6)
            println(isValidBST(root))

        }

        fun isValidBST(root: TreeNode?): Boolean {
            return dfs(root, Int.MIN_VALUE, Int.MAX_VALUE)

        }
        private fun dfs(root: TreeNode?, left: Int, right: Int): Boolean  {
            if (root == null) return true
            if (left < root.`val` && root.`val` < right) {
                dfs(root.left, left, root.`val`)
            } else if (left > root.`val` && root.`val` > right) {
                dfs(root.right, root.`val`, right)
            } else {
                return false
            }
            return true
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}