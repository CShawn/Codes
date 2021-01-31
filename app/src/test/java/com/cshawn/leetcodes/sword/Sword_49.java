package com.cshawn.leetcodes.sword;

/**
 * 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:1是丑数。 n不超过1690。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/31 1:57 下午
 */
public class Sword_49 {
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        // 定义三个索引，用以分别乘以2/3/5刚好大于当前最后一个丑数
        int a = 0, b = 0, c = 0;
        int n2, n3, n5;
        for (int i = 1; i < n; i++) {
            // 分别乘以因子
            n2 = dp[a] * 2;
            n3 = dp[b] * 3;
            n5 = dp[c] * 5;
            // 计算大于最后一个丑数的最小值
            dp[i] = Math.min(n2, Math.min(n3, n5));
            // 与当前丑数匹配则累加索引
            if (n2 == dp[i]) a++;
            if (n3 == dp[i]) b++;
            if (n5 == dp[i]) c++;
        }
        return dp[n - 1];
    }
}
