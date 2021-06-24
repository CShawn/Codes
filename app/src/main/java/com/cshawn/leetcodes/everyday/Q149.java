package com.cshawn.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 * 示例 1：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 *
 * 示例 2：
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * 提示：
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/24 5:06 下午
 */
public class Q149 {
    // 遍历所有连线，统计斜率相同的最多点数
    // 连线数为N*(N-1)/2,最后对比一次求最大值
    public int maxPoints(int[][] points) {
        int max = (points.length + 1) >> 1;
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            // 存储<斜率, 个数>，斜率为"x:y"形式的字符串，其中x,y为约分后的数字，保证斜率一致
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int xDiff = points[j][0] - points[i][0];
                int yDiff = points[j][1] - points[i][1];
                String slope;
                if (yDiff == 0) {
                    slope = "0";
                } else if (xDiff == 0) {
                    slope = "x";
                } else {
                    int k = gcd(xDiff, yDiff);
                    slope = Math.abs(xDiff / k) + ":" + Math.abs(yDiff / k);
                    if ((xDiff ^ yDiff) < 0) {
                        slope = "-" + slope;
                    }
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                result = Math.max(result, entry.getValue());
            }
            if (result >= max) {
                return result + 1;
            }
        }
        return result + 1;
    }

    /**
     * 求最大公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
