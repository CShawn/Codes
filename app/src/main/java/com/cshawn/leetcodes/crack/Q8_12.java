package com.cshawn.leetcodes.crack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 八皇后
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * 注意：本题相对原题做了扩展
 * 示例:
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/8 1:46 下午
 */
public class Q8_12 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        // n为1时，有一种排列方式；n为0,2,3时，没有排列方式
        if (n == 1) {
            List<String> res = new LinkedList<>();
            res.add("Q");
            result.add(res);
            return result;
        }
        if (n < 4) {
            return result;
        }
        backtracking(result, 0, new int[n]);
        return result;
    }

    /**
     * 按行回溯
     * @param result 结果集
     * @param index 当前行
     * @param rows 每行存放皇后的位置
     */
    private void backtracking(List<List<String>> result, int index, int[] rows) {
        if (index == rows.length) {
            List<String> rowStr = new ArrayList<>(rows.length);
            /*
            StringBuilder sb = new StringBuilder();
            // 填充每行Q的位置
            for (int row : rows) {
                sb.delete(0, sb.length());
                for (int j = 0; j < row; j++) {
                    sb.append('.');
                }
                sb.append('Q');
                for (int j = row + 1; j < rows.length; j++) {
                    sb.append('.');
                }
                rowStr.add(sb.toString());
            }
            */
            // 优化每行的填充
            for (int row : rows) {
                char[] queen = new char[rows.length];
                Arrays.fill(queen, '.');
                queen[row] = 'Q';
                rowStr.add(new String(queen));
            }
            result.add(rowStr);
            return;
        }
        // 用于记录当前行中已被占用的列（同列及斜线）
        boolean[] used = new boolean[rows.length];
        // 遍历当前行之前的所有行，将已存放皇后所在的列及斜线位置置为true
        for (int i = 0; i < index; i++) {
            used[rows[i]] = true;
            int gap = index - i;
            if (rows[i] - gap >= 0) {
                used[rows[i] - gap] = true;
            }
            if (rows[i] + gap < used.length) {
                used[rows[i] + gap] = true;
            }
        }
        for (int i = 0; i < used.length; i++) {
            // 从可选的位置中选择并回溯
            if (!used[i]) {
                rows[index] = i;
                backtracking(result, index + 1, rows);
            }
        }
    }
}
