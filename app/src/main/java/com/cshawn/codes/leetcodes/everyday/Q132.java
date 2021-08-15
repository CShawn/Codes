package com.cshawn.codes.leetcodes.everyday;

/**
 * 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 *
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/8 7:10 下午
 */
public class Q132 {
    // Q131中相当于遍历了全部的切分可能，如果只在其中增加切分次数统计，在此题中必然超时
    // 动态规划，类似于最长递增子数列的思想，
    // dp[i]表示以s[i]结尾的子串最小的切分次数，当[i,length]为回文时，dp[length]=min(dp[i])+1
    public int minCut(String s) {
        // 预处理s中回文情况
        boolean[][] palindromic = new boolean[s.length()][s.length()];
        // 从右下向左上
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                palindromic[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || palindromic[i + 1][j - 1]);
            }
        }
        // 当字符串回文时，无需切分
        if (palindromic[0][s.length() - 1]) {
            return 0;
        }
        // dp[i]表示以s[i]结尾的子串最小的切分次数
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            // 当前子串回文时，子串的最小切分次数为0
            if (palindromic[0][i]) {
                dp[i] = 0;
            } else {
                // 在子串中遍历查找j后半段回文时，当前切分次数为dp[j]+1
                int min = s.length();
                for (int j = 0; j < i; j++) {
                    if (palindromic[j + 1][i]) {
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }
        }
        return dp[s.length() - 1];
    }
}
