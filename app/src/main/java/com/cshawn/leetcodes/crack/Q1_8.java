package com.cshawn.leetcodes.crack;

import java.util.*;

/**
 * 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/24 5:54 下午
 */
public class Q1_8 {
    public int[][] setZeroes1(int[][] matrix) {
        // 记录当前行是否需要全部改为0
        boolean rowZero = false;
        // 存储需要改为0的行
        Set<Integer> rows = new HashSet<>();
        // 存储需要改为0的列
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // 当前行需要改为0
                    rowZero = true;
                    // 将当前行此列之前的列都赋值为0
                    for (int col = 0; col < j; col++) {
                        matrix[i][col] = 0;
                    }
                    // 记录需要改为0的列
                    cols.add(j);
                } else if (rowZero) {
                    // 如果当前行需要改为0，遍历时即可改为0
                    matrix[i][j] = 0;
                }
            }
            // 将未改为0的行记录下来，后续将列改为0
            if (!rowZero) {
                rows.add(i);
            }
            // 恢复状态
            rowZero = false;
        }
        // 遍历需要改为0的行列
        for (int i : rows) {
            for (int j : cols) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    // 遍历为0的行列，最后再修改0
    public int[][] setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
