package com.cshawn.codes.leetcodes.everyday;

/**
 * 两个字符串的删除操作
 * 给定两个单词word1和word2，找到使得word1和word2相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 * 提示：
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/25 11:00 上午
 */
public class Q583 {
    // 动态规划，最长公共子序列
    public int minDistance1(String word1, String word2) {
        if (word1 == null) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        // dp[i][j]表示word1的前i长度子串与word2前j子串的最长公共子序列
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - (dp[word1.length()][word2.length()] << 1);
    }

    // 优化空间
    public int minDistance(String word1, String word2) {
        if (word1 == null) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        // dp[i][j]表示word1的前i长度子串与word2前j子串的最长公共子序列
        int[][] dp = new int[2][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            int cur = i & 1, pre = cur ^ 1;
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[cur][j + 1] = dp[pre][j] + 1;
                } else {
                    dp[cur][j + 1] = Math.max(dp[pre][j + 1], dp[cur][j]);
                }
            }
        }
        return word1.length() + word2.length() - (dp[word1.length() & 1 ^ 1][word2.length()] << 1);
    }
}
