package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 限制： 0 <= 节点个数 <= 5000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/12/08 22:03
 */
public class Sword_24 {
    public ListNode reverseList(ListNode head) {
        // 临时存储结点的前一个结点和后一个结点
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            // 先找出后一个结点
            next = cur.next;
            // 将当前结点的next指向前一个结点
            cur.next = pre;
            // 更新存储的前一个结点
            pre = cur;
            // 更新当前结点
            cur = next;
        }
        // 最后cur为空，返回前一个结点即为原链表的最后一个结点
        return pre;
    }
}
