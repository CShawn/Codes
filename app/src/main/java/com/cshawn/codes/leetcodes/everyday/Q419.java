package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 甲板上的战舰
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 *
 * 示例 1：
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 *
 * 示例 2：
 * 输入：board = [["."]]
 * 输出：0
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 *
 * 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/18 1:18 下午
 */
public class Q419 {
    // 方法1：哈希表
    public int countBattleships1(char[][] board) {
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    int location = (i << 16) | j;
                    if (!visited.contains(location)) {
                        visited.add(location);
                        for (int k = i; k < board.length && board[k][j] == 'X'; k++) {
                            visited.add(k << 16 | j);
                        }
                        for (int k = j; k < board[i].length && board[i][k] == 'X'; k++) {
                            visited.add(i << 16 | k);
                        }
                        result++;
                    }
                }
            }
        }
        return result;
    }

    // 每次向右下遍历，则当前是否在已遍历过的战舰中，取决于左上是否为X；
    // 为X则还是之前遍历过的战舰的两部分，为.则是一个新的战舰
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                    result++;
                }
            }
        }
        return result;
    }
}
