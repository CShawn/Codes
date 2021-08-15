package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/4 9:14 上午
 */
public class Q611 {
    // 方法1：排序 + 二分
    // 暴力O^3，三角形三边a+b>c,a-b<c，先排序，a<b<c，则只用检测a+b<c
    // 可通过二分找c，类似于三数之和的解法
    public int triangleNumber1(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1, right = nums.length - 1, mid;
                while (left <= right) {
                    mid = left + ((right - left) >> 1);
                    if (nums[i] + nums[j] > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (right != j) {
                    result += left - j - 1;
                }
            }
        }
        return result;
    }

    // 方法2：排序 + 双指针
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // 定义第三个数字k，在更新j的过程中k不断向后推
            // 因此j和k的遍历复杂度是N，故总时间复杂度为O(N^2)
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                while (k < nums.length && sum > nums[k]) {
                    k++;
                }
                result += k - j - 1;
            }
        }
        return result;
    }
}