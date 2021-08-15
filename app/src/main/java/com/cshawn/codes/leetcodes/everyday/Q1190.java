package com.cshawn.codes.leetcodes.everyday;

/**
 * 反转每对括号间的子串
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * 提示：
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/26 9:56 下午
 */
public class Q1190 {
    // 栈
    public String reverseParentheses(String s) {
        // 字符串数组模拟栈
        String[] stack = new String[s.length()];
        // 栈顶指针
        int top = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 遇到左括号时，将当前遍历中的字符串入栈
            if (c == '(') {
                // 当前的字符串为从起始位置到当前位置的子字符串
                stack[++top] = sb.toString();
                // 更新起始位置为左括号后的字符
                sb.setLength(0);
            } else if (c == ')') {
                // 遇到右括号时，将当前字符串反转，与栈顶字符串拼接
                sb.reverse();
                sb.insert(0, stack[top--]);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
