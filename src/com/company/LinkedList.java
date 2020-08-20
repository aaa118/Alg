package com.company;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new LinkedList.Node(85);
        list.head.next = new LinkedList.Node(15);
        list.head.next.next = new LinkedList.Node(4);
        list.head.next.next.next = new LinkedList.Node(20);
    }


    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
