package com.cshawn.codes.leetcodes.everyday;

/**
 * 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 * 提示：
 * 1 <= n <= 231 - 1
 * @author C.Shawn
 * @date 2021/11/30 8:26 上午
 */
public class Q400 {
    public int findNthDigit1(int n) {
        int bits = 1, pow = 1, no = 1;
        long k = 0;
        while (true) {
            long range = 9L * pow * bits;
            if (n <= k + range) {
                int num = (int) (no + (n - k - 1) / bits);
                int b = (int) (bits - (n - k - 1) % bits - 1);
                while (b > 0) {
                    num /= 10;
                    b--;
                }
                return num % 10;
            }
            k += range;
            pow *= 10;
            no += range / bits++;
        }
    }

    public int findNthDigit(int n) {
        int bits = 1, pow = 1, no = 1;
        long range = 9L;
        while (n > range) {
            n -= range;
            pow *= 10;
            no += range / bits++;
            range = 9L * pow * bits;
        }
        int num = no + (n - 1) / bits;
        int b = bits - (n - 1) % bits - 1;
        while (b > 0) {
            num /= 10;
            b--;
        }
        return num % 10;
    }
}
