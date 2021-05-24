package com.cshawn.leetcodes.everyday;

/**
 * 奇怪的打印机
 * 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 * 示例 1：
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 *
 * 示例 2：
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/24 9:37 下午
 */
public class Q664 {
    // 动态规划
    public int strangePrinter(String s) {
        // dp[i][j]表示[i,j]范围内的最小打印次数
        int[][] dp = new int[s.length()][s.length()];
        // 当字符串首尾字符相同时，可以一次打印，也就是最后一个字符无所谓，dp[i][j]=dp[i][j-1]
        // 当字符串首尾字符不同时，dp[i][j]=min(dp[i][k]+dp[k+1][j])，其中i<=k<=j
        // 可见，计算j时，希望j-1已被计算，则j需要从小到大遍历
        // 计算i时，需要dp[k+1][j]的值，因此需要i从大到小遍历
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < dp[i].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
