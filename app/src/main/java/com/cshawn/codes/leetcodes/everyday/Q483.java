package com.cshawn.codes.leetcodes.everyday;

/**
 * 最小好进制
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称k（k>=2）是 n 的一个好进制。
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 *
 * 示例 1：
 * 输入："13"
 * 输出："3"
 * 解释：13 的 3 进制是 111。
 *
 * 示例 2：
 * 输入："4681"
 * 输出："8"
 * 解释：4681 的 8 进制是 11111。
 *
 * 示例 3：
 * 输入："1000000000000000000"
 * 输出："999999999999999999"
 * 解释：1000000000000000000 的 999999999999999999 进制是 11。
 *
 * 提示：
 * n的取值范围是[3, 10^18]。
 * 输入总是有效且没有前导 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-good-base
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/18 8:58 下午
 */
public class Q483 {
    // 方法1：二分法
    // n=k^0 + k^1 + ... + k^(m-1)
    // kn = k^1 + k^2 +...+ k^m
    // (k-1)n=k^m - 1
    public String smallestGoodBase1(String n) {
        // 最多的1个数为二进制表示的1的个数，最少为2个(题意k>=2)
        long num = Long.parseLong(n);
        int max = 64 - Long.numberOfLeadingZeros(num);
        // 进制
        for (int i = max; i > 2; i--) {
            long left = 2, right = num - 1, scale;
            while (left <= right) {
                scale = left + ((right - left) >> 1);
                long maxValue = num / scale + 1, sum = 0;
                for (int j = 0; j < i; j++) {
                    if (sum < maxValue) {
                        sum = sum * scale + 1;
                    } else {
                        sum = num + 1;
                        break;
                    }
                }
                if (sum == num) {
                    return Long.toString(scale);
                } else if (sum > num) {
                    right = scale - 1;
                } else {
                    left = scale + 1;
                }
            }
        }
        return Long.toString(num - 1);
    }

    // 方法2：数学
    // k = m√n
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int max = 63 - Long.numberOfLeadingZeros(num);
        for (int m = max; m > 1; m--) {
            // k = n ^ (1/m)
            int k = (int) Math.pow(num, 1.0 / m);
            long sum = 0;
            for (int i = 0; i <= m; i++) {
                sum = sum * k + 1;
            }
            if (sum == num) {
                return Integer.toString(k);
            }
        }
        return Long.toString(num - 1);
    }
}
