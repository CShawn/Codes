package com.cshawn.codes.leetcodes.everyday;

/**
 * 数组元素积的符号
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 *
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 *
 * 示例 1：
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 *
 * 示例 2：
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 *
 * 示例 3：
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * 提示：
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sign-of-the-product-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/11 12:08 下午
 */
public class Q5726 {
    // 方法1：偶数个负数为正
    public int arraySign1(int[] nums) {
        int negative = 0;
        boolean zero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = true;
            } else if (nums[i] < 0) {
                negative++;
            }
        }
        return zero ? 0 : (negative & 1) == 0 ? 1 : -1;
    }

    // 方法2：优化方法1
    public int arraySign2(int[] nums) {
        int negative = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negative++;
            }
        }
        return (negative & 1) == 0 ? 1 : -1;
    }

    // 方法2：遇到负数取反一次
    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                result = -result;
            }
        }
        return result;
    }
}
