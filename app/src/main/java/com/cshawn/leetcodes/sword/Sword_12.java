package com.cshawn.leetcodes.sword;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 
 * 提示：1 <= board.length <= 200, 1 <= board[i].length <= 200
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/22 16:04
 */
public class Sword_12 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //*
                // 找到第一个字符，开始匹配
                if (board[i][j] == chars[0]) {
                    if (findNext(board, chars, i, j, 1)) {
                        return true;
                    }
                }
                //*/
                // 或者说，应该直接查找当前位置的值是否匹配
                // if (find(board, chars, i, j, 0)) {
                //     return true;
                // }
            }
        }
        return false;
    }

    // 查找(x,y)位置周围是否有与k相同的元素，向四个方向查找，当查找到最后一个元素时，完成查找
    private boolean findNext(char[][] board, char[] chars, int x, int y, int k) {
        /*
        if (x - 1 >= 0 && board[x - 1][y] == chars[k]) {
            if (k + 1 == chars.length) {
                return true;
            }
            // 向左
            if(findNext(board, chars, x - 1, y, k + 1)) {
                return true;
            }
        }
        if (x + 1 < board.length && board[x + 1][y] == chars[k]) {
            if (k + 1 == chars.length) {
                return true;
            }
            // 向右
            if (findNext(board, chars, x + 1, y, k + 1)) {
                return true;
            }
        }
        if (y - 1 >= 0 && board[x][y - 1] == chars[k]) {
            if (k + 1 == chars.length) {
                return true;
            }
            // 向上
            if (findNext(board, chars, x, y - 1, k + 1)) {
                return true;
            }
        }
        if (y + 1 < board[x].length && board[x][y + 1] == chars[k]) {
            if (k + 1 == chars.length) {
                return true;
            }
            // 向右
            if (findNext(board, chars, x, y + 1, k + 1)) {
                return true;
            }
        } else {
            return false;
        }
        */
        // 以上可简写为：
        if (k >= chars.length) {
            return true;
        }
        // 对于重复访问的问题，可以取巧，把访问过的数据置空，访问结束回溯时再改回来，就不需要额外空间存储
        board[x][y] = '\0';
        if (x - 1 >= 0 && board[x - 1][y] == chars[k]) {
            // 向左
            if(findNext(board, chars, x - 1, y, k + 1)) {
                return true;
            }
        }
        if (x + 1 < board.length && board[x + 1][y] == chars[k]) {
            // 向右
            if (findNext(board, chars, x + 1, y, k + 1)) {
                return true;
            }
        }
        if (y - 1 >= 0 && board[x][y - 1] == chars[k]) {
            // 向上
            if (findNext(board, chars, x, y - 1, k + 1)) {
                return true;
            }
        }
        if (y + 1 < board[x].length && board[x][y + 1] == chars[k]) {
            // 向右
            if (findNext(board, chars, x, y + 1, k + 1)) {
                return true;
            }
        }
        // 改回原始值
        board[x][y] = chars[k - 1];
        return false;
    }

    // 查找(x,y)位置的元素是否与第index个元素匹配，且继续向后查找
    // 对于重复访问的问题，可以取巧，把访问过的数据置空，访问结束回溯时再改回来，就不需要额外空间存储
    private boolean find(char[][] board, char[] chars, int x, int y, int index) {
        // 界定范围
        // 判断当前元素是否与index位置元素相同
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] != chars[index]) {
            return false;
        }
        // 查找到最后一个元素都相同，则匹配成功
        if (index == chars.length - 1) {
            return true;
        }
        board[x][y] = '\0';
        boolean result = find(board, chars, x - 1, y, index + 1) || find(board, chars, x + 1, y, index + 1)
            || find(board, chars, x, y - 1, index + 1) || find(board, chars, x, y + 1, index + 1);
        board[x][y] = chars[index];
        return result;
    }
}
