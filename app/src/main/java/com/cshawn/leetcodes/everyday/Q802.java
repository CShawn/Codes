package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 找到最终的安全状态
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 示例 1：
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * 
 * 示例 2：
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 *
 * 提示：
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] 按严格递增顺序排列。
 * 图中可能包含自环。
 * 图中边的数目在范围 [1, 4 * 104] 内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/5 10:43 上午
 */
public class Q802 {
    // 方法1: DFS
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Boolean[] memo = new Boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, i, memo, visited)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSafe(int[][] graph, int index, Boolean[] memo, boolean[] visited) {
        if (memo[index] != null) {
            return memo[index];
        }
        visited[index] = true;
        for (int i : graph[index]) {
            if (visited[i]) {
                return false;
            }
            memo[i] = isSafe(graph, i, memo, visited);
            if (!memo[i]) {
                return false;
            }
        }
        visited[index] = false;
        // 此时有两种情况：1.所有index的后继结点都是安全的;2.graph[index]为空
        return true;
    }

    // 方法2：DFS + 三色标记法
    // 实际上也是对方法1的空间优化
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        // 0为白色(未访问)，1为灰色(已访问)，2为黑色(安全)
        int[] colors = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, colors, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int[] colors, int index) {
        if (colors[index] != 0) {
            return colors[index] == 2;
        }
        colors[index] = 1;
        for (int i : graph[index]) {
            if (!dfs(graph, colors, i)) {
                return false;
            }
        }
        colors[index] = 2;
        return true;
    }

    // 方法3：拓朴排序
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 存储反向图
        List<Integer>[] reverse = new List[graph.length];
        // 存储反向图的入度，即原图的出度
        int[] ins = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // 构构反向图
        for (int i = 0; i < graph.length; i++) {
            ins[i] = graph[i].length;
            // 将入度为0的结点加入队列
            if (graph[i].length == 0) {
                queue.add(i);
            }
            for (int g : graph[i]) {
                List<Integer> list = reverse[g];
                if (list == null) {
                    list = new ArrayList<>();
                    reverse[g] = list;
                }
                list.add(i);
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (reverse[node] != null) {
                for (Integer next : reverse[node]) {
                    // 将结点的入度减1，为0则可以放入队列
                    if (--ins[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        // 统计入度为0的结点，可放入拓朴排序中，无环结点
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}