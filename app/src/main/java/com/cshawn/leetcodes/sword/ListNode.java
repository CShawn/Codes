package com.cshawn.leetcodes.sword;

import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

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

    public int getSize() {
        ListNode ln = this;
        int size = 0;
        while (ln != null) {
            size++;
            ln = ln.next;
        }
        return size;
    }

    public int[] toArray() {
        int[] array = new int[getSize()];
        ListNode ln = this;
        int index = 0;
        while (ln != null) {
            array[index] = ln.val;
            ln = ln.next;
            index++;
        }
        return array;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ListNode) {
            ListNode node = (ListNode) obj;
            return Arrays.equals(this.toArray(), node.toArray());
        }
        return super.equals(obj);
    }
}
