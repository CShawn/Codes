package com.cshawn.leetcodes.sword;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 提示：
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/14 22:22
 */
public class Sword_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /* 方法1
        // 定义两个指针
        int i = 0, j = 0;
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length) {
            if (pushed[i] == popped[j]) {
                // 两元素相等时，同时向后移
                i++;
                j++;
            } else {
                // 两元素不相等时
                if (!stack.isEmpty() && stack.peek() == popped[j]) {
                    // popped和栈顶元素相等时，将栈顶元素弹出，并将popped向后移
                    stack.pop();
                    j++;
                } else {
                    // popped和栈顶元素不相等则将元素暂时放入栈中，并将pushed向后移
                    stack.push(pushed[i]);
                    i++;
                }
            }
        }
        // 遍历栈与popped的剩余元素，有一个不相等则匹配失败
        while (j < popped.length) {
            if (popped[j] != stack.pop()) {
                return false;
            }
            j++;
        }
        return true;
        */
        /* 方法2
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            // 将poshed中的元素依次放入栈中
            stack.push(p);
            // 当popped中元素与栈顶元素相等时，依次将栈中元素删除
            while (!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
        */
        // 方法3：栈会增加时间空间成本，且栈的应用只用到了栈顶元素，可以用int代替
        // 定义两个指针指向两个数组，一个指针记录伪栈顶元素
        int i = 0, top = -1;
        for (int p : pushed) {
            // 将pushed前边遍历过的数据覆盖掉，作为一个伪栈
            pushed[++top] = p;
            while (top >= 0 && pushed[top] == popped[i]) {
                top--;
                i++;
            }
        }
        return top == -1;
    }
}
