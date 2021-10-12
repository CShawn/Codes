package com.cshawn.codes.leetcodes.everyday;

/**
 * 两数相除
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231− 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/12 8:13 上午
 */
public class Q29 {
    // 二分 + 快速乘法
    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long x = dividend;
        long y = divisor;
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        long left = 0, right = x, mid;
        while (left < right) {
            mid = left + right + 1 >> 1;
            if (quickMulti(y, mid) <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        long result = neg ? -left : left;
        // 判断是否溢出
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    private long quickMulti(long a, long b) {
        long result = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                result += a;
            }
            b >>= 1;
            a <<= 1;
        }
        return result;
    }

    // 模拟竖式除法
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        int result = 0;
        boolean negative = (dividend ^ divisor) < 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        for (int i = 31; i >= 0; i--) {
            if ((x >> i) >= y) {
                result += 1 << i;
                x -= y << i;
            }
        }
        if (negative){
            result = -result;
        }
        return result;
    }
}
