package com.cshawn.codes.leetcodes.crack;

import java.util.Stack;

/**
 * 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * 
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/28 21:21
 */
public class Q3_2 {
    class MinStack1 {
        // 链表存储值与最小值
        private MinListNode stack;
        public MinStack1() {
            // 盲节点
            stack = new MinListNode(0);
        }
        
        public void push(int x) {
            MinListNode node = new MinListNode(x);
            // 当前最小值为栈顶元素对应最小值与当前值相比的较小值
            node.min = stack.next != null ? Math.min(stack.next.min, x) : x;
            node.next(stack.next);
            stack.next(node);
        }
        
        public void pop() {
            MinListNode node = stack.next;
            if (node != null) {
                stack.next = node.next;
                node.next = null;
            }
        }
        
        public int top() {
            return stack.next != null ? stack.next.val : -1;
        }
        
        public int getMin() {
            return stack.next != null ? stack.next.min : -1;
        }
    
        class MinListNode {
            int val;
            int min;
            MinListNode next;
            public MinListNode(int value) {
                val = value;
            }
            public void next(int value) {
                next = new MinListNode(value);
            }
            public void next(MinListNode value) {
                next = value;
            }
            public void min(int value) {
                min = value;
            }
        }
    }
    
    class MinStack {
        // 双栈实现
        private Stack<Integer> stack;
        private Stack<Integer> min;
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }
        
        public void push(int x) {
            stack.push(x);
            min.push(min.isEmpty() ? x : Math.min(min.peek(), x));
        }
        
        public void pop() {
            stack.pop();
            min.pop();
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return min.peek();
        }
    }
}
