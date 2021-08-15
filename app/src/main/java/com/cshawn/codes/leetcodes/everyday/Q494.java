package com.cshawn.codes.leetcodes.everyday;

/**
 * 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/7 5:52 下午
 */
public class Q494 {
    private int result = 0;

    // 方法1：回溯
    public int findTargetSumWays1(int[] nums, int target) {
        backTracking(nums, 0, target, 0);
        return result;
    }

    private void backTracking(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                result++;
            }
            return;
        }
        backTracking(nums, index + 1, target, sum + nums[index]);
        backTracking(nums, index + 1, target, sum - nums[index]);
    }

    // 方法2：动态规划
    // 设数组总和为sum, 置为负号的数字之和为neg, 则其余数字和为sum-neg,
    // 则target=(sum-neg)-neg = sum - 2 * neg;
    // 可得neg = (sum - target) / 2;那么sum−target 是非负偶数
    // 问题转化为在nums中查找和为neg的子序列个数
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int v = sum - target;
        if (v < 0 || (v & 1) == 1) {
            return 0;
        }
        int neg = v >> 1;
        // dp[i][j]表示nums前i个数中元素之和等于j的方案数
        int[][] dp = new int[nums.length + 1][neg + 1];
        // 不选择元素，和为0，方案数为1
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][neg];
    }

    // 优化空间
    // i只与i - 1有关，滚动数组
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int v = sum - target;
        if (v < 0 || (v & 1) == 1) {
            return 0;
        }
        int neg = v >> 1;
        // dp[i][j]表示nums前i个数中元素之和等于j的方案数
        int[][] dp = new int[2][neg + 1];
        // 不选择元素，和为0，方案数为1
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i & 1][j] = dp[(i & 1) ^ 1][j];
                if (j >= nums[i - 1]) {
                    dp[i & 1][j] += dp[(i - 1) & 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length & 1][neg];
    }

    // 优化空间：倒序遍历
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int v = sum - target;
        if (v < 0 || (v & 1) == 1) {
            return 0;
        }
        int neg = v >> 1;
        // dp[i][j]表示nums前i个数中元素之和等于j的方案数
        int[] dp = new int[neg + 1];
        // 不选择元素，和为0，方案数为1
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}