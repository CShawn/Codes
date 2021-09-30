package com.cshawn.codes.leetcodes.everyday;

/**
 * 矩形面积
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 * 示例 1：
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 *
 * 示例 2：
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *
 * 提示：-104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/30 9:34 上午
 */
public class Q223 {
    public int computeArea1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int sum = area1 + area2;
        int joinX1 = Math.max(ax1, bx1);
        if (joinX1 >= ax2 || joinX1 >= bx2) {
            return sum;
        }
        int joinX2 = Math.min(ax2, bx2);
        int joinY1 = Math.max(ay1, by1);
        if (joinY1 >= ay2 || joinY1 >= by2) {
            return sum;
        }
        int joinY2 = Math.min(ay2, by2);
        return sum - (joinX2 - joinX1) * (joinY2 - joinY1);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sum = (ax2 - ax1) * (ay2 - ay1);
        sum += (bx2 - bx1) * (by2 - by1);
        if (ax1 >= bx2 || bx1 >= ax2 || ay1 >= by2 || by1 >= ay2) {
            return sum;
        }
        int joinX1 = Math.max(ax1, bx1);
        int joinX2 = Math.min(ax2, bx2);
        int joinY1 = Math.max(ay1, by1);
        int joinY2 = Math.min(ay2, by2);
        return sum - (joinX2 - joinX1) * (joinY2 - joinY1);
    }
}
