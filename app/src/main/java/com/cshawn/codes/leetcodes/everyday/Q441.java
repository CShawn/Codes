package com.cshawn.codes.leetcodes.everyday;

/**
 * 排列硬币
 * 你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
 * 阶梯的最后一行 可能 是不完整的。
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 *
 * 提示：1 <= n <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/10 12:05 下午
 */
public class Q441 {
    // 二分
    public int arrangeCoins1(int n) {
        int left = 0, right = n, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            long sum = getSum(mid);
            if (sum == n) {
                return mid;
            }
            if (sum > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private long getSum(long n) {
        return n * (n + 1) >> 1;
    }

    // 数学 1/2 * x * (x + 1) = n -> x * x + x - 2n = 0
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8 * (long) n) - 1) / 2);
    }
}