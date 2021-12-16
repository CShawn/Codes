package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 可见点的最大数目
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 * 对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
 * 同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
 * 返回你能看到的点的最大数目。
 *
 * 示例 1：
 * 输入：points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
 * 输出：3
 * 解释：阴影区域代表你的视野。在你的视野中，所有的点都清晰可见，尽管 [2,2] 和 [3,3]在同一条直线上，你仍然可以看到 [3,3] 。
 *
 * 示例 2：
 * 输入：points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
 * 输出：4
 * 解释：在你的视野中，所有的点都清晰可见，包括你所在位置的那个点。
 *
 * 示例 3：
 * 输入：points = [[1,0],[2,1]], angle = 13, location = [1,1]
 * 输出：1
 * 解释：如图所示，你只能看到两点之一。
 *
 * 提示：
 * 1 <= points.length <= 105
 * points[i].length == 2
 * location.length == 2
 * 0 <= angle < 360
 * 0 <= posx, posy, xi, yi <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-visible-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/16 8:30 上午
 */
public class Q1610 {
    // 象限及tan排序 + 滑动窗口
    // 思路对着，写的太冗长了
    public int visiblePoints1(List<List<Integer>> points, int angle, List<Integer> location) {
        int originX = location.get(0);
        int originY = location.get(1);
        points.sort((o1, o2) -> {
            // 求象限
            int quadrant1 = getQuadrant(o1, originX, originY);
            int quadrant2 = getQuadrant(o2, originX, originY);
            if (quadrant1 != quadrant2) {
                return quadrant1 - quadrant2;
            }
            int x1 = o1.get(0) - originX;
            int x2 = o2.get(0) - originX;
            int y1 = o1.get(1) - originY;
            int y2 = o2.get(1) - originY;
            // 相同点或x为0，则tan相等
            if (x1 == x2 && (y1 == y2 || x1 == 0)) {
                return 0;
            }
            if (x1 != 0 && x2 != 0) {
                // 比较tan值的大小，根据象限确定两者排序关系
                return y1 * x2 - x1 * y2;
            }
            // x为0归入2,4象限，x为0的tan值为最小值
            if (x1 == 0) {
                return -1;
            } else {
                return 1;
            }
        });
        int origin = 0;
        for (int i = 0; i < points.size() && points.get(i).get(3) == 0 && points.get(i).get(4) == 0; i++) {
            origin++;
        }
        if (origin == points.size()) {
            return origin;
        }
        int result = 0;
        int left = origin, right = origin;
        double angleRadians = Math.toRadians(angle);
        double end = getRadians(points.get(left)) + angleRadians;
        int temp = 0;
        int size = points.size();
        while (right < size) {
            double cur = getRadians(points.get(right));
            if (cur <= end) {
                right++;
                temp++;
                result = Math.max(result, temp);
            } else {
                left++;
                end = getRadians(points.get(left)) + angleRadians;
                temp--;
            }
        }
        // 右侧到达2π后，为使左侧向右滑时判断正确，在points后拷贝一份+2π的角度
        for (int i = origin; i < size; i++) {
            points.add(points.get(i));
        }
        while (left < size) {
            double cur = getRadians(points.get(right)) + 2 * Math.PI;
            if (cur <= end) {
                right++;
                temp++;
                result = Math.max(result, temp);
            } else {
                left++;
                end = getRadians(points.get(left)) + angleRadians;
                temp--;
            }
        }
        return result + origin;
    }

    private double getRadians(List<Integer> point) {
        double radians;
        if (point.get(3) == 0) {
            radians = point.get(2) == 2 ? Math.toRadians(90) : Math.toRadians(270);
        } else {
            radians = Math.atan(point.get(4) / (double) point.get(3));
            if (point.get(2) != 1) {
                radians += Math.PI;
            }
            if (point.get(2) == 4) {
                radians += Math.PI;
            }
        }
        return radians;
    }

    private int getQuadrant(List<Integer> point, int originX, int originY) {
        if (point.size() > 2) {
            return point.get(2);
        }
        int quadrant;
        int x = point.get(0) - originX;
        int y = point.get(1) - originY;
        if (x == 0 && y == 0) {
            // 原点划为第0象限，排序时放到最前边，直接跳过
            quadrant = 0;
        } else if (x > 0 && y >= 0) {
            quadrant = 1;
        } else if (x <= 0 && y > 0) {
            quadrant = 2;
        } else if (x < 0) {
            quadrant = 3;
        } else {
            quadrant = 4;
        }
        point.add(quadrant);
        point.add(x);
        point.add(y);
        return quadrant;
    }

    // arctan 角度排序 + 滑动窗口
    public int visiblePoints2(List<List<Integer>> points, int angle, List<Integer> location) {
        int originX = location.get(0);
        int originY = location.get(1);
        // 反正切角度范围为[-π,π]
        List<Double> degrees = new ArrayList<>();
        int origin = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x == originX && y == originY) {
                origin++;
            } else {
                degrees.add(Math.atan2(y - originY, x - originX));
            }
        }
        if (degrees.isEmpty()) {
            return origin;
        }
        Collections.sort(degrees);
        int size = degrees.size();
        for (int i = 0; i < size; i++) {
            degrees.add(degrees.get(i) + 2 * Math.PI);
        }
        int result = 0, right = 0;
        double angleRadians = Math.toRadians(angle);
        for (int left = 0; left < size; left++) {
            double end = degrees.get(left) + angleRadians;
            while (right < degrees.size() && degrees.get(right) <= end) {
                right++;
            }
            result = Math.max(result, right - left);
        }
        return result + origin;
    }

    // 优化方法2
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int originX = location.get(0);
        int originY = location.get(1);
        // 反正切角度范围为[-π,π]
        List<Double> degrees = new ArrayList<>();
        int origin = 0;
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (x == originX && y == originY) {
                origin++;
            } else {
                degrees.add(Math.atan2(y - originY, x - originX));
            }
        }
        if (degrees.isEmpty()) {
            return origin;
        }
        Collections.sort(degrees);
        int size = degrees.size();
        for (int i = 0; i < size; i++) {
            degrees.add(degrees.get(i) + 2 * Math.PI);
        }
        int left = 0, right = 0, temp = 0, result = 0;
        double angleRadians = Math.toRadians(angle);
        double end = degrees.get(left) + angleRadians;
        while (left < size) {
            if (degrees.get(right) <= end) {
                right++;
                temp++;
                result = Math.max(result, temp);
            } else {
                left++;
                temp--;
                end = degrees.get(left) + angleRadians;
            }
        }
        return result + origin;
    }
}