package com.cshawn.leetcodes.crack;

/**
 * 下一个数
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * 示例1:
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 *
 * 示例2:
 *  输入：num = 1
 *  输出：[2, -1]
 * 提示:
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closed-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/18 9:12 下午
 */
public class Q5_4 {
    // 如      11011001，
    // 较大数为 11011010,将最后一个"10"变为"01",并将后边的1放到最后
    // 较小数为 11010110,将最后一个"01"变为"10",并将后边的1放到最前
    // 当数字为连续的1时，无较小数，当全为1(Int最大值)时，无较大数
    public int[] findClosedNumbers(int num) {
        if (num == 0) {
            return new int[]{0,0};
        }
        if (num == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        // 找较大的数
        int temp = num;
        int count = 0;
        int ones = 0;
        // 找到最后一个1
        while ((temp & 1) != 1) {
            temp = temp >> 1;
            count++;
        }
        // 找到最后一串1前的0
        while ((temp & 1) != 0) {
            temp = temp >> 1;
            count++;
            ones++;
        }
        int bigger = -1;
        if (count < 32) {
            // 将01变为10，并左移至原位置
            temp = (temp | 1) << count;
            if (ones > 1) {
                // 恢复之前的连续1
                int one = (1 << (ones - 1)) - 1;
                bigger = temp | one;
            } else {
                bigger = temp;
            }
        }
        // 找较小的数
        temp = num;
        count = 0;
        // 找到最后一个0
        while ((temp & 1) != 0) {
            temp = temp >> 1;
            count++;
        }
        ones = count;
        // 找到最后一串0前的1，注意移位不能超过32
        while ((temp & 1) != 1 && count < 32) {
            temp = temp >> 1;
            count++;
        }
        int smaller = -1;
        if (count < 32) {
            // 将10变为01，并左移至原位置
            temp = ((temp >> 1 << 2) | 1) << (count - 1);
            if (ones > 0) {
                // 恢复之前的连续1
                int one = ((1 << ones) - 1) << (count - 1 - ones);
                smaller = temp | one;
            } else {
                smaller = temp;
            }
        }
        return new int[]{bigger, smaller};
    }
}
