package com.cshawn.leetcodes.everyday;

/**
 * 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 示例1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * 示例2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * 提示：
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。`
 * @author C.Shawn
 * @date 2021/3/17 16:50
 */
public class Q115 {
    // 动态规划
    public int numDistinct1(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        // 定义dp[i][j]为s[i, length]中t[j, length]出现的个数
        int[][] dp = new int[s.length()][t.length()];
        // 从右下角水平向左再向上遍历，
        // 当s[i]==t[j]时，两个字符同时向右移，则为dp[i+1][j+1]；
        // 有可能s[i+1,length]中包含t[j]，所以dp[i][j]为两者之和=dp[i+1][j+1]+dp[i+1][j]
        // 不相等时，因为从右向左遍历，因此i+1已求出，
        // 所以在s[i+1,length]中求t[j,length]出现的次数，dp[i][j]=dp[i + 1][j]
        for (int i = s.length() - 1; i >= 0; i--) {
            // j为t最后一个字符时，当前s[i]与t[j]相同则需加1，再检查s[i+1][j]
            int j = t.length() - 1;
            if (s.charAt(i) == t.charAt(j)) {
                if (i == s.length() - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + 1;
                }
            } else {
                if (i == s.length() - 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
            for (j = t.length() - 2; j >= 0; j--) {
                // s子字符串比t子字符串短时，结果为0
                if (s.length() - i >= t.length() - j) {
                    dp[i][j] = s.charAt(i) == t.charAt(j) ? dp[i + 1][j + 1] + dp[i + 1][j] : dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    // 优化方法1
    public int numDistinct(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return 0;
        }
        // 因要求i+1,j+1，为了不越界，可将dp扩充一行一列
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 当j==t.length时，空字符串是s的子串
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        // 当i==s.length时，空字符串不包含其他子串，但0不用填充
//        for (int i = 0; i < t.length(); i++) {
//            dp[s.length()][i] = 0;
//        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                dp[i][j] = s.charAt(i) == t.charAt(j) ? dp[i + 1][j + 1] + dp[i + 1][j] : dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
