package com.cshawn.leetcodes.sword;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author C.Shawn
 * @date 2020/12/14 21:29
 */
public class Sword_30 {
    private Stack<Integer> content, min;
    public Sword_30() {
        content = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        content.push(x);
        min.push(min.isEmpty() || x < min() ? x : min());
    }

    public void pop() {
        content.pop();
        min.pop();
    }

    public int top() {
        return content.peek();
    }

    public int min() {
        return min.peek();
    }
}
