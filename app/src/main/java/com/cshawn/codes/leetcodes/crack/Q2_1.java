package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：如果不得使用临时缓冲区，该怎么解决？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/24 9:39 下午
 */
public class Q2_1 {
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        // 存储出现过的元素
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode aux = head;
        while (aux.next != null) {
            if (set.add(aux.next.val)) {
                aux = aux.next;
            } else {
                // 重复时，将当前结点的后继结点设为后继的后继结点，即删除了后继结点
                aux.next = aux.next.next;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode aux = head;
        ListNode aux2;
        while (aux != null) {
            aux2 = aux;
            // 从当前结点开始遍历，如果与当前结点相同则删除
            while (aux2.next != null) {
                if (aux2.next.val == aux.val) {
                    aux2.next = aux2.next.next;
                } else {
                    aux2 = aux2.next;
                }
            }
            aux = aux.next;
        }
        return head;
    }
}
