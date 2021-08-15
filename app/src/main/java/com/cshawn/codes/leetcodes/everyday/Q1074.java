package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 * 示例 1：
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 *
 * 示例 2：
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 *
 * 示例 3：
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 *
 * 提示：
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/29 9:48 上午
 */
public class Q1074 {
    // 二维前缀和，遍历后时间复杂度为：O(m^2 * n^2),m=n时，为O(n^4)，会超时
    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i + 1][j + 1] += sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 以sum[i][j]为右下角
                for (int m = 0; m <= i; m++) {
                    for (int n = 0; n <= j; n++) {
                        if (sum[i + 1][j + 1] - sum[i + 1][n] - sum[m][j + 1] + sum[m][n] == target) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    // 前缀和+哈希表
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i + 1][j + 1] += sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        // 遍历并固定上下边界，时间复杂度O(m^2*n)
        if (m <= n) {
            for (int top = 0; top < m; top++) {
                for (int bottom = top; bottom < m; bottom++) {
                    // 在当前范围内使用map快速查找目标值
                    map.clear();
                    int cur;
                    // 遍历并固定右边界
                    for (int right = 0; right < n; right++) {
                        // 以[top][0]~[bottom][right]为边界的子矩阵的和
                        cur = sum[bottom + 1][right + 1] - sum[top][right + 1];
                        if (cur == target) {
                            result++;
                        }
                        // 在map中查找值与target相加为cur，那么存在对应的target，累计次数
                        result += map.getOrDefault(cur - target, 0);
                        // 将当前cur累计次数放入map
                        map.put(cur, map.getOrDefault(cur, 0) + 1);
                    }
                }
            }
        } else {
            // 遍历并固定左右边界，时间复杂度O(m*n^2)
            for (int left = 0; left < n; left++) {
                for (int right = left; right < n; right++) {
                    // 在当前范围内使用map快速查找目标值
                    map.clear();
                    int cur;
                    // 遍历并固定下边界
                    for (int bottom = 0; bottom < m; bottom++) {
                        // 以[top][0]~[bottom][right]为边界的子矩阵的和
                        cur = sum[bottom + 1][right + 1] - sum[bottom + 1][left];
                        if (cur == target) {
                            result++;
                        }
                        // 在map中查找值与target相加为cur，那么存在对应的target，累计次数
                        result += map.getOrDefault(cur - target, 0);
                        // 将当前cur累计次数放入map
                        map.put(cur, map.getOrDefault(cur, 0) + 1);
                    }
                }
            }
        }
        return result;
    }
}