package com.cshawn.leetcodes.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/28 21:40
 */
public class Sword_37 {
    public String serialize(TreeNode root) {
        char separator = ',';
        String nullNode = "null";
        StringBuilder sb = new StringBuilder("[");
        if (root != null) {
            // 用队列存储广度优先遍历的二叉树
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                // 取出队列中第一个结点
                TreeNode node = queue.poll();
                // 拼接分隔符
                if (node != null) {
                    // 将结点的左右子树添加到队列中
                    queue.add(node.left);
                    queue.add(node.right);
                    // 拼接当前结点
                    sb.append(node.val);
                } else {
                    // 结点为空时拼接null
                    sb.append(nullNode);
                }
                sb.append(separator);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 3 || !data.startsWith("[") || !data.endsWith("]")) {
            return null;
        }
        String[] list = data.substring(1, data.length() - 1).split(",");
        if (list.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(Integer.parseInt(list[0]));
        /*
        // 用集合存储广度优先遍历的二叉树
        List<TreeNode> temp = new ArrayList<>();
        temp.add(tree);
        // 存储当前结点的父结点的位置
        int parent = 0;
        // 当前是左子树还是右子树
        boolean left = true;
        for (int i = 1; i < list.length; i++) {
            String s = list[i];
            TreeNode node;
            if ("null".equals(s)) {
                node = null;
            } else {
                node = new TreeNode(Integer.parseInt(s));
            }
            // 将当前结点添加到集合中，等待作为后续结点的父结点使用
            temp.add(node);
            // 父结点为空时，向后查找不空的结点作为父结点
            while (parent < temp.size() && temp.get(parent) == null) {
                parent++;
            }
            // 获取父结点
            TreeNode parentNode = temp.get(parent);
            if (left) {
                // 指定其左结点
                parentNode.left = node;
            } else {
                // 指定其右结点
                // 当前父结点已完成，向后移动
                parentNode.right = node;
                parent++;
            }
            // 取反左右标志位
            left = !left;
        }
        */
        String nullNode = "null";
        // 用队列存储广度优先遍历的二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nullNode.equals(list[index])) {
                // 添加左结点
                node.left = new TreeNode(Integer.parseInt(list[index]));
                // 并将左结点放入队列
                queue.add(node.left);
            }
            index++;
            if (!nullNode.equals(list[index])) {
                // 添加右结点
                node.right = new TreeNode(Integer.parseInt(list[index]));
                // 并将右结点放入队列
                queue.add(node.right);
            }
            index++;
        }
        return tree;
    }

    /**
     * 使用深度优先
     */
    public String serialize2(TreeNode root) {
        char separator = ',';
        String nullNode = "null";
        StringBuilder sb = new StringBuilder("[");
        if (root != null) {
            serialize(root, sb, nullNode, separator);
            sb.deleteCharAt(sb.indexOf(separator + ""));
        }
        sb.append("]");
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb, String nullNode, char separator) {
        sb.append(separator);
        if (node != null) {
            sb.append(node.val);
            serialize(node.left, sb, nullNode, separator);
            serialize(node.right, sb, nullNode, separator);
        } else {
            sb.append(nullNode);
        }
    }

    /**
     * 深度优先
     */
    public TreeNode deserialize2(String data) {
        if (data == null || data.length() < 3 || !data.startsWith("[") || !data.endsWith("]")) {
            return null;
        }
        String[] list = data.substring(1, data.length() - 1).split(",");
        if (list.length == 0) {
            return null;
        }
        return deserialize(list, "null");
    }
    int index = 0;
    private TreeNode deserialize(String[] list, String nullNode) {
        if (nullNode.equals(list[index])) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list[index]));
        index++;
        node.left = deserialize(list, nullNode);
        index++;
        node.right = deserialize(list, nullNode);
        return  node;
    }
}
