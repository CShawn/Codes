package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/24 12:15 下午
 */
public class Q377 {

    // 方法1：记忆化递归
    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(dp, nums, target);
    }

    private int dfs(int[] dp, int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int num : nums) {
            res += dfs(dp, nums, target - num);
        }
        dp[target] = res;
        return res;
    }

    // 方法2：动态规划
    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示组成i的个数
        int[] dp = new int[target + 1];
        // 要组成0，只有不选择元素一种方法
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // 计算每个dp[i-num]的个数和即为结果
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
