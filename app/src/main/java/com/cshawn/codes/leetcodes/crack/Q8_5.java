package com.cshawn.codes.leetcodes.crack;

/**
 * 递归乘法
 * 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *  输入：A = 1, B = 10
 *  输出：10
 *
 * 示例2:
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:保证乘法范围不会溢出
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/28 7:08 下午
 */
public class Q8_5 {
    public int multiply1(int A, int B) {
        int result = 0, i = 0;
        while (B != 0) {
            if ((B & 1) == 1) {
                result += A << i;
            }
            B >>= 1;
            i++;
        }
        return result;
    }

    public int multiply(int A, int B) {
        return B == 0 ? 0 : B == 1 ? A : ((B & 1) == 1 ? A : 0) + multiply(A << 1, B >> 1);
    }
}
