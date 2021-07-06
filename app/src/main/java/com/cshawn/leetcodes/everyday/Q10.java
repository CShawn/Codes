package com.cshawn.leetcodes.everyday;

import java.util.Arrays;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 示例 1：
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3：
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4：
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5：
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 * 提示：
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/6 10:22 上午
 */
public class Q10 {
    // 方法1：动态规划
    public boolean isMatch1(String s, String p) {
        // dp[i][j]表示s的[0,i]子字符串与p的[0,j]子字符串是否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = match(s, p, i, j) ? dp[i - 1][j - 1] : false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean match(String s, String p, int si, int pi) {
        return si != 0 && (s.charAt(si - 1) == p.charAt(pi - 1) || p.charAt(pi - 1) == '.');
    }

    // 方法2：回溯
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        for (boolean[] m : memo) {
            Arrays.fill(m, true);
        }
        return backTracking(memo, s, p, 0, 0);
    }

    private boolean backTracking(boolean[][] memo, String s, String p, int si, int pi) {
        if (!memo[si][pi]) {
            return false;
        }
        // 当s到达末尾而p可能还未遍历结束，如果后续字符为*a*b*之类的字符串，则再次递归
        if (si >= s.length()) {
            memo[si][pi] = pi == p.length() || (pi + 1 < p.length() && p.charAt(pi + 1) == '*' && backTracking(memo, s, p, si, pi + 2));
            return memo[si][pi];
        }
        if (pi >= p.length()) {
            memo[si][pi] = false;
            return false;
        }
        // 当前位置匹配成功
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
            // p下一个字符为*
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                memo[si][pi] = backTracking(memo, s, p, si + 1, pi + 2) || backTracking(memo, s, p, si + 1, pi) || backTracking(memo, s, p, si, pi + 2);
            } else {
                memo[si][pi] = backTracking(memo, s, p, si + 1, pi + 1);
            }
        } else {
            // p下一个字符为*，可认为p当前字符与*未匹配任何字符，向后继续
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                memo[si][pi] = backTracking(memo, s, p, si, pi + 2);
            } else {
                memo[si][pi] = false;
            }
        }
        return memo[si][pi];
    }
}
