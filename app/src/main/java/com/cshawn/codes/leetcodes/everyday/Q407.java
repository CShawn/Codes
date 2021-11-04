package com.cshawn.codes.leetcodes.everyday;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 * 示例 1:
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 *
 * 示例 2:
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *
 * 提示:
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/3 8:40 上午
 */
public class Q407 {
    // 优先级队列
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }
        boolean[][] visit = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 存入最外层一圈的高度
        int lastColumn = n - 1;
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i * n, heightMap[i][0]});
            queue.offer(new int[]{i * n + lastColumn, heightMap[i][lastColumn]});
            visit[i][0] = true;
            visit[i][lastColumn] = true;
        }
        int lastRow = m - 1;
        for (int j = 0; j < n; j++) {
            queue.offer(new int[]{j, heightMap[0][j]});
            queue.offer(new int[]{lastRow * n + j, heightMap[lastRow][j]});
            visit[0][j] = true;
            visit[lastRow][j] = true;
        }
        int result = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            // 当前已记录的位置中最低的位置
            int[] cur = queue.poll();
            // 遍历此位置的上下左右四个方向
            for (int k = 0; k < 4; k++) {
                int x = cur[0] / n + directions[k];
                int y = cur[0] % n + directions[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y]) {
                    // 外层最低点比当前位置高，则当前位置可以积水
                    if (cur[1] > heightMap[x][y]) {
                        result += cur[1] - heightMap[x][y];
                    }
                    // 记录此积水的位置，高度为积水后的高度
                    queue.offer(new int[]{x * n + y, Math.max(heightMap[x][y], cur[1])});
                    visit[x][y] = true;
                }
            }
        }
        return result;
    }
}
