package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.ListNode;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1:
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/6 1:05 下午
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        ListNode result = null, last = null;
        int carry = 0;
        while (ln1 != null || ln2 != null) {
            int v1 = ln1 != null ? ln1.val : 0;
            int v2 = ln2 != null ? ln2.val : 0;
            int sum = v1 + v2 + carry;
            if (result == null) {
                result = new ListNode(sum % 10);
                last = result;
            } else {
                last.next = new ListNode(sum % 10);
                last = last.next;
            }
            carry = sum / 10;
            ln1 = ln1 != null ? ln1.next : null;
            ln2 = ln2 != null ? ln2.next : null;
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return result;
    }
}
