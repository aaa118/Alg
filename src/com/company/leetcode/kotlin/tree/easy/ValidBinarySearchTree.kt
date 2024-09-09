package com.company.leetcode.kotlin.tree.easy

import com.company.leetcode.kotlin.tree.TreeNode
import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Case 1: root = [2,1,3]
 *      Output true
 * Case 2: root = [5,1,4,null,null,3,6]
 *      Output false
 * Case 3: root = [2147483647]
 *      Output true
 * Case 4: root = [-2147483648,null,2147483647]
 *      Output true
 */
class ValidBinarySearchTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // root =
            //[2147483647]
            println()
        }
        fun isValidBST(root: TreeNode?): Boolean {
            return dfs(root, null, null)

        }
        fun dfs(root: TreeNode?, left: Int?, right: Int?): Boolean  {
            if (root == null) return true
            if (left != null && left >= root.`val` || right != null && root.`val` >= right) return false
            return dfs(root.left, left, root.`val`) && dfs(root.right, root.`val`, right)
        }
    }
}