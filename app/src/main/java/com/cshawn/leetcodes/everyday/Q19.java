package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/21 5:59 下午
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 要删除的是第1个结点，也可以使用盲结点：fake.next = head,从而不做此判断
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delete = slow.next;
        slow.next = delete.next;
        delete.next = null;
        return head;
    }
}
