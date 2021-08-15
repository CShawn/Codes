package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.ListNode;

/**
 * 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 6:05 下午
 */
public class Q2_6 {
    // 转为数组
    public boolean isPalindrome1(ListNode head) {
        ListNode aux = head;
        int length = 0;
        // 统计长度
        while (aux != null) {
            length++;
            aux = aux.next;
        }

        // 转为数组
        aux = head;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = aux.val;
            aux = aux.next;
        }
        // 遍历一半判断首尾数字是否回文
        for (int i = 0; i < length / 2; i++) {
            if (array[i] != array[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 将后半部分反转，再将两个链表从头比较，相同则回文
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 让preMiddle指向中间，待结束后恢复
        ListNode preMiddle = slow;
        // 将后半部分链表反转
        slow = slow.next;
        ListNode pre = null;
        ListNode next;
        while (slow != null) {
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 此时pre指向结尾，让slow指向开头
        slow = head;
        ListNode last = pre;
        boolean result = true;
        while (slow != null && last != null) {
            if (slow.val != last.val) {
                result = false;
                break;
            }
            slow = slow.next;
            last = last.next;
        }
        // 遍历结束都相等则为回文
        // 恢复链表
        last = pre;
        pre = null;
        while (last != null) {
            next = last.next;
            last.next = pre;
            pre = last;
            last = next;
        }
        preMiddle.next = pre;
        return result;
    }
}
