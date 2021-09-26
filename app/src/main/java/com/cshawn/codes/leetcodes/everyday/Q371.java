package com.cshawn.codes.leetcodes.everyday;

/**
 * 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符+ 和-，计算并返回两整数之和。
 *
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 *
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 *
 * 提示：-1000 <= a, b <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/26 3:12 下午
 */
public class Q371 {
    // 方法1：数电
    public int getSum1(int a, int b) {
        int carry = 0, result = 0, i = 0, sum, ai, bi;
        while (a != 0 || b != 0) {
            ai = a & 1;
            bi = b & 1;
            sum = carry ^ (ai ^ bi);
            carry = (ai ^ bi) & carry | (ai & bi);
            a >>>= 1;
            b >>>= 1;
            result |= sum << i++;
        }
        if (i < 32) {
            result |= carry << i;
        }
        return result;
    }

    // 方法2：位运算, 一次性计算多位
    public int getSum(int a, int b) {
        int carry = 0;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}