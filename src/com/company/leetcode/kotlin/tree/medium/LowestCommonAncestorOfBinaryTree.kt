package com.company.leetcode.kotlin.tree.medium

import com.company.leetcode.kotlin.tree.TreeNode
import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
class LowestCommonAncestorOfBinaryTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println()
        }

        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

            // Intuition:
            // The algorithm works by recursively traversing the tree. If either p or q is found,
            // it returns that node. If both p and q are found in different subtrees of the same node,
            // that node is their lowest common ancestor. If they are found in the same subtree, the
            // result bubbles up from that subtree.

            // Base case: if the current node is null, return null
            if (root == null) return null

            // If the current node is either p or q, return the current node
            if (root == p || root == q) return root

            // Recur for the left and right subtrees
            val left = lowestCommonAncestor(root.left, p, q)
            val right = lowestCommonAncestor(root.right, p, q)

            // If p and q are found in left and right subtrees respectively, return the current node
            if (left != null && right != null) return root

            // If p and q are found in the left subtree, return the result of the left subtree
            if (left != null) return left

            // If p and q are found in the right subtree, return the result of the right subtree
            return right
        }
    }
}