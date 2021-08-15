package com.cshawn.codes.leetcodes.sword;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/16 23:12
 */
public class Sword_9 {
    public class CQueue {
        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        public CQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }
        
        public void appendTail(int value) {
            stackIn.push(value);
        }
        
        public int deleteHead() {
            // stackOut空时，将stackIn加入的元素倒序放入stackOut
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            // 弹出stackOut栈顶的元素
            return stackOut.pop();
        }
    }
}
