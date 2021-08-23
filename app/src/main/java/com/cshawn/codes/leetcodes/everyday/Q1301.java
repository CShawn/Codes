package com.cshawn.codes.leetcodes.everyday;

import java.util.List;

/**
 * 最大得分的路径数目
 * 给你一个正方形字符数组board，你从数组最右下方的字符'S'出发。
 * 你的目标是到达数组最左上角的字符'E' ，数组剩余的部分为数字字符1, 2, ..., 9或者障碍 'X'。
 * 在每一步移动中，你可以向上、向左或者左上方移动，可以移动的前提是到达的格子没有障碍。
 * 一条路径的 「得分」 定义为：路径上所有数字的和。
 * 请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对10^9 + 7 取余。
 * 如果没有任何路径可以到达终点，请返回[0, 0] 。
 *
 * 示例 1：
 * 输入：board = ["E23","2X2","12S"]
 * 输出：[7,1]
 *
 * 示例 2：
 * 输入：board = ["E12","1X1","21S"]
 * 输出：[4,2]
 *
 * 示例 3：
 * 输入：board = ["E11","XXX","11S"]
 * 输出：[0,0]
 *
 * 提示： 2 <= board.length == board[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-paths-with-max-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/23 10:02 上午
 */
public class Q1301 {
    // 动态规划
    public int[] pathsWithMaxScore1(List<String> board) {
        int mod = 1000000007;
        int n = board.size();
        // dp[i][j][k]表示从起始点到达[i,j]位置的[最大路径,路径数]
        int[][][] dp = new int[n][n][2];
        dp[n - 1][n - 1] = new int[]{0, 1};
        for (int i = n - 2; i >= 0; i--) {
            char c = board.get(n - 1).charAt(i);
            if (c == 'X') {
                break;
            } else {
                dp[n - 1][i] = new int[]{c - '0' + dp[n - 1][i + 1][0], dp[n - 1][i + 1][1]};
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            char c = board.get(i).charAt(n - 1);
            if (c == 'X') {
                break;
            } else {
                dp[i][n - 1] = new int[]{c - '0' + dp[i + 1][n - 1][0], dp[i + 1][n - 1][1]};
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                char ch = board.get(i).charAt(j);
                if (ch == 'X') {
                    continue;
                }
                int cur = ch == 'E' ? 0 : ch - '0';
                int a = dp[i + 1][j][0];
                int b = dp[i][j + 1][0];
                int c = dp[i + 1][j + 1][0];
                int max = Math.max(Math.max(a, b), c);
                if (max == a) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i + 1][j][1]) % mod;
                }
                if (max == b) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j + 1][1]) % mod;
                }
                if (max == c) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i + 1][j + 1][1]) % mod;
                }
                if (dp[i][j][1] != 0) {
                    dp[i][j][0] = (max + cur) % mod;
                }
            }
        }
        return dp[0][0];
    }

    // 动态规划，空间优化
    public int[] pathsWithMaxScore(List<String> board) {
        int mod = 1000000007;
        int n = board.size();
        int[][] dp = new int[n][2];
        dp[n - 1] = new int[]{0, 1};
        for (int i = n - 2; i >= 0; i--) {
            char c = board.get(n - 1).charAt(i);
            if (c == 'X') {
                break;
            } else {
                dp[i] = new int[]{c - '0' + dp[i + 1][0], dp[i + 1][1]};
            }
        }
        int[] pre = new int[2], cur = new int[2];
        for (int i = n - 2; i >= 0; i--) {
            char last = board.get(i).charAt(n - 1);
            if (last == 'X' || dp[n - 1][1] == 0) {
                pre[0] = 0;
                pre[1] = 0;
            } else {
                pre[0] = last - '0' + dp[n - 1][0];
                pre[1] = dp[n - 1][1];
            }
            for (int j = n - 2; j >= 0; j--) {
                char ch = board.get(i).charAt(j);
                if (ch == 'X') {
                    dp[j + 1][0] = pre[0];
                    dp[j + 1][1] = pre[1];
                    pre[0] = 0;
                    pre[1] = 0;
                    continue;
                }
                cur[0] = 0;
                cur[1] = 0;
                int num = ch == 'E' ? 0 : ch - '0';
                int a = dp[j + 1][0];
                int b = dp[j][0];
                int c = pre[0];
                int max = Math.max(Math.max(a, b), c);
                if (max == a) {
                    cur[1] = (cur[1] + dp[j + 1][1]) % mod;
                }
                if (max == b) {
                    cur[1] = (cur[1] + dp[j][1]) % mod;
                }
                if (max == c) {
                    cur[1] = (cur[1] + pre[1]) % mod;
                }
                if (cur[1] != 0) {
                    cur[0] = (max + num) % mod;
                }
                dp[j + 1][0] = pre[0];
                dp[j + 1][1] = pre[1];
                pre[0] = cur[0];
                pre[1] = cur[1];
            }
            dp[0][0] = pre[0];
            dp[0][1] = pre[1];
        }
        return dp[0];
    }
}
