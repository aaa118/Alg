package com.company.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {


    public static void main(String[] args) {
        
    }
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> q = new LinkedList<Node>();
            q.add(this);
            List<String> array1 = new ArrayList<>();
            while(!q.isEmpty()) {
                Node current = q.poll();
                array1.add(current.name);
                q.addAll(current.children);
            }
            return array1;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
