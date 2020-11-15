package com.cshawn.leetcodes.sword;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：0 <= 链表长度 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/15 20:09
 */
public class Sword_6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        return iterateList(head, 0);
    }


    /**
     * 递归链表直到尾部，并统计链表长度，
     * 在链表尾时创建数组，层层返回时将每个元素放入lengh-index的位置
     */
    private int[] iterateList(ListNode head, int index) {
        // 计数+1
        index ++;
        int[] result;
        if (head.next != null) {
            // 存在next时继续身后迭代
            result = iterateList(head.next, index);
        } else {
            // 在链表尾部时创建数组
            result = new int[index];
        }
        // 此时index自增过一次，所以lengh-index刚好是链表反过来时的index
        result[result.length - index] = head.val;
        return result;
    }
}
