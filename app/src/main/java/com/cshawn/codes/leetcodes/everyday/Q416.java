package com.cshawn.codes.leetcodes.everyday;

/**
 * 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/30 3:07 下午
 */
public class Q416 {
    // 01背包: 相当于查找元素使总价值为所有元素价值的一半
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum >> 1;
        // 总和为奇数
        if ((target << 1) != sum) {
            return false;
        }
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    // 01背包: 相当于查找元素使总价值为所有元素价值的一半
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum >> 1;
        // 总和为奇数
        if ((target << 1) != sum) {
            return false;
        }
        // dp[i][j] 代表考虑前 i 件物品，能否凑出价值「恰好」为 j 的方案
//        boolean[][] dp = new boolean[n+1][target+1];
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i - 1];
            for (int j = target; j >= cur; j--) {
                dp[j] = dp[j] || dp[j - cur];
            }
        }
        return dp[target];
    }
}
