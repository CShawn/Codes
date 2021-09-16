package com.cshawn.codes.leetcodes.everyday;

/**
 * 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 *
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/16 4:34 下午
 */
public class Q79 {
    // 回溯
    public boolean exist1(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs1(board, word, 0, visited, m, n, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs1(char[][] board, String word, int index, boolean[][] visited, int m, int n, int i, int j) {
        if (visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (++index == word.length()) {
            return true;
        }
        visited[i][j] = true;
        if (i > 0 && dfs1(board, word, index, visited, m, n, i - 1, j)) {
            return true;
        }
        if (i < m - 1 && dfs1(board, word, index, visited, m, n, i + 1, j)) {
            return true;
        }
        if (j > 0 && dfs1(board, word, index, visited, m, n, i, j - 1)) {
            return true;
        }
        if (j < n - 1 && dfs1(board, word, index, visited, m, n, i, j + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    // 优化空间，不使用额外visited
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length()) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, m, n, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int m, int n, int i, int j) {
        if (board[i][j] == '#' || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (++index == word.length()) {
            return true;
        }
        char origin = board[i][j];
        board[i][j] = '#';
        if (i > 0 && dfs(board, word, index, m, n, i - 1, j)) {
            return true;
        }
        if (i < m - 1 && dfs(board, word, index, m, n, i + 1, j)) {
            return true;
        }
        if (j > 0 && dfs(board, word, index, m, n, i, j - 1)) {
            return true;
        }
        if (j < n - 1 && dfs(board, word, index, m, n, i, j + 1)) {
            return true;
        }
        board[i][j] = origin;
        return false;
    }
}
