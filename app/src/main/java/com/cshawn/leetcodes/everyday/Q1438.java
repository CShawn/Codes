package com.cshawn.leetcodes.everyday;

import java.util.TreeMap;

/**
 * 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 示例 2：
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 *
 * 示例 3：
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/21 9:15 下午
 */
public class Q1438 {
    // 数组中的两元素之差最大值为最大元素与最小元素之差，所以需要查找子数组中的最值，
    // 而子数组又是不断变化的，因此需要在滑动窗口中O(1)查找最值，使用TreeMap
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0, result = 0;
        // <数字，出现的次数>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            // 当前子数组不符合条件时
            if (map.lastKey() - map.firstKey() > limit) {
                // 不满足条件时，右移左指针并将次数减1，当为0时删除
                // 此外，可以增加空间用以存储元素出现的位置，以更快的得到left的位置
                while (!map.isEmpty() && map.lastKey() - map.firstKey() > limit) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
            }
            // 更新result
            result = Math.max(result, right - left + 1);
            // 右指针右移
            right++;
        }
        return result;
    }
}
