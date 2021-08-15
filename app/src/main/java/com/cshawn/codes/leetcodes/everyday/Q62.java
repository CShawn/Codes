package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 *
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/14 1:14 下午
 */
public class Q62 {
    // 方法1：动态规划
    public int uniquePaths1(int m, int n) {
        // dp[i][j]表示从起始点到达[i-1,j-1]位置的路径数
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 方法2：优化空间：滚动数组
    public int uniquePaths2(int m, int n) {
        // dp[i][j]表示从起始点到达[i-1,j-1]位置的路径数
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], 1);
        dp[1][0] = 1;
        for (int i = 1; i < m; i++) {
            int index = i & 1;
            int other = index ^ 1;
            for (int j = 1; j < n; j++) {
                dp[index][j] = dp[other][j] + dp[index][j - 1];
            }
        }
        return dp[(m - 1) & 1][n - 1];
    }

    // 方法3：优化空间，优化为一维
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }

    // 方法4：数学，排列组合
    // 共可以向下走m-1向右走n-1，共计m+n-2步，排列组合为C(m+n-2, m-1)种
    public int uniquePaths(int m, int n) {
        long result = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            result = result * x / y;
        }
        return (int)result;
    }
}
