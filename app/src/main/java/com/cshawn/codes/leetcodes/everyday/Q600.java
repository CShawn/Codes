package com.cshawn.codes.leetcodes.everyday;

/**
 * 不含连续1的非负整数
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 *
 * 示例 1:
 * 输入: 5
 * 输出: 5
 * 解释: 
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 * 说明: 1 <= n <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/11 10:23 上午
 */
public class Q600 {
    public int findIntegers(int n) {
        int bits = 32 - Integer.numberOfLeadingZeros(n);
        int[] dp = new int[bits + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0, result = 0;
        for (int i = bits - 1; i >= 0; i--) {
            int val = 1 << i;
            if ((n & val) != 0) {
                result += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            if (i == 0) {
                result++;
            }
        }
        return result;
    }
}