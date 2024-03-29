package com.cshawn.codes.leetcodes.sword;

import java.util.Arrays;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母以及字符.和*，无连续的 '*'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/25 10:05
 */
public class Sword_19 {
    // 方法1：动态规划
    public boolean isMatch1(String s, String p) {
        // dp[i][j]表示s的[0,i]子字符串与p的[0,j]子字符串是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (isMatch(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        // p最后一个字符与*，未匹配任何字符
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    // 取决于i,j前一位的字符串是否匹配
                    dp[i][j] = isMatch(s, p, i, j) ? dp[i - 1][j - 1] : false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean isMatch(String s, String p, int si, int pi) {
        if (si == 0) {
            return false;
        }
        return p.charAt(pi - 1) == '.' || s.charAt(si - 1) == p.charAt(pi - 1);
    }

    // 方法2：回溯
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        for (boolean[] m : memo) {
            Arrays.fill(m, true);
        }
        return backTracking(memo, s, p, 0, 0);
    }

    private boolean backTracking(boolean[][] memo, String s, String p, int i, int j) {
        if (!memo[i][j]) {
            return false;
        }
        // 当s到达末尾而p可能还未遍历结束，如果后续字符为*a*b*之类的字符串，则再次递归
        if (i == s.length()) {
            memo[i][j] = j == p.length() || (j + 1 < p.length() && p.charAt(j + 1) == '*' && backTracking(memo, s, p, i, j + 2));
            return memo[i][j];
        }
        if (j == p.length()) {
            memo[i][j] = false;
            return false;
        }
        boolean lastIsStar = j + 1 < p.length() && p.charAt(j + 1) == '*';
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (lastIsStar) {
                memo[i][j] = backTracking(memo, s, p, i + 1, j) || backTracking(memo, s, p, i, j + 2) || backTracking(memo, s, p, i + 1, j + 2);
            } else {
                memo[i][j] = backTracking(memo, s, p, i + 1, j + 1);
            }
        } else {
            if (lastIsStar) {
                memo[i][j] = backTracking(memo, s, p, i, j + 2);
            } else {
                memo[i][j] = false;
            }
        }
        return memo[i][j];
    }
}