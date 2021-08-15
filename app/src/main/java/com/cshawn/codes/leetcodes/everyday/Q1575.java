package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 统计所有可行路径
 * 给你一个 互不相同的整数数组，其中locations[i]表示第i个城市的位置。同时给你start，finish和fuel分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * 每一步中，如果你在城市 i，你可以选择任意一个城市 j，满足 j != i且0 <= j < locations.length，并移动到城市j。
 * 从城市i移动到j消耗的汽油量为|locations[i] - locations[j]|，|x|表示x的绝对值。
 * 请注意，fuel任何时刻都不能为负，且你可以经过任意城市超过一次（包括start和finish）。
 * 请你返回从start到finish所有可能路径的数目。
 * 由于答案可能很大， 请将它对10^9 + 7取余后返回。
 *
 * 示例 1：
 * 输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * 输出：4
 * 解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
 * 1 -> 3
 * 1 -> 2 -> 3
 * 1 -> 4 -> 3
 * 1 -> 4 -> 2 -> 3
 *
 * 示例 2：
 * 输入：locations = [4,3,1], start = 1, finish = 0, fuel = 6
 * 输出：5
 * 解释：以下为所有可能的路径：
 * 1 -> 0，使用汽油量为 fuel = 1
 * 1 -> 2 -> 0，使用汽油量为 fuel = 5
 * 1 -> 2 -> 1 -> 0，使用汽油量为 fuel = 5
 * 1 -> 0 -> 1 -> 0，使用汽油量为 fuel = 3
 * 1 -> 0 -> 1 -> 0 -> 1 -> 0，使用汽油量为 fuel = 5
 *
 * 示例 3：
 * 输入：locations = [5,2,1], start = 0, finish = 2, fuel = 3
 * 输出：0
 * 解释：没有办法只用 3 单位的汽油从 0 到达 2 。因为最短路径需要 4 单位的汽油。
 *
 * 示例 4 ：
 * 输入：locations = [2,1,5], start = 0, finish = 0, fuel = 3
 * 输出：2
 * 解释：总共有两条可行路径，0 和 0 -> 1 -> 0 。
 *
 * 示例 5：
 * 输入：locations = [1,2,3], start = 0, finish = 2, fuel = 40
 * 输出：615088286
 * 解释：路径总数为 2615088300 。将结果对 10^9 + 7 取余，得到 615088286 。
 *
 * 提示：
 * 2 <= locations.length <= 100
 * 1 <= locations[i] <= 10^9
 * 所有locations中的整数 互不相同。
 * 0 <= start, finish <locations.length
 * 1 <= fuel <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-all-possible-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/30 4:38 下午
 */
public class Q1575 {
    // 方法1：记忆化搜索
    public int countRoutes1(int[] locations, int start, int finish, int fuel) {
        // memo[i][j]表示从i点油量为j，可到达finish的路径数
        int[][] memo = new int[locations.length][fuel + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dfs(memo, locations, start, finish, fuel);
    }

    private int dfs(int[][] memo, int[] locations, int start, int finish, int fuel) {
        if (memo[start][fuel] != -1) {
            return memo[start][fuel];
        }
        if (fuel < Math.abs(locations[start] - locations[finish])) {
            memo[start][fuel] = 0;
            return 0;
        }
        int sum = start == finish ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                int need = Math.abs(locations[start] - locations[i]);
                if (fuel >= need) {
                    sum = (sum + dfs(memo, locations, i, finish, fuel - need)) % 1000000007;
                }
            }
        }
        memo[start][fuel] = sum;
        return sum;
    }

    // 方法2：动态规划
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        // dp[i][j]表示从i点油量为j，可到达finish的路径数
        int[][] dp = new int[locations.length][fuel + 1];
        // 从finish到finish路径为1
        Arrays.fill(dp[finish], 1);
        // dp[i][j] += dp[k][j - need]，所以在计算j时，j-need需要确定出来，
        // 因此需要纵向遍历矩阵，先遍历j，得出每个dp[x][jPre]
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < dp.length; i++) {
                for (int k = 0; k < locations.length; k++) {
                    if (k != i) {
                        int need = Math.abs(locations[k] - locations[i]);
                        if (need <= j) {
                            dp[i][j] = (dp[i][j] + dp[k][j - need]) % 1000000007;
                        }
                    }
                }
            }
        }
        return dp[start][fuel];
    }
}