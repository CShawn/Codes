package com.cshawn.leetcodes.everyday;

import java.util.List;

/**
 * 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 * 进阶：你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/22 11:32 上午
 */
public class Q120 {
    // 动态规划
    public int minimumTotal1(List<List<Integer>> triangle) {
        // dp[i][j]表示到达[i][j]的最小路径和,dp[i][j]=min(dp[i-1,j-1],dp[i-1,j])+triangle[i][j]
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 2];
        for (int i = 0; i < m - 1; i++) {
            dp[i + 1][0] = Integer.MAX_VALUE;
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                dp[i + 1][j + 1] = Math.min(dp[i][j], dp[i][j + 1]) + line.get(j);
            }
            dp[i + 1][line.size() + 1] = Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> last = triangle.get(m - 1);
        for (int j = 0; j < last.size(); j++) {
            dp[m][j + 1] = Math.min(dp[m - 1][j], dp[m - 1][j + 1]) + last.get(j);
            min = Math.min(min, dp[m][j + 1]);
        }
        return min;
    }

    // 简化代码
    public int minimumTotal2(List<List<Integer>> triangle) {
        // dp[i][j]表示到达[i][j]的最小路径和,dp[i][j]=min(dp[i-1,j-1],dp[i-1,j])+triangle[i][j]
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            List<Integer> line = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + line.get(0);
            for (int j = 1; j < line.size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + line.get(j);
            }
            dp[i][line.size() - 1] = dp[i - 1][line.size() - 2] + line.get(line.size() - 1);
        }
        int min = dp[m - 1][0];
        List<Integer> last = triangle.get(m - 1);
        for (int j = 0; j < last.size(); j++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }

    // 优化空间
    public int minimumTotal3(List<List<Integer>> triangle) {
        // dp[i] 表示到达当前层第i的位置的最小路径和
        int[] dp = new int[triangle.size() + 2];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size() - 1; i++) {
            List<Integer> line = triangle.get(i);
            for (int j = line.size() - 1; j >= 0; j--) {
                dp[j + 1] = Math.min(dp[j], dp[j + 1]) + line.get(j);
            }
            dp[line.size() + 1] = Integer.MAX_VALUE;
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        int min = Integer.MAX_VALUE;
        for (int j = last.size() - 1; j >= 0; j--) {
            dp[j + 1] = Math.min(dp[j], dp[j + 1]) + last.get(j);
            min = Math.min(min, dp[j + 1]);
        }
        return min;
    }

    // 优化空间，简化代码
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i] 表示到达当前层第i的位置的最小路径和
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            dp[line.size() - 1] = dp[line.size() - 2] + line.get(line.size() - 1);
            for (int j = line.size() - 2; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + line.get(j);
            }
            dp[0] = dp[0] + line.get(0);
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        int min = dp[0];
        for (int j = 0; j < last.size(); j++) {
            min = Math.min(min, dp[j]);
        }
        return min;
    }
}