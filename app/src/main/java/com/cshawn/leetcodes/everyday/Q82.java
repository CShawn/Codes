package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/25 8:31 上午
 */
public class Q82 {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        // 当前重复节点的前驱节点
        ListNode pre = fake;
        // 当前重复节点的最后一个节点
        ListNode last = head;
        ListNode cur = head.next;
        // 当前是否出现相同数值的节点
        boolean isSame = false;
        while (cur != null) {
            // 遇到不同的节点
            if (cur.val != last.val) {
                // 如果之前的节点数值相同，则删除相同的一串元素
                if (isSame) {
                    // 将相同数值的链表断开，此句代码也可以不写
                    last.next = null;
                    // 前边的与当前数值不同的节点的后继设为当前节点
                    pre.next = cur;
                } else {
                    // 之前未出现不同元素，则更新pre
                    pre = last;
                }
                // 向后移动last
                last = cur;
                isSame = false;
            } else {
                isSame = true;
                // 更新最后一个相同数值的节点
                last = cur;
            }
            cur = cur.next;
        }
        // 遍历结束时最后的几个元素相同，则删除
        if (isSame) {
            // 将最后的几个元素删除
            last.next = null;
            pre.next = null;
        }
        return fake.next;
    }

    // 数值不同时创建新节点
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = new ListNode(head.val);
        // 新链表的最后一个节点
        ListNode end = fake.next;
        // 最后一个节点的前驱节点，用于删除最后一个节点
        ListNode pre = fake;
        ListNode cur = head.next;
        // 记录当前可能的相同数值
        int same = head.val;
        while (cur != null) {
            // 不相同时，创建新节点
            if (cur.val != same) {
                end.next = new ListNode(cur.val);
                // 更新最后节点
                pre = end;
                end = end.next;
                same = cur.val;
            } else if (end.val == same) {
                // 当新链表的最后一个元素与当前要删除的数值相同时，将删除
                pre.next = null;
                // 更新最后节点
                end = pre;
            }
            cur = cur.next;
        }
        return fake.next;
    }

    // 数值相同时不断向后查找不同的节点
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            // 上述while结束后cur为重复元素的最后一个元素
            if (pre.next == cur) {
                // 说明pre和cur之间没有重复元素
                pre = pre.next;
                cur = cur.next;
            } else {
                // 将中间元素全部删除
                pre.next = cur.next;
                // 将要删除的链表断开，也可以不删除
                cur.next = null;
                cur = pre.next;
            }
        }
        return fake.next;
    }

    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val != head.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            ListNode temp = head.next;
            while (temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            return deleteDuplicates(temp);
        }
        return head;
    }
}
