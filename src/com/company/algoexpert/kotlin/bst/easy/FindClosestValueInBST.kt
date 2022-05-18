package com.company.algoexpert.kotlin.bst.easy

class FindClosestValueInBST {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            // Create BST
            val bst = BST(10)
            bst.value = 10
            bst.left = BST(5)
            bst.right = BST(15)
            bst.right?.right = BST(22)
            bst.right?.left = BST(13)
            bst.right?.left?.right = BST(14)
            bst.left?.left = BST(2)
            bst.left?.right = BST(5)
            bst.left?.left?.left = BST(1)

            println(findClosestValueInBst(bst, 12))

        }


        fun findClosestValueInBst(tree: BST, target: Int): Int {
            return findClosestValueInBstH(tree, target)
        }
        // Write your code here.
        private fun findClosestValueInBstH(tree: BST?, target: Int): Int {
            var curr = tree
            var clos = 0
            if (tree != null) {
                clos = tree.value
            }
            var nClosest = clos

            while (curr != null) {
                val currV = curr.value
                val diff = kotlin.math.abs(target - nClosest)
                val nDiff = kotlin.math.abs(target - currV)
                if (diff > nDiff) {
                    nClosest = currV
                }
                curr = if (target < currV) {
                    curr.left
                } else if(target > currV) {
                    curr.right
                } else {
                    break
                }
            }
            return nClosest
        }
    }

    open class BST(var value: Int) {
        var left: BST? = null
        var right: BST? = null
    }
}