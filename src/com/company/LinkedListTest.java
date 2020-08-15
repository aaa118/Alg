package com.company;

public class LinkedListTest {
    Node1 head;

    public void insert(int data) {
        Node1 node = new Node1();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node1 newNode = head;
            while (newNode.next != null) {
                newNode = newNode.next;
            }
            newNode.next = node;
        }
    }

    public void show() {
        Node1 node1 = head;
        while (node1.next != null) {
            System.out.println(node1.data);
            node1 = node1.next;
        }
        System.out.println(node1.data);
    }

    public Node1 getHead() {
        return head;
    }

    /* Function to reverse the linked list */
    Node1 reverse(Node1 node) {
        Node1 prev = null;
        Node1 current = node;
        Node1 next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    private class Node1 {
        int data;
        Node1 next;
    }
}
