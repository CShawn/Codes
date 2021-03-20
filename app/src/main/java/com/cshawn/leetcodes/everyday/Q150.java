package com.cshawn.leetcodes.everyday;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *  
 * 提示：
 * 1 <= tokens.length <= 104
 * tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数
 * 逆波兰表达式：逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/20 10:37 上午
 */
public class Q150 {
    // 栈
    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int second1 = stack.pop();
                    stack.push(stack.pop() + second1);
                    break;
                case "-":
                    int second2 = stack.pop();
                    stack.push(stack.pop() - second2);
                    break;
                case "*":
                    int second3 = stack.pop();
                    stack.push(stack.pop() * second3);
                    break;
                case "/":
                    int second4 = stack.pop();
                    stack.push(stack.pop() / second4);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    // 数组模拟栈
    public int evalRPN2(String[] tokens) {
        // 如1+2-3，长度为5，数字为3，符号为2，因此要存入栈的最大长度为一半加1
        int[] stack = new int[tokens.length / 2 + 1];
        int top = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 1] = stack[top - 1] + stack[top];
                    top--;
                    break;
                case "-":
                    stack[top - 1] = stack[top - 1] - stack[top];
                    top--;
                    break;
                case "*":
                    stack[top - 1] = stack[top - 1] * stack[top];
                    top--;
                    break;
                case "/":
                    stack[top - 1] = stack[top - 1] / stack[top];
                    top--;
                    break;
                default:
                    stack[++top] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[top];
    }

    // 优化方法2
    public int evalRPN3(String[] tokens) {
        // 如1+2-3，长度为5，数字为3，符号为2，因此要存入栈的最大长度为一半加1
        int[] stack = new int[tokens.length / 2 + 1];
        int top = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[top - 1] += stack[top--];
                    break;
                case "-":
                    stack[top - 1] -= stack[top--];
                    break;
                case "*":
                    stack[top - 1] *= stack[top--];
                    break;
                case "/":
                    stack[top - 1] /= stack[top--];
                    break;
                default:
                    stack[++top] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[top];
    }

    private int index;
    private String[] tokens;
    // 递归
    public int evalRPN(String[] tokens) {
        this.tokens = tokens;
        index = tokens.length - 1;
        return evalRPN();
    }

    private int evalRPN() {
        String s = tokens[index--];
        switch (s) {
            case "+":
                int second1 = evalRPN();
                return evalRPN() + second1;
            case "-":
                int second2 = evalRPN();
                return evalRPN() - second2;
            case "*":
                int second3 = evalRPN();
                return evalRPN() * second3;
            case "/":
                int second4 = evalRPN();
                return evalRPN() / second4;
            default:
                return Integer.parseInt(s);
        }
    }
}
