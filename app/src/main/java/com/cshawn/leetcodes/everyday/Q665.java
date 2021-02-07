package com.cshawn.leetcodes.everyday;

/**
 * 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明：
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/7 12:31 下午
 */
public class Q665 {

    public boolean checkPossibility(int[] nums) {
        // 元素小于等于2个时，必然可以构造
        if (nums.length <= 2) {
            return true;
        }
        // 可以改变的最大元素个数
        int flag = 1;
        // 判断前两个元素逆序
        if (nums[1] < nums[0]) {
            flag--;
        }
        // 判断最后两个元素逆序
        if (nums[nums.length - 1] < nums[nums.length - 2]) {
            if (flag == 0) {
                return false;
            }
            flag--;
        }
        // 从第3个元素遍历到倒数第2个元素，也即至少4个元素。上边两个判断已经包括了3个元素的情况
        for (int i = 2; i < nums.length - 1; i++) {
            // 发现逆序
            if (nums[i] < nums[i - 1]) {
                // i为凹下去的拐点
                // 如果i比i-2大，或者i+1比i-1大，则可以改变一个元素实现正序
                if (nums[i] >= nums[i - 2] || nums[i + 1] >= nums[i - 1]) {
                    // 可改变则减1，否则返回false
                    if (flag > 0) {
                        flag--;
                    } else {
                        return false;
                    }
                } else {
                    // 不满足改变条件，返回false
                    return false;
                }
            }
        }
        return true;
    }
}
