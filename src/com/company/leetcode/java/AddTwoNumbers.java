package com.company.leetcode.java;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1Node = new ListNode(3);
//        ListNode l1Node1 = new ListNode(4, l1Node);
        ListNode l1Node1 = new ListNode(8);
        ListNode l1 = new ListNode(1, l1Node1);
//        ListNode l1 = new ListNode(1);

        ListNode l2Node = new ListNode(4);
        ListNode l2Node1 = new ListNode(6, l2Node);
//        ListNode l2 = new ListNode(5, l2Node1);
        ListNode l2 = new ListNode(0);


        System.out.println(addTwoNumbers(l1, l2));
        ListNode ans = addTwoNumbers(l1, l2);
//        System.out.println(addTwoNumbersLS1(l1, l2));
        System.out.println(ans.val);
        System.out.println(ans.next.val);
//        System.out.println(ans.next.next.val);
//        System.out.println(ans.next.next.next.val);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode finalSum = new ListNode(0);
        ListNode curr = finalSum;
        while (l1 != null || l2 != null) {
            int x = 0;
            if (l1 != null) {
                x = l1.val;
            }
            int y = 0;
            if (l2 != null) {
                y = l2.val;
            }
            finalSum.val = x + y + carry;
            carry = finalSum.val / 10;
            curr.next = new ListNode(finalSum.val % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return finalSum.next;
    }

    public static ListNode addTwoNumbersLS1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
