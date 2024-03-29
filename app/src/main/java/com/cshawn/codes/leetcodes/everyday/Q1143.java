package com.cshawn.codes.leetcodes.everyday;

/**
 * 最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3  
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * 提示：
 * 1 <= text1.length, text2.length <= 1000
 * text1 和text2 仅由小写英文字符组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/3 12:25 下午
 */
public class Q1143 {
    // 方法1：动态规划
    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        // dp[i][j]表示text1以i结尾，text2以j结尾的子字符串中，最大公共子序列的长度
        int[][] dp = new int[text1.length()][text2.length()];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) || dp[i - 1][0] == 1 ? 1 : 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = text1.charAt(0) == text2.charAt(j) || dp[0][j - 1] == 1 ? 1 : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = text1.charAt(i) == text2.charAt(j) ?
                        dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    // 方法2：优化方法1，为不单独处理i或j为0的情况，dp长宽各加1
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        // dp[i + 1][j + 1]表示text1以i结尾，text2以j结尾的子字符串中，最大公共子序列的长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ?
                        dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    // 方法3：优化空间。因[i][j]只与左侧和上方的两个元素有关，那么只用两行存储即可
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        // 只用两行存储数据
        int[][] dp = new int[2][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                // 根据奇偶性决定使用哪行以及存储在哪行
                int now = i & 1;
                int use = 1 - now;
                dp[now][j + 1] = text1.charAt(i) == text2.charAt(j) ?
                        dp[use][j] + 1 : Math.max(dp[use][j + 1], dp[now][j]);
            }
        }
        return dp[1 - (text1.length() & 1)][text2.length()];
    }
}
