package com.cshawn.codes.leetcodes.everyday;

/**
 * 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: True
 *
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 *
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 *
 * 注意:字符串大小将在 [1，100] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/12 11:26 上午
 */
public class Q678 {
    // 动态规划
    public boolean checkValidString1(String s) {
        // dp[i][j]表示s的子字符串[i,j]是否有效
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = s.charAt(i) == '*';
            char c1 = s.charAt(i), c2 = s.charAt(i + 1);
            dp[i][i + 1] = (c1 == '(' && c2 != '(') || (c1 == '*' && c2 != '(');
        }
        dp[s.length() - 1][s.length() - 1] = s.charAt(s.length() - 1) == '*';
        for (int i = s.length() - 3; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < s.length(); j++) {
                char c2 = s.charAt(j);
                // 左右为()，取决于[i+1,j-1]
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                // 分为两部分且都有效时
                for (int k = i; k < j && !dp[i][j]; k++) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    // 计数模拟栈
    public boolean checkValidString(String s) {
        // 记录左括号的个数，最小个数和最大个数
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (max == 0) {
                    return false;
                }
                if (min > 0) {
                    min--;
                }
                max--;
            } else {
                if (min > 0) {
                    // *作为右括号，抵消左括号
                    min--;
                }
                // *作为左括号，累加
                max++;
            }
        }
        return min == 0;
    }
}
