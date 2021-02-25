package com.cshawn.leetcodes.crack;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 4:27 下午
 */
public class Q2_3 {
    // 参数为要删除的节点，那么可以将此节点复制为其后继节点，并将其后继指向后继的后继，即复制后继节点并跳过
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = node.next.val;
        node.next = node.next.next;
        // 将删除的节点的后继指向空
        next.next = null;
    }
}
