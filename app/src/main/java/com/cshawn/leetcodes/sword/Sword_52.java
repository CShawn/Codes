package com.cshawn.leetcodes.sword;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/19 7:55 下午
 */
public class Sword_52 {

    /**
     * 将两个链表尾对齐，再从短的链表头开始同时走，相遇即为交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 计算两个链表的长度
        int lengthA = 0;
        ListNode a = headA;
        while (a != null) {
            lengthA++;
            a = a.next;
        }
        int lengthB = 0;
        ListNode b = headB;
        while (b != null) {
            lengthB++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (lengthA > lengthB) {
            int t = lengthA - lengthB;
            while (t > 0) {
                a = a.next;
                t--;
            }
        } else if (lengthA < lengthB) {
            int t = lengthB - lengthA;
            while (t > 0) {
                b = b.next;
                t--;
            }
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    /**
     * 让两个链表沿自己移动到最后，到对方的链表上继续向前移动，
     * 若相遇，必然走过相同的路径长度
     * 若不相遇，最后必然都走到结尾为null
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            // 当前链表未走完则继续，若走完，从对方链表继续走
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        // a == b时，必然相遇或都为空
        return a;
    }
}
