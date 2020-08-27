package com.company;

public class BSTConstruction {
    public static void main(String[] args) {

    }

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        return -1;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            return this;
        }
    }
}
