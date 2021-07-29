package com.cshawn.leetcodes.everyday;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 * 示例 1：
 * 输入：label = 14
 * 输出：[1,3,4,14]
 *
 * 示例 2：
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 * 提示：1 <= label <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/29 5:49 下午
 */
public class Q1104 {

    // 方法1：当前数字正向位置上的数依次除2得到上一层数字
    public List<Integer> pathInZigZagTree1(int label) {
        List<Integer> list = new LinkedList<>();
        list.add(label);
        int row = 32 - Integer.numberOfLeadingZeros(label) - 1;
        while (row > 0) {
            if ((row & 1) == 0) {
                // 偶数行:当前数字除2再取反向数字
                label = getReverse(label >> 1, row - 1);
            } else {
                // 奇数行:当前数字取反向数字再除2
                label = getReverse(label, row) >> 1;
            }
            // 此时label为上一层数字
            list.add(label);
            row--;
        }
        Collections.reverse(list);
        return list;
    }

    // 求第row行中label正向时所在位置上的数字
    private int getReverse(int label, int row) {
        return (1 << (row + 1)) + (1 << row) - label - 1;
    }

    // 方法2：根据列每次除2得到上一层的列
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int row = 32 - Integer.numberOfLeadingZeros(label) - 1;
        // 数字所在列
        int col = (row & 1) == 1 ? (1 << (row + 1)) - 1 - label : label - (1 << row);
        int line = 0;
        while (line < row) {
            // 将列每次右移(除2)，得到的数字是上层数字所在的列；右移的位数递减实现正向list
            list.add(getItem(line, col >> (row - line)));
            line++;
        }
        list.add(label);
        return list;
    }
    // 得到第row行第col列的数字
    private int getItem(int row, int col) {
        int base = 1 << row;
        return base + ((row & 1) == 0 ? col : base - 1 - col);
    }
}
