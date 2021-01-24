package com.cshawn.leetcodes.sword;

/**
 * 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * 限制：2 <= nums.length <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/24 11:27 上午
 */
public class Sword_56 {
    public int[] singleNumbers(int[] nums) {
        // 两个相同的数字异或为0，相抵消；全部异或最终结果为两个目标数字异或的结果
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        // 两个不同数字异或的结果，其二进制表示的每一位中，为1的都表示这两个数字在此位上不同
        // 取得最后一位1
        int flag = res & (-res);
        // 用flag来将两个目标数字分开。
        // 两个相同的数字与flag相同或，值必相同，为0或不为0；而两个目标值与flag同或，一个为0，一个不为0
        // 用来记录最终结果
        int result = 0;
        for (int num : nums) {
            // 最终结果为两个目标值中的一个值
            if ((flag & num) != 0) {
                result ^= num;
            }
        }
        // res与result异或为另一个目标值
        return new int[]{result, res ^ result};
    }
}
