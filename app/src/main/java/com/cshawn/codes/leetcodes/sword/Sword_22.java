package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.ListNode;

/**
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/12/08 20:55
 */
public class Sword_22 {

    /**
     * 采用快慢指针，快指针先行k步，慢指针开始动，快指针到链表结尾，慢指针到达倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow= head;
        while (k > 1 && fast != null) {
            fast = fast.next;
            k--;
        }
        // 判断快指针已为空，则链表不够k个元素
        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    } 
}
