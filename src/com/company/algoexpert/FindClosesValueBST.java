//package com.company.algoexpert;
//
//public class FindClosesValueBST {
//
//
//    public static int findClosestValueInBstS11(BSTConstruction.BST tree, int target) {
//        // Write your code here.
//
////        int test = bst.left.value;
////        return findClosestValueInBstS1(tree,  target, tree.value);
//        return findClosestValueInBstS1(tree,  target, tree.value);
//    }
//
//    public static int closestValue(BSTConstruction.BST tree, int target) {
//            int closestDifference = Math.abs(tree.value - target);
//            if (closestDifference == 0) {
//                return tree.value;
//            }
//            int leftNodeDifference = Math.abs(tree.left.value - target);
//            int rightNodeDifference = Math.abs(tree.right.value - target);
//
//            if (leftNodeDifference < rightNodeDifference) {
//                tree = tree.left;
//            } else {
//                tree = tree.right;
//            }
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
// public static int findClosestValueInBstS1(BSTConstruction.BST tree, int target, int closest) {
//        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
//            closest = tree.value;
//        }
//        if (target < tree.value && tree.left != null) {
//            return findClosestValueInBstS1(tree.left, target, closest);
//        } else if (target > tree.value && tree.right != null) {
//            return findClosestValueInBstS1(tree.right, target, closest);
//        } else {
//            return closest;
//        }
// }
//
//
//    public static void main(String[] args) {
//        BSTConstruction.BST bst = new BSTConstruction.BST(10);
//        bst.insert(5).insert(2);
//        bst.insert(5).insert(1);
//        bst.insert(15).insert(13).insert(22).insert(14);
////        findClosestValueInBst(bst, 12);
//        System.out.println(findClosestValueInBstS11(bst, 12));
//
//
//    }
//}
