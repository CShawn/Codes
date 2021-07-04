package com.cshawn.leetcodes.everyday;

/**
 * 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/4 10:05 上午
 */
public class Q645 {
    // 方法1：位运算
    public int[] findErrorNums1(int[] nums) {
        int len = (nums.length - 1) / 8 + 1;
        byte[] temp = new byte[len];
        int repeat = 0;
        for (int n : nums) {
            if (repeat == 0 && (temp[(n - 1) / 8] & (1 << (n - 1) % 8)) != 0) {
                repeat = n;
            } else {
                temp[(n - 1) / 8] ^= 1 << (n - 1) % 8;
            }
        }
        int lost = 0;
        int tl = nums.length % 8;
        int t = 0;
        for (int i = 0; i < tl; i++) {
            t ^= 1 << i;
        }
        int end = tl == 0 ? len : len - 1;
        for (int i = 0; i < end; i++) {
            if (temp[i] != -1) {
                for (int j = 0; j < 8; j++) {
                    if ((temp[i] & (1 << j)) == 0) {
                        lost = i * 8 + j + 1;
                        break;
                    }
                }
                break;
            }
        }
        if (lost == 0 && temp[len - 1] != t) {
            for (int j = 0; j < tl; j++) {
                if ((temp[len - 1] & (1 << j)) == 0) {
                    lost = (len - 1) * 8 + j + 1;
                    break;
                }
            }
        }
        return new int[]{repeat, lost};
    }

    // 方法2：两次遍历
    public int[] findErrorNums(int[] nums) {
        boolean[] temp = new boolean[nums.length + 1];
        int repeat = 0;
        for (int num : nums) {
            if (temp[num]) {
                repeat = num;
            }
            temp[num] = true;
        }
        int lost = 0;
        for (int i = 1; i < temp.length; i++) {
            if (!temp[i]) {
                lost = i;
                break;
            }
        }
        return new int[]{repeat, lost};
    }
}