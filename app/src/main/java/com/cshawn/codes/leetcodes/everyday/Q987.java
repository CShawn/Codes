package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.TreeNode;

import java.util.*;

/**
 * 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于(row, col)的每个结点而言，其左右子结点分别位于(row + 1, col - 1)和(row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。
 * 如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 *
 * 示例 2：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 *           1 在上面，所以它出现在前面。
 *           5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 *
 * 示例 3：
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * 
 * 提示：
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/31 10:34 上午
 */
public class Q987 {
    // 方法1：DFS + 哈希表 + 最小堆排序
    public List<List<Integer>> verticalTraversal1(TreeNode root) {
        // <列, 该列的结点[行，值]>
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        dfs1(root, 0, 0, map);
        Integer[] keys = new Integer[map.size()];
        map.keySet().toArray(keys);
        // 将列排序
        Arrays.sort(keys);
        List<List<Integer>> result = new ArrayList<>(keys.length);
        for (Integer key : keys) {
            PriorityQueue<int[]> queue = map.get(key);
            List<Integer> list = new ArrayList<>(queue.size());
            // 按顺序取出值
            while (!queue.isEmpty()) {
                list.add(queue.poll()[1]);
            }
            result.add(list);
        }
        return result;
    }

    private void dfs1(TreeNode root, int row, int col, Map<Integer, PriorityQueue<int[]>> map) {
        if (root == null) {
            return;
        }
        PriorityQueue<int[]> queue = map.get(col);
        if (queue == null) {
            // 将每列的结点按行排序，行相同时按结点的值排序
            queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            map.put(col, queue);
        }
        queue.offer(new int[]{row, root.val});
        dfs1(root.left, row + 1, col - 1, map);
        dfs1(root.right, row + 1, col + 1, map);
    }

    // 方法2：DFS + 自定义排序
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // int[]中分别为行，列，值
        List<int[]> list = new LinkedList<>();
        dfs(root, 0, 0, list);
        // 按照：列，行，值的顺序对所有节点进行排序
        list.sort((o1, o2) ->
                o1[1] == o2[1] ? o1[0] == o2[0] ? o1[2] - o2[2] : o1[0] - o2[0] : o1[1] - o2[1]
        );
        // 遍历所有结点，记录当前的列，列发生变化时重新创建一组list
        List<List<Integer>> result = new ArrayList<>();
        int preCol = list.get(0)[1];
        result.add(new ArrayList<>());
        for (int[] element : list) {
            List<Integer> col;
            if (element[1] != preCol) {
                col = new LinkedList<>();
                result.add(col);
                preCol = element[1];
            } else {
                col = result.get(result.size() - 1);
            }
            col.add(element[2]);
        }
        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<int[]> list) {
        if (root == null) {
            return;
        }
        list.add(new int[]{row, col, root.val});
        dfs(root.left, row + 1, col - 1, list);
        dfs(root.right, row + 1, col + 1, list);
    }
}