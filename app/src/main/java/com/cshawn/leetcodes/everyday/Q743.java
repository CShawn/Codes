package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，
 * 其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 * 示例 1：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 *
 * 示例 3：
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 * 提示：
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/2 3:42 下午
 */
public class Q743 {
    // 方法1：Dijkstra算法
    public int networkDelayTime1(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE >> 1;
        int[][] u = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(u[i], INF);
        }
        for (int[] t : times) {
            u[t[0] - 1][t[1] - 1] = t[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] s = new boolean[n];
        for (int i = 0; i < n; ++i) {
            // 查找当前结点距离最近的结点minLen
            int minLen = -1;
            for (int j = 0; j < dist.length; ++j) {
                if (!s[j] && (minLen == -1 || dist[j] < dist[minLen])) {
                    minLen = j;
                }
            }
            // 确定最近的结点
            s[minLen] = true;
            // 更新minLen结点可到达的结点的最小距离
            for (int j = 0; j < dist.length; ++j) {
                // dist[minLen]为当前结点到minLen结点的距离；
                // u[minLen][j]为minLen结点到j结点的距离
                dist[j] = Math.min(dist[j], dist[minLen] + u[minLen][j]);
            }
        }
        int max = -1;
        for (int d : dist) {
            max = Math.max(max, d);
        }
        return max == INF ? -1 : max;
    }

    // 方法1：Dijkstra算法 + 最小堆
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE >> 1;
        int[][] u = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(u[i], INF);
        }
        for (int[] t : times) {
            u[t[0] - 1][t[1] - 1] = t[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] s = new boolean[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            // 查找当前结点距离最近的结点minLen
            int minLen = -1;
            for (int j = 0; j < dist.length; ++j) {
                if (!s[j] && (minLen == -1 || dist[j] < dist[minLen])) {
                    minLen = j;
                }
            }
            // 确定最近的结点
            s[minLen] = true;
            // 更新minLen结点可到达的结点的最小距离
            for (int j = 0; j < dist.length; ++j) {
                // dist[minLen]为当前结点到minLen结点的距离；
                // u[minLen][j]为minLen结点到j结点的距离
                dist[j] = Math.min(dist[j], dist[minLen] + u[minLen][j]);
            }
        }
        int max = -1;
        for (int d : dist) {
            max = Math.max(max, d);
        }
        return max == INF ? -1 : max;
    }
}
