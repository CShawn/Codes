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
    public ListNode deleteDuplicates(ListNode head) {
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
}
