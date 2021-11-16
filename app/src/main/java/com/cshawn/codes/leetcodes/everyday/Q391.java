package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 完美矩形
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 *
 * 示例 2：
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 *
 * 示例 3：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
 * 输出：false
 * 解释：图形顶端留有空缺，无法覆盖成一个矩形。
 *
 * 示例 4：
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 *
 * 提示：
 * 1 <= rectangles.length <= 2 * 104
 * rectangles[i].length == 4
 * -105 <= xi, yi, ai, bi <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/16 8:18 上午
 */
public class Q391 {
    // 扫描线
    // 完美矩形满足：
    // 1. 边缘线是一条连续的不重叠的竖线
    // 2. 非边缘线成对出现，即存在两条完全相同的左右边重叠
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        // 存储所有竖边的下边点坐标x,y，上边点的y，此边是左边1还是右边-1
        int[][] lines = new int[n << 1][4];
        for (int i = 0, index = 0; i < n; i++) {
            int[] rect = rectangles[i];
            // 左边
            lines[index++] = new int[]{rect[0], rect[1], rect[3], 1};
            // 右边
            lines[index++] = new int[]{rect[2], rect[1], rect[3], -1};
        }
        Arrays.sort(lines, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        n <<= 1;
        // 存储相同x坐标的左边线段和右边线段
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        int l = 0, r;
        while (l < n) {
            r = l;
            left.clear();
            right.clear();
            // 找到所有x坐标相同的线段
            while (r < n && lines[r][0] == lines[l][0]) {
                // 当前线段的上下两点的y坐标
                int[] cur = new int[]{lines[r][1], lines[r][2]};
                List<int[]> list = lines[r][3] == 1 ? left : right;
                if (list.isEmpty()) {
                    list.add(cur);
                } else {
                    // 最靠上的一条线段
                    int[] pre = list.get(list.size() - 1);
                    if (cur[0] < pre[1]) {
                        // 相交
                        return false;
                    } else if (cur[0] == pre[1]) {
                        // 将两条线段连接起来
                        pre[1] = cur[1];
                    } else {
                        list.add(cur);
                    }
                }
                r++;
            }
            if (l > 0 && r < n) {
                // 不是边缘线，检查是否成对出现
                if (left.size() != right.size()) {
                    return false;
                }
                for (int i = 0; i < left.size(); i++) {
                    if (left.get(i)[0] != right.get(i)[0] || left.get(i)[1] != right.get(i)[1]) {
                        return false;
                    }
                }
            } else {
                // 是边缘线，检查是否形成完整一段
                if (left.size() + right.size() != 1) {
                    return false;
                }
            }
            l = r;
        }
        return true;
    }
}
