package com.cshawn.codes.acwing;

/**
 * 01背包问题
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 * 第 i 件物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * 输入样例
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 5
 * 输出样例：
 * 8
 * @author C.Shawn
 * @date 2021/8/28 12:08 下午
 */
public class Q2 {
    public int pack01_1(int N, int V, int[] v, int[] w) {
        // dp[i][j]表示前i个物品，使用容量为j时的最大价值
        int[][] dp = new int[N][V + 1];
        // 先赋值第0个物品的最大价值，容量可以装下此物品时，价值为v[0]
        for (int j = v[0]; j <= V; j++) {
            dp[0][j] = w[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (v[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N - 1][V];
    }

    // 滚动数组
    public int pack01_2(int N, int V, int[] v, int[] w) {
        // dp[i][j]表示前i个物品，使用容量为j时的最大价值
        int[][] dp = new int[2][V + 1];
        // 使用滚动数组时，index为0时，pre为1,元素都是0，第一次遍历会为dp[0][j]赋值
        // 因此去掉dp[0][j]的单独赋值，i从0开始
        for (int i = 0; i < N; i++) {
            int index = i & 1, pre = index ^ 1;
            for (int j = 0; j <= V; j++) {
                dp[index][j] = dp[pre][j];
                if (v[i] <= j) {
                    dp[index][j] = Math.max(dp[index][j], dp[pre][j - v[i]] + w[i]);
                }
            }
        }
        return dp[(N & 1) ^ 1][V];
    }

    // 倒序优化一维
    public int pack01_3(int N, int V, int[] v, int[] w) {
        // dp[i][j]表示前i个物品，使用容量为j时的最大价值
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                if (v[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            }
        }
        return dp[V];
    }

    // 继续优化
    public int pack01(int N, int V, int[] v, int[] w) {
        // dp[i][j]表示前i个物品，使用容量为j时的最大价值
        int[] dp = new int[V + 1];
        // 第0个物品可放入for循环中
        for (int i = 0; i < N; i++) {
            // 将v[i]<=j与for条件合并
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}