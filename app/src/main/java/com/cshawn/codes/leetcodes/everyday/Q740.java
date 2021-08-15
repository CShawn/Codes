package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 *
 * 示例2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/5 9:10 下午
 */
public class Q740 {
    // 动态规划：与Q198相似
    public int deleteAndEarn1(int[] nums) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }
        // dp[i]表示前i个数能获得的最大点数
        int[] dp = new int[max + 1];
        dp[1] = map.getOrDefault(1, 0);
        for (int i = 2; i <= max; i++) {
            // 选择当前数字前一个数字时，当前数字被删除。选择当前数字时，必然选择了i-2的数字，再加上当前数字的点数得到当前的点数
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + map.getOrDefault(i, 0) * i);
        }
        return dp[max];
    }

    // 优化方法1
    public int deleteAndEarn(int[] nums) {
        // 不使用Map,使用数组来统计出现次数
        int max = nums[0];
        // 求出最大值
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 统计数字出现次数
        int[] map = new int[max + 1];
        for (int num : nums) {
            map[num]++;
        }
        // 动态规划i只与i-1和i-2有关，使用两个变量保存
        int i_2 = 0, i_1 = map[1], result = i_1;
        for (int i = 2; i <= max; i++) {
            // 选择当前数字前一个数字时，当前数字被删除。选择当前数字时，必然选择了i-2的数字，再加上当前数字的点数得到当前的点数
            result = Math.max(i_1, i_2 + map[i] * i);
            i_2 = i_1;
            i_1 = result;
        }
        return result;
    }
}
