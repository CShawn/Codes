package com.cshawn.codes.leetcodes.sword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/24 9:06 下午
 */
public class Sword_57 {
    // 方法1：使用HashSet存储对应的数字索引，此方法不用关心是否递增数组
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
            map.add(nums[i]);
        }
        return new int[0];
    }

    // 方法2：因数组递增，可以使用双指针两头缩进，提高速度
    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target){
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
