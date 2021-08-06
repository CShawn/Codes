package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 访问所有节点的最短路径
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 * 示例 1：
 * 输入：graph = [[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一种可能的路径为 [1,0,2,0,3]
 *
 * 示例 2：
 * 输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一种可能的路径为 [0,1,4,2,3]
 *
 * 提示：
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length <n
 * graph[i] 不包含 i
 * 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
 * 输入的图总是连通图
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/6 4:50 下午
 */
public class Q847 {
    // 方法1：BFS
    public int shortestPathLength1(int[][] graph) {
        int end = (1 << graph.length) - 1;
        // 队列中存储[当前结点，已到达的结点列表mask, 已走的步数]
        Queue<int[]> queue = new ArrayDeque<>();
        // 结点最多12个，可将结点值与mask组成一个int值
        int N = 12;
        // 存储已遍历过的结点信息：遍历到某结点及遍历过的结点mask，组成一个int，
        // int:低12位为mask,高位为结点值
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            visited.add((i << N) | (1 << i));
        }
        // BFS搜索，一层一层搜索，有一次到达全部结点，则为最短路径，可以结束遍历
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cur = node[0];
            int mask = node[1];
            int sum = node[2];
            if (mask == end) {
                return sum;
            }
            for (int next : graph[cur]) {
                int maskNext = mask | (1 << next);
                int nextVisit = (next << N) | maskNext;
                if (!visited.contains(nextVisit)) {
                    queue.offer(new int[]{next, maskNext, sum + 1});
                    visited.add(nextVisit);
                }
            }
        }
        return 0;
    }

    // 方法2：Floyd + 动态规划
    public int shortestPathLength(int[][] graph) {
        if (graph.length <= 1) {
            return 0;
        }
        int end = (1 << graph.length) - 1;
        // 预处理每个结点相互之间的最短路径，routes[i][j]表示结点i到结点j的最短路径
        int[][] routes = new int[graph.length][graph.length];
        // dp[i][j]表示到达结点i,且经过的结点列表mask为j的最短路径
        int[][] dp = new int[graph.length][1 << graph.length];
        int MAX = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(routes[i], MAX);
            Arrays.fill(dp[i], MAX);
            int mask = 1 << i;
            // 每个结点到自己的最短路径为0
            dp[i][mask] = 0;
            for (int j : graph[i]) {
                // 每个结点可直接到达的结点为路径为1
                routes[i][j] = 1;
                // 每个结点可直接到达的结点且经过当前结点的路径为1
                dp[j][mask] = 1;
            }
        }
        // Floyd算法得到各结点的最短路径
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
                }
            }
        }
        for (int mask = 1; mask <= end; mask++) {
            // mask只有1个1时，可能为当前结点的初始状态，dp[i][mask]=0;
            if (Integer.bitCount(mask) != 1) {
                for (int i = 0; i < graph.length; i++) {
                    // mask含i,为有效的mask
                    if ((mask & (1 << i)) != 0) {
                        for (int j = 0; j < graph.length; j++) {
                            // mask含j，为有效的mask，且在i!=j时才计算
                            if (i != j && (mask & (1 << j)) != 0) {
                                // dp[i][mask]为dp[j][mask未经过i时的值]+从j到i的最短路径
                                dp[i][mask] = Math.min(dp[i][mask], dp[j][mask ^ (1 << i)] + routes[j][i]);
                            }
                        }
                    }
                }
            }
        }
        int result = MAX;
        for (int i = 0; i < graph.length; i++) {
            // 最终结果为所有dp[i][end]的最小值
            result = Math.min(result, dp[i][end]);
        }
        return result;
    }
}