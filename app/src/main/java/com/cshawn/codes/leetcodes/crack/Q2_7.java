package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.ListNode;

/**
 * 链表相交
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 6:07 下午
 */
public class Q2_7 {
    // 先各自遍历，一个链表结束则从另一链表开始遍历，则相遇在交点。若再次直到末尾则不相交
    // 设两链表头距离交点分别为x,y，交点后长度为z，则x+z+y==y+z+x
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode aux1 = headA;
        ListNode aux2 = headB;
        // 两个链表各到达一次末尾，如果再到达一次末尾则无交点，共3次
        int k = 3;
        while (k > 0) {
            if (aux1 == aux2) {
                return aux1;
            }
            // 两个链表同时到达结尾则说明无交点
            if (aux1.next == null && aux2.next == null) {
                return null;
            }
            // 到达结尾则指向另一个链表头
            if (aux1.next == null) {
                aux1 = headB;
                k--;
            } else {
                aux1 = aux1.next;
            }
            if (aux2.next == null) {
                aux2 = headA;
            } else {
                aux2 = aux2.next;
            }
        }
        return null;
    }

    // 优化方法1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aux1 = headA;
        ListNode aux2 = headB;
        while (aux1 != aux2) {
            aux1 = aux1 != null ? aux1.next : headB;
            aux2 = aux2 != null ? aux2.next : headA;
        }
        // 相等时为交点，或者都为空不相遇
        return aux1;
    }
}
