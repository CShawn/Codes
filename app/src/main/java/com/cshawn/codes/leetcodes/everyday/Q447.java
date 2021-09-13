package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 *
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 *
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 *
 * 提示：
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/13 11:24 上午
 */
public class Q447 {
    public int numberOfBoomerangs1(int[][] points) {
        int[][] memo = new int[points.length][points.length];
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            map.put(0, map.getOrDefault(0, 0) + 1);
            for (int j = 0; j < i; j++) {
                memo[i][j] = memo[j][i];
                map.put(memo[i][j], map.getOrDefault(memo[i][j], 0) + 1);
            }
            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[i][0] - points[j][0];
                int diffY = points[i][1] - points[j][1];
                memo[i][j] = diffX * diffX + diffY * diffY;
                map.put(memo[i][j], map.getOrDefault(memo[i][j], 0) + 1);
            }
            for (int value : map.values()) {
                result += value * (value - 1);
            }
        }
        return result;
    }

    public int numberOfBoomerangs(int[][] points) {
        int[][] memo = new int[points.length][points.length];
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < i; j++) {
                memo[i][j] = memo[j][i];
                int origin = map.getOrDefault(memo[i][j], 0);
                result += origin << 1;
                map.put(memo[i][j], origin + 1);
            }
            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[i][0] - points[j][0];
                int diffY = points[i][1] - points[j][1];
                memo[i][j] = diffX * diffX + diffY * diffY;
                int origin = map.getOrDefault(memo[i][j], 0);
                result += origin << 1;
                map.put(memo[i][j], origin + 1);
            }
        }
        return result;
    }
}
