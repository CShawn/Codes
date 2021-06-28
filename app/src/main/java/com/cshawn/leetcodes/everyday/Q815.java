package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 * 示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 *
 * 示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *
 * 提示：
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/28 4:23 下午
 */
public class Q815 {
    // 广度优先遍历
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        // 存储站点对应的车次<站点, 经过此站点的车次列表>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> list = map.get(routes[i][j]);
                if (list == null) {
                    list = new LinkedList<>();
                    list.add(i);
                    map.put(routes[i][j], list);
                } else {
                    list.add(i);
                }
            }
        }
        if (!map.containsKey(source) || !map.containsKey(target)) {
            return -1;
        }
        // 存储车次
        Queue<Integer> queue = new LinkedList<>();
        // 存储已遍历过的站点
        Set<Integer> checkedStop = new HashSet<>();
        checkedStop.add(source);
        // 存储已遍历过的车次
        Set<Integer> checkedBus = new HashSet<>();
        for (Integer route : map.get(source)) {
            queue.offer(route);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int r = queue.poll();
                if (!checkedBus.contains(r)) {
                    for (int stop : routes[r]) {
                        if (!checkedStop.contains(stop)) {
                            if (target == stop) {
                                return result;
                            }
                            checkedStop.add(stop);
                            for (Integer route : map.get(stop)) {
                                queue.offer(route);
                            }
                        }
                    }
                    checkedBus.add(r);
                }
            }
        }
        return -1;
    }
}
