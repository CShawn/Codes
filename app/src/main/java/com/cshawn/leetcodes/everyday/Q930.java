package com.cshawn.leetcodes.everyday;

/**
 * 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 *
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 *
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/8 5:28 下午
 */
public class Q930 {
    // 方法1：前缀和+滑动窗口
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int slow = 0, fast = 1, result = 0;
        while (fast < sum.length) {
            int s = sum[fast] - sum[slow];
            if (s > goal) {
                slow++;
            } else if(s < goal) {
                fast++;
            } else {
                int temp = slow;
                while (sum[fast] - sum[temp] == goal && temp < fast) {
                    temp++;
                    result++;
                }
                fast++;
            }
        }
        return result;
    }
}
