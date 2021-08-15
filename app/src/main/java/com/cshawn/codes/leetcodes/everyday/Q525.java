package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/3 8:52 下午
 */
public class Q525 {
    // 需要一个巧妙的思路，将0改为-1，那么1和0相同数量时相加和为0
    // 前缀和+哈希表，哈希表中存储当前和
    public int findMaxLength1(int[] nums) {
        int result = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 0 ? -1 : nums[i];
            if (preSum == 0) {
                result = Math.max(result, i + 1);
            } else {
                if (map.containsKey(preSum)) {
                    result = Math.max(result, i - map.get(preSum));
                } else {
                    map.put(preSum, i);
                }
            }
        }
        return result;
    }

    // 优化方法1，处理if判断，当和为0时，设出现位置为-1，统一逻辑
    public int findMaxLength(int[] nums) {
        int result = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 0 ? -1 : nums[i];
            if (map.containsKey(preSum)) {
                result = Math.max(result, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return result;
    }
}
