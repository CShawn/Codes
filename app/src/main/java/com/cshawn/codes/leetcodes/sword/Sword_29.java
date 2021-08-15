package com.cshawn.codes.leetcodes.sword;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],
 *                [4,5,6],
 *                [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix =  [[1, 2, 3, 4],
 *                 [5, 6, 7, 8],
 *                 [9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length  <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @Date 2020/12/13 22:11
 */
public class Sword_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int cols = matrix[0].length;
        int rows = matrix.length;
        int[] spiralOrder = new int[rows * cols];
        int round = 0, x = 0, y = 0, order = 0;
        // 结束条件为填充完毕
        while (order < spiralOrder.length) {
            // 向右
            while (x < cols - round) {
                spiralOrder[order] = matrix[y][x];
                x++;
                order ++;
            }
            if (order >= spiralOrder.length) {
                return spiralOrder;
            }
            // 越界后返回并向下
            x--;
            y++;
            while (y < rows - round) {
                spiralOrder[order] = matrix[y][x];
                y++;
                order ++;
            }
            if (order >= spiralOrder.length) {
                return spiralOrder;
            }
            // 越界后返回并向左
            x--;
            y--;
            while (x >= round) {
                spiralOrder[order] = matrix[y][x];
                x--;
                order ++;
            }
            if (order >= spiralOrder.length) {
                return spiralOrder;
            }
            // 越界后返回并向上
            x++;
            y--;
            while (y > round) {
                spiralOrder[order] = matrix[y][x];
                y--;
                order ++;
            }
            x++;
            y++;
            // 圈数加1
            round++;
        }
        return spiralOrder;
    }
}
