package com.company.algoexpert.java;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int data() {
            return data;
        }

        public Node next() {
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public void add(Node node) {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Java method to print a singly linked list
     */
    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data() + " ");
            node = node.next();
        }
        System.out.println("");
    }

    /**
     * Java method to reverse a linked list without recursion
     */
    public void reverse() {
        Node pointer = head;
        Node previous = null;
        Node current;

        while (pointer != null) {
            System.out.println(pointer);

            current = pointer;
//            System.out.println(current);

            pointer = pointer.next;
            System.out.println(pointer);


            // reverse the link
            current.next = previous;
//            System.out.println(current);

            previous = current;
//            System.out.println(previous);
            head = current;
//            System.out.println(head);

        }
    }
}
//Output
//        1 2 3
//        3 2 1