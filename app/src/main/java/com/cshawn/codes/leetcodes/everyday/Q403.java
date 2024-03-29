package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 青蛙过河
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 示例 1：
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 *
 * 示例 2：
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * 提示：
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 231 - 1
 * stones[0] == 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/29 5:08 下午
 */
public class Q403 {
    // 方法1：记忆化搜索+二分查找
    public boolean canCross1(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        return dfs(stones, dp, 0, 0);
    }

    /**
     * 记忆化搜索
     * @param index 当前stones中的索引
     * @param k 前一次使用的k
     */
    private boolean dfs(int[] stones, Boolean[][] dp, int index, int k) {
        if (index == stones.length - 1) {
            return true;
        }
        if (dp[index][k] != null) {
            return dp[index][k];
        }
        for (int i = -1; i <= 1; i++) {
            if (k + i > 0) {
                int nextIndex = Arrays.binarySearch(stones, index + 1, stones.length, stones[index] + k + i);
                if (nextIndex >= 0 && dfs(stones, dp, nextIndex, k + i)) {
                    dp[index][k] = true;
                    return true;
                }
            }
        }
        dp[index][k] = false;
        return false;
    }

    // 方法2：动态规划
    public boolean canCross(int[] stones) {
        // dp[i][k]表示上一次跳k步能否到达i
        // dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];其中i - j = k
        boolean[][] dp = new boolean[stones.length][stones.length + 1];
        // 初始第一块可达
        dp[0][0] = true;
        // 先判断数组是否有明显的不可到达条件
        for (int i = 1; i < stones.length; i++) {
            // 当相邻的两块石头相差大于其位置，则必然无法到达
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                // 相差较大，停止继续计算
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == stones.length - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
