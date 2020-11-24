package com.cshawn.leetcodes.sword;

/**
 * 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/11/24 17:24
 */
public class Sword_16 {
    /**
     * 当n很大时，x可以求平方，x^2再平方得到x^4，再x^8，依次可以加快速度。
     * n不是2的幂时，可以用x, x^2, x^4...拼凑，这不正相当于2进制的表示方式。
     * 那么，可以把n当作2进制数，按位去计算x的i次方，最后再相乘即可得到结果。
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        boolean positive = n > 0;
        long b = n;
        // 先转为正数
        if (!positive) {
            //  n∈[−2147483648,2147483647] ，
            //  因此当 n = -2147483648n=−2147483648 时执行 n = -nn=−n 会因越界而赋值出错。
            //  解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
//            n = -n;
            b = -b;
        }
        double pow = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                pow *= x;
            }
            x *= x;
            b >>= 1;
        }
        return positive ? pow : 1 / pow;
    }
}
