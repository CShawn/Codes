package com.cshawn.leetcodes.everyday;

import java.util.Stack;

/**
 * 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 *
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 *
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/11 6:13 下午
 */
public class Q227 {
    // 栈。
    // 因为没有括号只有四则运算，因此只用处理运算符优先级问题，加减则入栈，乘除则计算
    public int calculate(String s) {
        // 用以记录当前数字前的运算符
        char calculator = '+';
        int index = 0;
        // 存储数字
        Stack<Integer> stack = new Stack<>();
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                // 计算当前数字
                int num = 0;
                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                // 根据数字之前的运算符来决定操作
                if (calculator == '*' || calculator == '/') {
                    // 乘除法与栈顶元素计算并重新入栈
                    int first = stack.pop();
                    stack.push(calculator == '*' ? first * num : first / num);
                } else if (calculator == '+') {
                    stack.push(num);
                } else {
                    stack.push(-num);
                }
            } else if (s.charAt(index) == ' ') {
                index++;
            } else {
                calculator = s.charAt(index);
                index++;
            }
        }
        // 将栈中所有数字相加得到最终结果
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
