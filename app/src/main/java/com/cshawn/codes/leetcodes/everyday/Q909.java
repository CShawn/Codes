package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q909 {
     // 广度优先遍历
     // 注意奇偶性与左右方向的关系不固定
     public int snakesAndLadders(int[][] board) {
        if ((board.length & 1) == 0 && board[0][0] != -1) {
            return -1;
        }
        if ((board.length & 1) == 1 && board[0][board.length - 1] != -1) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> checked = new HashSet<>();
        checked.add(1);
        int target = board.length * board.length;
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (Integer next : getNext(board, queue.poll())) {
                    if (!checked.contains(next) && !queue.contains(next)) {
                        if (target == next) {
                            return result;
                        }
                        queue.offer(next);
                        checked.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<Integer> getNext(int[][] board, int value) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            value++;
            if (value > board.length * board.length) {
                break;
            }
            int line = board.length - 1 - (value - 1) / board.length;
            int col = ((line & 1) ^ (board.length & 1)) == 1 ? (value - 1) % board.length : board.length - 1 - (value - 1) % board.length;
            int next = board[line][col] == -1 ? value : board[line][col];
            list.add(next);
        }
        return list;
    }
}
