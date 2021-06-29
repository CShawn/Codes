package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 滑动谜题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用0来表示.
 * 一次移动定义为选择0与一个相邻的数字（上下左右）进行交换.
 * 最终当板board的结果是[[1,2,3],[4,5,0]]谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * 示例：
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 * board是一个如上所述的 2 x 3 的数组.
 * board[i][j]是一个[0, 1, 2, 3, 4, 5]的排列.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/26 3:13 下午
 */
public class Q773 {
    // 方法1：广度优先遍历
    public int slidingPuzzle1(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int i : ints) {
                sb.append(i);
            }
        }
        String target = "123450";
        String init = sb.toString();
        if (init.equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.offer(init);
        checked.add(init);
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (String s : getNext1(queue.poll())) {
                    if (!checked.contains(s)) {
                        if (target.equals(s)) {
                            return result;
                        }
                        checked.add(s);
                        queue.offer(s);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNext1(String board) {
        List<String> list = new LinkedList<>();
        int zero = board.indexOf('0');
        char[] arr = board.toCharArray();
        switch (zero) {
            case 0:
                swap(arr, 0, 1);
                list.add(new String(arr));
                swap(arr, 0, 1);
                swap(arr, 0, 3);
                list.add(new String(arr));
                swap(arr, 0, 3);
                break;
            case 1:
                swap(arr, 0, 1);
                list.add(new String(arr));
                swap(arr, 0, 1);
                swap(arr, 1, 2);
                list.add(new String(arr));
                swap(arr, 1, 2);
                swap(arr, 1, 4);
                list.add(new String(arr));
                swap(arr, 1, 4);
                break;
            case 2:
                swap(arr, 1, 2);
                list.add(new String(arr));
                swap(arr, 1, 2);
                swap(arr, 2, 5);
                list.add(new String(arr));
                swap(arr, 2, 5);
                break;
            case 3:
                swap(arr, 0, 3);
                list.add(new String(arr));
                swap(arr, 0, 3);
                swap(arr, 3, 4);
                list.add(new String(arr));
                swap(arr, 3, 4);
                break;
            case 4:
                swap(arr, 1, 4);
                list.add(new String(arr));
                swap(arr, 1, 4);
                swap(arr, 3, 4);
                list.add(new String(arr));
                swap(arr, 3, 4);
                swap(arr, 4, 5);
                list.add(new String(arr));
                swap(arr, 4, 5);
                break;
            case 5:
                swap(arr, 2, 5);
                list.add(new String(arr));
                swap(arr, 2, 5);
                swap(arr, 4, 5);
                list.add(new String(arr));
                swap(arr, 4, 5);
                break;
        }
        return list;
    }

    private void swap(char[] arr, int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // 方法2：A*
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int i : ints) {
                sb.append(i);
            }
        }
        String target = "123450";
        String init = sb.toString();
        if (init.equals(target)) {
            return 0;
        }
        AStar.col = board[0].length;
        PriorityQueue<AStar> queue = new PriorityQueue<>((o1, o2) -> o1.f - o2.f);
        Set<String> checked = new HashSet<>();
        queue.offer(new AStar(init, 0));
        checked.add(init);
        while (!queue.isEmpty()) {
            AStar item = queue.poll();
            for (String next : getNext(item.status)) {
                if (!checked.contains(next)) {
                    if (target.equals(next)) {
                        return item.g + 1;
                    }
                    queue.offer(new AStar(next, item.g + 1));
                    checked.add(next);
                }
            }
        }
        return -1;
    }

    static class AStar {
        public String status;
        public int g, f, h;
        public static int col;

        public AStar(String status, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status);
            this.f = this.g + this.h;
        }
        // 启发函数为曼哈顿距离
        public int getH(String status) {
            int res = 0;
            for (int i = 0; i < status.length(); i++) {
                int n = status.charAt(i) - '0';
                if (n != 0) {
                    int x = i / col, y = i % col;
                    int real = n - 1;
                    int realX = real / col, realY = real % col;
                    res += Math.abs(x - realX) + Math.abs(y - realY);
                }
            }
            return res;
        }
    }

    private int[][] nexts = new int[][]{{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
    private List<String> getNext(String board) {
        List<String> list = new LinkedList<>();
        int zero = board.indexOf('0');
        char[] arr = board.toCharArray();
        for (int t : nexts[zero]) {
            swap(arr, zero, t);
            list.add(new String(arr));
            swap(arr, zero, t);
        }
        return list;
    }
}
