package com.cshawn.leetcodes.everyday;

/**
 * 出界的路径数
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 *
 * 示例 1：
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 *
 * 示例 2：
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 *
 * 提示：
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/12 3:51 下午
 */
public class Q576 {
    // 动态规划
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // 无法到达边界
        if (maxMove <= startRow &&
                startRow + maxMove < m &&
                maxMove <= startColumn &&
                startColumn + maxMove < n
        ) {
            return 0;
        }
        // dp[i][j][k]表示走i步到达(j,k)点的路径数
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        for (int i = 0; i < maxMove; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int x = j + direction[0], y = k + direction[1];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                result = (result + count) % 1000000007;
                            } else {
                                dp[i + 1][x][y] = (dp[i + 1][x][y] + count) % 1000000007;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
