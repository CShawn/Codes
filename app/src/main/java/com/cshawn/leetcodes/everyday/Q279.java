package com.cshawn.leetcodes.everyday;

import java.util.Arrays;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 提示：1 <= n <= 104
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/11 9:05 下午
 */
public class Q279 {
    // 方法1：动态规划，同Q322
    public int numSquares1(int n) {
        int[] squares = new int[(int) Math.sqrt(n)];
        for (int i = 1; i <= squares.length; i++) {
            squares[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < squares.length && i >= squares[j]; j++) {
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }
        return dp[n];
    }

    // 方法2：数学
    // 四平方和定理: 任意一个正整数都可以被表示为至多四个正整数的平方和
    // 当 n = 4^k * (8m+7)时，n 可以被表示为至多三个正整数的平方和
    // 答案为4时，则n != 4^k * (8m+7)
    // 答案为 1 时，则必有 n 为完全平方数，这很好判断；
    // 答案为 2 时，则有 n=a^2+b^2 只需要枚举所有的n判断 n-a^2是否为完全平方数即可；
    // 答案为 3 时，我们很难在一个优秀的时间复杂度内解决它，但我们只需要检查答案为 1 或 2 的两种情况，即可利用排除法确定答案。
    public int numSquares(int n) {
        // 判断是否为平方数
        double sqrt = Math.sqrt(n);
        if (sqrt == (int) sqrt) {
            return 1;
        }
        // 检测 4^k * (8m+7)
        int x = n;
        while (x % 4 == 0) {
            x = x / 4;
        }
        if (x % 8 == 7) {
            return 4;
        }
        // 检测a^2+b^2
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            double sqrt2 = Math.sqrt(j);
            if (sqrt2 == (int) sqrt2) {
                return 2;
            }
        }
        return 3;
    }
}