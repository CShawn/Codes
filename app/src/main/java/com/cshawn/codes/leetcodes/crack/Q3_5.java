package com.cshawn.codes.leetcodes.crack;

import java.util.Stack;

/**
 * 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 示例1:
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 *
 * 示例2:
 *  输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 * 说明:栈中的元素数目在[0, 5000]范围内。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/1 9:01 下午
 */
public class Q3_5 {
    class SortedStack {
        private Stack<Integer> stack;
        private Stack<Integer> aux;
        public SortedStack() {
            stack = new Stack<>();
            aux = new Stack<>();
        }

        // push时，将较大数字移入aux后，不必在push后再移回stack，后期操作会更快速
        public void push(int val) {
            while (!stack.isEmpty() && val > stack.peek()) {
                aux.push(stack.pop());
            }
            while (!aux.isEmpty() && val < aux.peek()) {
                stack.push(aux.pop());
            }
            stack.push(val);
        }

        public void pop() {
            while (!aux.isEmpty()) {
                stack.push(aux.pop());
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int peek() {
            while (!aux.isEmpty()) {
                stack.push(aux.pop());
            }
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty() && aux.isEmpty();
        }
    }
}
