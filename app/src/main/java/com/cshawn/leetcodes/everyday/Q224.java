package com.cshawn.leetcodes.everyday;

import java.util.Stack;

/**
 * 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/10 8:17 下午
 */
public class Q224 {
    // 栈。
    // 因只有加减法，因此不用考虑运算符优先级，只用去除括号即可。
    // 括号前是减号时，括号中的数字需要改变正负号
    public int calculate(String s) {
        Stack<Integer> signs = new Stack<>();
        // 当前的数字符号
        int sign = 1;
        signs.push(1);
        int result = 0;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                int num = 0;
                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                result += sign * num;
            } else {
                if (c == '+') {
                    sign = signs.peek();
                } else if (c == '-') {
                    sign = -signs.peek();
                } else if (c == '(') {
                    signs.push(sign);
                } else if (c == ')') {
                    signs.pop();
                }
                index++;
            }
        }
        return result;
    }
}
