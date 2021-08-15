package com.cshawn.codes.leetcodes.everyday;

/**
 * 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 示例 1：
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：1->5->7或1->4->8
 *
 * 示例 2：
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：-19->-40
 *
 * 示例 3：
 * 输入：matrix = [[-48]]
 * 输出：-48
 * 
 * 提示：
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/22 2:07 下午
 */
public class Q931 {
    // 动态规划 + 滚动数组
    public int minFallingPathSum1(int[][] matrix) {
        // dp[i][j]表示到达matrix[i][j]的下降路径最小和
        int[][] dp = new int[2][matrix.length];
        System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
        for (int i = 1; i < matrix.length; i++) {
            int index = i & 1, pre = index ^ 1;
            dp[index][0] = Math.min(dp[pre][0], dp[pre][1]) + matrix[i][0];
            int end = matrix[i].length - 1;
            for (int j = 1; j < end; j++) {
                dp[index][j] = Math.min(Math.min(dp[pre][j - 1], dp[pre][j]), dp[pre][j + 1]) + matrix[i][j];
            }
            dp[index][end] = Math.min(
                    dp[pre][end],
                    dp[pre][end - 1]
            ) + matrix[i][end];
        }
        int last = (matrix.length - 1) & 1;
        int min = dp[last][0];
        for (int j = 1; j < matrix[matrix.length - 1].length; j++) {
            min = Math.min(min, dp[last][j]);
        }
        return min;
    }

    // 动态规划，利用matrix的空间，自底向上
    public int minFallingPathSum(int[][] matrix) {
        for (int i = matrix.length - 2; i >= 0; i--) {
            matrix[i][0] += Math.min(matrix[i + 1][0], matrix[i + 1][1]);
            int end = matrix[i].length - 1;
            for (int j = 1; j < end; j++) {
                matrix[i][j] += Math.min(Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]), matrix[i + 1][j + 1]);
            }
            matrix[i][end] += Math.min(matrix[i + 1][end], matrix[i + 1][end - 1]);
        }
        int min = matrix[0][0];
        for (int j = 1; j < matrix[0].length; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }
}