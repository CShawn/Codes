package com.cshawn.codes.leetcodes.everyday;

/**
 * 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *
 * 提示: 1 <= num <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/4 8:12 上午
 */
public class Q367 {
    // 二分法
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num > 1 ? num >> 1 : num, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            long res = (long) mid * mid;
            if (res == num) {
                return true;
            } else if (res < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
