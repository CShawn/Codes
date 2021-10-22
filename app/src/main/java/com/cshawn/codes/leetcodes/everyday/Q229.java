package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数 II
 * 给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：[3]
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/22 5:40 下午
 */
public class Q229 {
    // 摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int one = 0, two = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 > 0 && num == one) {
                count1++;
            } else if (count2 > 0 && num == two) {
                count2++;
            } else if (count1 == 0) {
                one = num;
                count1++;
            } else if (count2 == 0) {
                two = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        int target = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == one) {
                count1++;
            } else if (num == two) {
                count2++;
            }
        }
        if (count1 > target) {
            result.add(one);
        }
        if (count2 > target) {
            result.add(two);
        }
        return result;
    }
}
