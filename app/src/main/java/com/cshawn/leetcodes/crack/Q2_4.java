package com.cshawn.leetcodes.crack;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * 示例:
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 6:02 下午
 */
public class Q2_4 {

    // 定义两个链表分别存储比x小和大的元素
    public ListNode partition1(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode bigger = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode aux = head, auxSmall = smaller, auxBig = bigger;
        while (aux != null) {
            if (aux.val < x) {
                auxSmall.next = aux;
                auxSmall = aux;
            } else {
                auxBig.next = aux;
                auxBig = aux;
            }
            aux = aux.next;
        }
        // 将较大链表的结尾指向空，防止出现环
        auxBig.next = null;
        // 将两个链表连接
        auxSmall.next = bigger.next;
        return smaller.next;
    }

    // 查找到较小者，将其与第一个较大者交换
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        // bigger和smaller分别指向比x小或大的元素的前一个位置
        ListNode bigger = null;
        ListNode smaller;
        if (head.val >= x) {
            bigger = result;
        }
        ListNode aux = head;
        ListNode cur;
        while (aux.next != null) {
            // 找到比x的元素
            if (aux.next.val < x) {
                // 之前存在比x大的元素则需要交换
                if (bigger != null) {
                    smaller = aux;
                    cur = aux.next;
                    ListNode bigNext = bigger.next.next;
                    bigger.next.next = smaller.next.next;
                    if (bigNext != cur) {
                        // 普通情况
                        smaller.next = bigger.next;
                        cur.next = bigNext;
                    } else {
                        // bigger和smaller紧挨
                        cur.next = bigger.next;
                    }
                    bigger.next = cur;
                    // 更新
                    bigger = cur;
                    aux = cur;
                } else {
                    aux = aux.next;
                }
            } else {
                if (bigger == null) {
                    bigger = aux;
                }
                aux = aux.next;
            }
        }
        return result.next;
    }
}
