package com.cshawn.leetcodes.sword;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：0 <= 链表长度 <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof 
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/12/08 22:46
 */ 
public class Sword_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 两个指针分别指向两个链表当前结点的位置
        ListNode node1 = l1;
        ListNode node2 = l2;
        // 最终生成的链表
        ListNode result = null;
        // 最终生成链表的最后一个结点
        ListNode cur = null;
        while (node1 != null || node2 != null) {
            // 比较两个结点，将链表连接到较小的结点
            if (node1 != null && (node2 == null || node1.val <= node2.val)) {
                if (cur != null) {
                    cur.next = node1;
                }
                cur = node1;
                // 将较小结点所在的链表的指针向后移
                node1 = node1.next;
            } else {
                if (cur != null) {
                    cur.next = node2;
                }
                cur = node2;
                node2 = node2.next;
            }
            if (result == null) {
                result = cur;
            }
        }
        return result;
    }
}