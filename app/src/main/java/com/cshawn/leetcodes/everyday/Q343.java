package com.cshawn.leetcodes.everyday;

/**
 * 整数拆分
 * 给定一个正整数 *n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × *3 × *4 = 36。
 * 说明: 你可以假设 *n *不小于 2 且不大于 58。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/28 1:24 下午
 */
public class Q343 {
    // 动态规划
    public int integerBreak1(int n) {
        // dp[i]表示将i拆成至少两个正整数的和，并使这些整数的乘积最大化，
        // 需要遍历将i拆成j和i-j时最大的积，i-j可以不拆分也可以拆分
        // 则dp[i] = max(j*(i-j), j*dp[i-j])，最终结果为dp[n]
        int[] dp = new int[n + 1];
        // dp[0]=0,dp[1]=0
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    // 优化方法1
    // 对于任意 1<=j<i，有dp[i] >= j * dp[i-j]
    // 当 j 是奇数时，有 j=(j-1)/2 + (j+1)/2
    // 因此 dp[i]>=(j-1)/2 * dp[i -(j-1)/2] >= (j-1)/2 * (j+1)/2 * dp[i-j]
    // 当 j 是偶数时，有 j= j/2+ j/2
    // 因此 dp[i] >=  j/2  * dp[i - j/2] >= j/2 * j/2 * dp[i-j]
    // 如果 j >= 4 且 j 是奇数，则 (j-1)/2 * (j+1)/2 > j 恒成立。
    // 如果 j >= 4 且 j 是偶数，则  j/2 * j/2 >= j恒成立，当且仅当 j=4 时等号成立。
    // 由此可知，如果 j >= 4，则 dp[j] >= j，当且仅当 j=4 时等号成立
    // 只需要考虑 j=2和j=3 的情况
    public int integerBreak2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    Math.max(2 * (i - 2), 2 * dp[i - 2]),
                    Math.max(3 * (i - 3), 3 * dp[i - 3])
            );
        }
        return dp[n];
    }
    
    // 数学计算得出：将给定的正整数拆分成尽可能多的 3。
    // 当 n <= 3 时，最大乘积是 n-1
    // 当 n >=4 时，根据 n 除以 3 的余数进行分类讨论：
    // 如果余数为 0，即 n=3m(m >= 2)，则将 n 拆分成 m 个 3
    // 如果余数为 1，即 n=3m+1(m >= 1)，由于 2 * 2 > 3 * 1，因此将 n 拆分成 m-1 个 3 和 2 个 2
    // 如果余数为 2，即 n=3m+2(m >= 1)，则将 n 拆分成 m 个 3 和 1 个 2。
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int k = n / 3;
        int r = n % 3;
        if (r == 1) {
            return pow(3, k - 1) * 4;
        } else if (r == 2) {
            return pow(3, k) * 2;
        } else {
            return pow(3, k);
        }
    }

    private int pow(int n, int pow) {
        int result = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                result *= n;
            }
            n *= n;
            pow >>= 1;
        }
        return result;
    }
}
