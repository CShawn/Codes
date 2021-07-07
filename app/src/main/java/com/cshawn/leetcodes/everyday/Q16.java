package com.cshawn.leetcodes.everyday;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/7 4:39 下午
 */
public class Q16 {
    // 排序+双指针
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return target;
                }
                int temp = Math.abs(sum - target);
                if (temp < diff) {
                    diff = temp;
                    result = sum;
                }
                if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return result;
    }

    // 优化方法1
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return target;
                }
                int temp;
                int min = nums[i] + nums[lo] + nums[lo + 1];
                if (target < min) {
                    temp = Math.abs(min - target);
                    if (temp < diff) {
                        diff = temp;
                        result = min;
                    }
                    break;
                } else {
                    int max = nums[i] + nums[hi] + nums[hi - 1];
                    if (target > max) {
                        temp = Math.abs(max - target);
                        if (temp < diff) {
                            diff = temp;
                            result = max;
                        }
                        break;
                    } else {
                        temp = Math.abs(sum - target);
                        if (temp < diff) {
                            diff = temp;
                            result = sum;
                        }
                        if (sum > target) {
                            hi--;
                        } else {
                            lo++;
                        }
                    }
                }

            }
        }
        return result;
    }
}
