package com.cshawn.leetcodes.everyday;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * 提示：-231 <= x <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/15 5:01 下午
 */
public class Q7 {
    public int reverse1(int x) {
        int result = 0;
        // 反转至剩余一位
        while (x / 10 != 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        // 负数转为正数
        if (result < 0) {
            result = -result;
        }
        int max = Integer.MAX_VALUE / 10;
        // 超出最大整数返回0
        if (result > max) {
            return 0;
        }
        int last = x % 10;
        // 前边数字相同时
        if (result == max) {
            int bit = Integer.MAX_VALUE % 10;
            if (last > 0) {
                // 检查最后一位是否越界
                if (last > bit) {
                    return 0;
                }
                return result * 10 + last;
            } else {
                // 负数时检查最后一位是否越界
                if (-last > bit + 1) {
                    return 0;
                }
                // 计算负数反转结果
                return -(-last + result * 10);
            }
        }
        // 在范围内时，将最后一位反转
        return last > 0 ? result * 10 + last : -(-last + result * 10);
    }

    // 方法2
    public int reverse(int x) {
        int result = 0, pop;
        // 最大数/10
        int max = Integer.MAX_VALUE / 10;
        // 最大数最后一位
        int bit = Integer.MAX_VALUE % 10;
        while (x != 0) {
            // 求尾数
            pop = x % 10;
            // 正数超出范围或相等而尾数大
            if (result > max
                    || (result == max && pop > bit)
                    // 负数超出范围或相等而尾数大
                    || result < -max
                    || (result == -max && pop < -bit - 1)
            ) {
                return 0;
            }
            result = 10 * result + pop;
            x /= 10;
        }
        return result;
    }
}