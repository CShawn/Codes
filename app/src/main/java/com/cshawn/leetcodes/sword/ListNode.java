package com.cshawn.leetcodes.sword;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode next(int n) {
        findEnd(this).next = new ListNode(n);
        return this;
    }

    private ListNode findEnd(ListNode node) {
        if (node.next != null) {
            return findEnd(node.next);
        } else {
            return node;
        }
    }
}
