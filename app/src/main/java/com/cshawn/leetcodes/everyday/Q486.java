package com.cshawn.leetcodes.everyday;

/**
 * @author C.Shawn
 * @date 2021/6/16 9:31 下午
 */
public class Q486 {
    // 动态规划
    public boolean PredictTheWinner1(int[] nums) {
        // dp[i][j] 表示当剩下的石子堆为下标 i 到下标 j 时，当前玩家与另一个玩家的石子数量之差的最大值
        int[][] dp = new int[nums.length][nums.length];
        dp[nums.length - 1][nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    // 优化空间
    public boolean PredictTheWinner(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[nums.length - 1] >= 0;
    }
}
