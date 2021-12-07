package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *
 * 示例 1：
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 *
 * 示例 2：
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 *
 * 示例 3：
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coloring-a-border
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/7 8:19 上午
 */
public class Q1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // 遍历过的点
        Set<Long> match = new HashSet<>();
        // 记录边界
        Set<Long> result = new HashSet<>();
        dfs(grid, row, col, grid[row][col], match, result);
        for (long colors : result) {
            grid[(int) (colors)][(int) (colors >> 32)] = color;
        }
        return grid;
    }

    // 返回结果为当前位置颜色与初始点颜色是否相同
    private boolean dfs(int[][] grid, int row, int col, int color, Set<Long> match, Set<Long> result) {
        if (grid[row][col] != color) {
            return false;
        }
        long cur = (long) row | ((long) col << 32);
        if (!match.contains(cur)) {
            match.add(cur);
            if (row <= 0 || !dfs(grid, row - 1, col, color, match, result)) {
                result.add(cur);
            }
            if (row >= grid.length - 1 || !dfs(grid, row + 1, col, color, match, result)) {
                result.add(cur);
            }
            if (col <= 0 || !dfs(grid, row, col - 1, color, match, result)) {
                result.add(cur);
            }
            if (col >= grid[0].length - 1 || !dfs(grid, row, col + 1, color, match, result)) {
                result.add(cur);
            }
        }
        return true;
    }
}
