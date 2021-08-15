package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/6 5:29 下午
 */
public class Q15 {
    // 排序+双指针
    // 常规做法三重循环回溯O(N^3)，而在遍历第2，3个数字时，可使用双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当第一个数字大于0时，不可能存在3数和为0
            if (nums[i] > target) {
                break;
            }
            // 第一个数字与上一个数字重复时取下一个
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 第二个数字与第三个数字必然一大一小，双指针两头取，使不重复
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    result.add(list);
                    // 第二个数字与上一个数字重复时取下一个
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    // 第三个数字与上一个数字重复时取下一个
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return result;
    }
}
