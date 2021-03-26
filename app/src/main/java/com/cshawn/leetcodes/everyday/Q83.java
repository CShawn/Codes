package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点head ，请你删除所有重复的元素，使每个元素只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/26 4:59 下午
 */
public class Q83 {

    // 新创建节点
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = new ListNode(head.val);
        ListNode newNode = result.next;
        int same = head.val;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val != same) {
                newNode.next = new ListNode(cur.val);
                newNode = newNode.next;
                same = cur.val;
            }
            cur = cur.next;
        }
        return result.next;
    }

    // 一次遍历
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode last = result;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val != cur.next.val) {
                if (pre != last) {
                    last.next = null;
                    pre.next = cur;
                }
                pre = cur;
            }
            if (cur.next == null && pre != last) {
                last.next = null;
                pre.next = cur;
            }
            last = cur;
            cur = cur.next;
        }
        return result.next;
    }

    // 相同时遍历跳过
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        // 当前相同元素的前一个结点
        ListNode pre = result;
        // 当前元素的前一个节点
        ListNode last = result;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                last = cur;
                cur = cur.next;
            }
            // 有重复元素
            if (pre != last) {
                last.next = null;
                pre.next = cur;
            }
            pre = cur;
            last = cur;
            cur = cur.next;
        }
        return result.next;
    }

    // 递归
    public ListNode deleteDuplicates4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val != head.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            return deleteDuplicates(head);
        }
        return head;
    }

    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val != head.val) {
            deleteDuplicates(head.next);
        } else {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = null;
            deleteDuplicates(head);
        }
        return head;
    }
}
