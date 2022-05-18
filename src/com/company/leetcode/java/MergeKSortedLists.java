package com.company.leetcode.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                l.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(l);

        ListNode newNode = new ListNode(0);
        ListNode h = newNode;
        for (int i : l) {
            h.next = new ListNode(i);
            h = h.next;
        }
        h.next = null;
        return newNode.next;
    }
}
