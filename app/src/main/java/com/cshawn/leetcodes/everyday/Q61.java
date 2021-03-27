package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/27 9:28 上午
 */
public class Q61 {
    // 把倒数k%n个节点反转到链表头，即先求长度，再找到倒数第k%n个节点，断开链表，尾指向头
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        // 统计链表长度
        int n = 1;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        int count = k % n;
        if (count == 0) {
            return head;
        }
        // 找到尾节点
        ListNode end = cur;
        cur = head;
        // 快指针先行k%n步
        ListNode fast = head;
        while (count > 0) {
            fast = fast.next;
            count--;
        }
        // 快慢指针找到倒数第k%n个元素的前驱节点
        while (fast != end) {
            cur = cur.next;
            fast = fast.next;
        }
        // 倒数第k%n个节点
        ListNode result = cur.next;
        // 断开链表
        cur.next = null;
        // 尾节点指向链表头部
        end.next = head;
        return result;
    }

    // 不使用快慢指针，直接正序找第n-k%n个结点
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        // 统计链表长度
        int n = 1;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        if (k % n == 0) {
            return head;
        }
        // 尾结点指向首结点
        cur.next = head;
        // 正序第n-k个结点
        int count = n - k % n;
        cur = head;
        while (count > 1) {
            cur = cur.next;
            count--;
        }
        ListNode result = cur.next;
        cur.next = null;
        return result;
    }
}
