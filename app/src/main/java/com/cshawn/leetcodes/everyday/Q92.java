package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/18 5:09 下午
 */
public class Q92 {
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || left <= 0 || right <= left) {
            return head;
        }
        // 上一个结点
        ListNode pre = null;
        // 当前结点
        ListNode cur = head;
        // 临时存储下一个结点
        ListNode temp;
        // 最终的盲链表
        ListNode result = new ListNode(0);
        result.next = head;
        // left的前驱结点
        ListNode start = result;
        // 当前位置
        int index = 1;
        while (cur != null) {
            if (index < left) {
                // 记录left的前驱结点
                if (index == left - 1) {
                    start = cur;
                }
                cur = cur.next;
            } else {
                // 将当前结点指向下一个结点的链接断开，指向前一个结点
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                // 到达结尾时
                if (index == right) {
                    // 将left结点的后继结点指向right的后继结点
                    start.next.next = cur;
                    // 将left的前驱结点的后继指向right结点
                    start.next = pre;
                    break;
                }
            }
            index++;
        }
        return result.next;
    }

    // k在i~j间，将i~k之间的元素反转，将k放到i的位置
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left <= 0 || right <= left) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        // 找到left的前驱结点
        ListNode pre = result;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = left; i < right; i++) {
            next = cur.next;
            cur.next = next.next;
            // 2. 所以next的后继结点应为pre的后继结点，而不是cur
            next.next = pre.next;
            // 1. 每次pre的下一个结点指向当前反转后的第一个元素
            pre.next = next;
            // 此后继续反转[left,cur]这个子链表与cur的后继结点，因此不用更新pre/cur/next
        }
        return result.next;
    }
}
