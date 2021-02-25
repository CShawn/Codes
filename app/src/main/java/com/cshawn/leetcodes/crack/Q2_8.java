package com.cshawn.leetcodes.crack;

import com.cshawn.leetcodes.sword.ListNode;

/**
 * 环路检测
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 6:08 下午
 */
public class Q2_8 {
    // 快慢指针，相遇时，慢指针再从头，快指针与慢指针速走，相遇即环点
    // 设起点距离环点x，环点距离相遇点y，环剩余z，则2(x+y)=x+y+z+y,即x=z，那么从头同时走过x和z必相遇于环点
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        // 不足两个节点，无环
        if (slow.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        // 快慢指针相遇，或快指针为空无环
        while (slow != fast && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        }
        // 快指针为空无环
        if (fast == null) {
            return null;
        }
        // 慢指针指向开头
        slow = head;
        // 同步向前
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
