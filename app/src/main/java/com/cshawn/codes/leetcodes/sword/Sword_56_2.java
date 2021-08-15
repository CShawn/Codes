package com.cshawn.codes.leetcodes.sword;

/**
 * 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/24 12:49 下午
 */
public class Sword_56_2 {
    // 出现3次，利用3的特性，二进制每位的和必能被3整除，如果不能，则目标数字在此位上为1
    public int singleNumber(int[] nums) {
        // 记录目标数字
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                // 统计某一位上的值总和
                sum += nums[j] & 1;
                nums[j] >>>= 1;
            }
            // 不能被3整除，直接算作目标值的一部分
            result += sum % 3 == 0 ? 0 : Math.pow(2, i);
        }
        return result;
    }
}
