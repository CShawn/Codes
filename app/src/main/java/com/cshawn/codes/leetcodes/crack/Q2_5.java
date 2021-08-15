package com.cshawn.codes.leetcodes.crack;


import com.cshawn.codes.ListNode;

/**
 * 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/25 6:04 下午
 */
public class Q2_5 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode aux1 = l1;
        ListNode aux2 = l2;
        // 进位；当前位数字
        int carry = 0, sum;
        // 结果链表；末尾指针
        ListNode result = null, auxR = null;
        while (aux1 != null || aux2 != null) {
            sum = (aux1 != null ? aux1.val : 0) + (aux2 != null ? aux2.val : 0) + carry;
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                auxR = result;
            } else {
                auxR.next = new ListNode(sum % 10);
                auxR = auxR.next;
            }
            aux1 = aux1 != null ? aux1.next : null;
            aux2 = aux2 != null ? aux2.next : null;
        }
        if (carry != 0) {
            auxR.next = new ListNode(carry);
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aux1 = l1;
        ListNode aux2 = l2;
        // 进位；当前位数字
        int carry = 0, sum;
        // 结果链表，辅助一个空白节点，最终返回空白节点的后继节点
        ListNode result = new ListNode(0), auxR = result;
        while (aux1 != null || aux2 != null) {
            sum = (aux1 != null ? aux1.val : 0) + (aux2 != null ? aux2.val : 0) + carry;
            carry = sum / 10;
            auxR.next = new ListNode(sum % 10);
            auxR = auxR.next;
            aux1 = aux1 != null ? aux1.next : null;
            aux2 = aux2 != null ? aux2.next : null;
        }
        if (carry != 0) {
            auxR.next = new ListNode(carry);
        }
        return result.next;
    }
}
