package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到endi的闭区间。
 * 如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，那么我们称整数x被覆盖了。
 *
 * 示例 1：
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 *
 * 示例 2：
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *
 * 提示：
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/23 7:07 下午
 */
public class Q1893 {
    // 方法1：遍历所有range内的点
    public boolean isCovered1(int[][] ranges, int left, int right) {
        boolean[] arr = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                arr[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!arr[i]) {
                return false;
            }
        }
        return true;
    }

    // 方法2：排序，移动left
    public boolean isCovered2(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int[] range : ranges) {
            if (range[0] <= left && range[1] >= left) {
                left = range[1] + 1;
                if (left > right) {
                    return true;
                }
            }
        }
        return false;
    }

    // 方法3：在方法1基础上，只遍历[left,right]内的点
    public boolean isCovered3(int[][] ranges, int left, int right) {
        boolean[] arr = new boolean[51];
        for (int[] range : ranges) {
            int l = Math.max(range[0], left);
            int r = Math.min(range[1], right);
            for (int i = l; i <= r; i++) {
                arr[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!arr[i]) {
                return false;
            }
        }
        return true;
    }

    // 方法4：差分数组
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        // 前缀和
        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            sum += diff[i];
            if (i >= left && i <= right && sum <= 0) {
                return false;
            }
        }
        return true;
    }
}