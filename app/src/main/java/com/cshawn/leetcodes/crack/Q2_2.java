package com.cshawn.leetcodes.crack;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 注意：本题相对原题稍作改动
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：给定的 k保证是有效的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 12:46 下午
 */
public class Q2_2 {
    // 快慢指针，快指针先遍历k个，慢指针从头开始，快指针到达末尾，慢指针到达目的地
    public int kthToLast(ListNode head, int k) {
        if (head == null || k <= 0) {
            return -1;
        }
        // 先遍历k个节点
        ListNode aux = head;
        while (aux != null && k > 0) {
            aux = aux.next;
            k--;
        }
        // 到达末尾，k比0大，说明k大于链表长度
        if (k > 0) {
            return -1;
        }
        // 遍历到结尾且k为0，说明倒数第k个为第一个节点
        if (aux == null && k == 0) {
            return head.val;
        }
        // 慢指针从头开始
        ListNode result = head;
        // 结束条件为快指针到达末尾
        while (aux != null) {
            aux = aux.next;
            result = result.next;
        }
        return result.val;
    }
}
