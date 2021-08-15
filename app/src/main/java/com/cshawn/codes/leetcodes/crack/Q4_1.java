package com.cshawn.codes.leetcodes.crack;

import java.util.*;

/**
 * 节点间通路
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 *
 * 示例2:
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/1 9:43 下午
 */
public class Q4_1 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 邻接表转为哈希链表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : graph) {
            if (!map.containsKey(ints[0])) {
                map.put(ints[0], new LinkedList<>());
            }
            map.get(ints[0]).add(ints[1]);
        }
        // 存储已访问过的节点，避免出现环
        boolean[] visited = new boolean[n];
        return bfs(map, visited, start, target);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int start, int target) {
        if (visited[start]) {
            return false;
        }
        visited[start] = true;
        if (!map.containsKey(start)) {
            return false;
        }
        List<Integer> list = map.get(start);
        if (list == null) {
            return false;
        }
        for (Integer value : list) {
            if (value == target || dfs(map, visited, value, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean bfs(Map<Integer, List<Integer>> map, boolean[] visited, int start, int target) {
        if (visited[start]) {
            return false;
        }
        visited[start] = true;
        if (!map.containsKey(start)) {
            return false;
        }
        List<Integer> list = map.get(start);
        if (list == null) {
            return false;
        }
        for (Integer value : list) {
            if (value == target) {
                return true;
            }
        }
        for (Integer value : list) {
            if (bfs(map, visited, value, target)) {
                return true;
            }
        }
        return false;
    }
}
