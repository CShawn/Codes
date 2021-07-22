package com.cshawn.leetcodes.everyday;

import java.util.Arrays;

/**
 * 最小路径和
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/22 11:01 上午
 */
public class Q64 {
    // 动态规划
    public int minPathSum(int[][] grid) {
        // dp[i][j]表示到达dp[i][j]的最小路径和，dp[i][j]=min(dp[i-1][j],dp[i][j-1])
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][1] = 0;
        for (int i = 0; i < grid.length; i++) {
            dp[i + 1][0] = Integer.MAX_VALUE;
            for (int j = 0; j < grid[i].length; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}