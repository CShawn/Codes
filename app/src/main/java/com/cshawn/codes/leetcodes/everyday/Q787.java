package com.cshawn.codes.leetcodes.everyday;

import java.util.*;

/**
 * K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。
 * 如果不存在这样的路线，则输出 -1。
 *
 * 示例 1：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 *
 * 示例 2：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 *
 * 提示：
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/24 8:43 上午
 */
public class Q787 {
    private int result = Integer.MAX_VALUE;
    // 方法1：DFS，最慢方法
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            List<int[]> list = map.computeIfAbsent(flight[0], k1 -> new ArrayList<>());
            list.add(new int[]{flight[1], flight[2]});
        }
        Set<String> visited = new HashSet<>();
        find(map, visited, dst, k, src,  0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void find(Map<Integer, List<int[]>> map, Set<String> visited, int dst, int k, int src, int cost) {
        if (k < 0 || cost > result) {
            return;
        }
        List<int[]> list = map.get(src);
        if (list != null) {
            for (int[] flight : list) {
                int total = cost + flight[1];
                // 已访问的节点:"当前要访问的节点,当前的总花费"
                String v = flight[0] + "," + total;
                if (total <= result && !visited.contains(v)) {
                    visited.add(v);
                    if (flight[0] == dst) {
                        result = Math.min(result, total);
                    } else {
                        find(map, visited, dst, k - 1, flight[0], total);
                    }
                }
            }
        }
    }

    // 方法2：BFS，比DFS更合理
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] map = new List[n];
        for (int[] flight : flights) {
            List<int[]> list = map[flight[0]];
            if (list == null) {
                list = new ArrayList<>();
                map[flight[0]] = list;
            }
            list.add(new int[]{flight[1], flight[2]});
        }
        // [当前节点，到达当前节点的花费]
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        // 记录到达第i个节点的最小花费
        int[] minValues = new int[n];
        Arrays.fill(minValues, Integer.MAX_VALUE);
        minValues[src] = 0;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k-- < 0) {
                break;
            }
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                List<int[]> list = map[arr[0]];
                if (list != null) {
                    for (int[] flight : list) {
                        int total = arr[1] + flight[1];
                        if (flight[0] == dst) {
                            result = Math.min(result, total);
                        } else if (total < minValues[flight[0]] && total < result) {
                            minValues[flight[0]] = total;
                            queue.add(new int[]{flight[0], total});
                        }
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    // 方法3：动态规划
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        int INF = 1000_0000;
        // dp[i][j]表示中转k次即乘坐k+1次恰到达j的最小花费
        int[][] dp = new int[k + 2][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }
        dp[0][src] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int[] flight : flights) {
                int t = flight[0], j = flight[1], cost = flight[2];
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][t] + cost);
            }
        }
        int result = INF;
        for (int i = 1; i < dp.length; i++) {
            result = Math.min(result, dp[i][dst]);
        }
        return result == INF ? -1 : result;
    }

    // 方法4：优化方法3空间
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 1000_0000;
        // dp[i][j]表示中转k次即乘坐k+1次恰到达j的最小花费
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], INF);
        dp[0][src] = 0;
        int result = INF;
        for (int i = 1; i < k + 2; i++) {
            int index = i & 1, pre = index ^ 1;
            Arrays.fill(dp[index], INF);
            for (int[] flight : flights) {
                int t = flight[0], j = flight[1], cost = flight[2];
                dp[index][j] = Math.min(dp[index][j], dp[pre][t] + cost);
            }
            result = Math.min(result, dp[index][dst]);
        }
        return result == INF ? -1 : result;
    }
}
