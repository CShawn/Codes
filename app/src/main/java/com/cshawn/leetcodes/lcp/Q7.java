package com.cshawn.leetcodes.lcp;

import java.util.*;

/**
 * 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * 示例 2：
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * 输出：0
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * 限制：
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/1 8:40 上午
 */
public class Q7 {
    // 方法1：BFS
    public int numWays1(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] re : relation) {
            Set<Integer> set = map.computeIfAbsent(re[0], k1 -> new HashSet<>());
            set.add(re[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int depth = 0, result = 0;
        while (!queue.isEmpty()) {
            depth++;
            if (depth > k) {
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer item = queue.poll();
                Set<Integer> s = map.get(item);
                if (s != null) {
                    for (Integer next : s) {
                        if (depth == k && next == n - 1) {
                            result++;
                        }
                        queue.offer(next);
                    }
                }
            }
        }
        return result;
    }

    // 方法2：DFS
    public int numWays2(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] re : relation) {
            Set<Integer> set = map.computeIfAbsent(re[0], k1 -> new HashSet<>());
            set.add(re[1]);
        }
        return dfs(map, 0, n - 1, 0, k);
    }

    private int dfs(Map<Integer, Set<Integer>> map, int cur, int target, int depth, int k) {
        if (depth > k) {
            return 0;
        }
        if (depth == k && cur == target) {
            return 1;
        }
        int result = 0;
        Set<Integer> set = map.get(cur);
        if (set != null) {
            for (Integer next : set) {
                result += dfs(map, next, target, depth + 1, k);
            }
        }
        return result;
    }

    // 方法3：动态规划
    public int numWays3(int n, int[][] relation, int k) {
        // dp[i][j] 为经过 i 轮传递到编号 j 的玩家的方案数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] arr : relation) {
                int src = arr[0], dst = arr[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    // 方法4：动态规划优化空间
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            int index = i & 1;
            Arrays.fill(dp[index ^ 1], 0);
            for (int[] arr : relation) {
                int src = arr[0], dst = arr[1];
                dp[index ^ 1][dst] += dp[index][src];
            }
        }
        return dp[k & 1][n - 1];
    }
}