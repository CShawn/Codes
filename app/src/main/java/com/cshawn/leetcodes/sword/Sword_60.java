package com.cshawn.leetcodes.sword;

/**
 * n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * 限制：1 <= n <= 11
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/1/26 2:35 下午
 */
public class Sword_60 {
    // 动态规划
    public double[] dicesProbability(int n) {
        // 所有骰子点数和，从全1到全6
        double[] result = new double[5 * n + 1];
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = dicesProbability(n, i, dp);
        }
        return result;
    }
    // 求n个骰子点数总和为sum的概率
    private double dicesProbability(int n, int sum, double[][] dp) {
        // 一个骰子概率都为1/6
        double p = 1 / 6.0;
        if (n == 1) {
            return p;
        }
        if (dp[n][sum] != 0) {
            return dp[n][sum];
        }
        // 第一个骰子点数最小值为sum减去其余骰子全为6的值，当然不能小于1
        int begin = sum - (n - 1) * 6;
        if (begin <= 0) {
            begin = 1;
        }
        // 第一个骰子点数最大值为sum减去其余骰子全为1的值，当然不能大于6
        int end = sum - (n - 1);
        if (end > 6) {
            end = 6;
        }
        double probability = 0;
        for (int i = begin; i <= end; i++) {
            // 固定一个骰子的点数，其概率为1/6，求剩余骰子总和为sum - i的概率
            probability += p * dicesProbability(n - 1, sum - i, dp);
        }
        dp[n][sum] = probability;
        return probability;
    }
}
