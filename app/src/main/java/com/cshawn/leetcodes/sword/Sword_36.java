package com.cshawn.leetcodes.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @author C.Shawn
 * @date 2020/12/23 5:24 下午
 */
public class Sword_36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public Node left(Node left) {
            this.left = left;
            return this;
        }

        public Node right(Node right) {
            this.right = right;
            return this;
        }

        public List<Integer> toRight(int size) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            Node node = this;
            while (i < size) {
                if (node != null) {
                    list.add(node.val);
                    node = node.right;
                } else {
                    list.add(null);
                }
                i++;
            }
            return list;
        }

        public List<Integer> toLeft(int size) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            Node node = this;
            while (i < size) {
                if (node != null) {
                    list.add(node.val);
                    node = node.left;
                } else {
                    list.add(null);
                }
                i++;
            }
            return list;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node right = treeToDoublyList(root.right);
        Node left = treeToDoublyList(root.left);
        if (left == null && right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        if (right == null) {
            // 将左侧子链表最后一个结点的的后继结点指向根结点
            if (left.left != null) {
                left.left.right = root;
            } else {
                left.right = root;
            }
            // 将根结点的前驱结点指向左侧子链表的最后一个结点
            root.left = left.left != null ? left.left : left;
            // 将根结点的后继结点指向左侧子链表的第一个结点
            root.right = left;
            // 将左侧子链表的第一个结点的前驱指向右侧子链表的最后一个结点
            left.left = root;
            return left;
        }
        if (left == null) {
            // 将根结点的后继结点指向右侧子链表的第一个结点
            root.right = right;
            // 将右侧子链表最后一个结点的的后继结点置为根结点
            if (right.left != null) {
                right.left.right = root;
            } else {
                right.right = root;
            }
            // 将根结点的前驱结点指向右侧子链表的最后一个结点
            root.left = right.left != null ? right.left : right;
            // 将右侧链表的第一个结点的前驱结点指向当前结点
            right.left = root;
            return root;
        }
        // 将左侧子链表最后一个结点的的后继结点指向根结点
        if (left.left != null) {
            left.left.right = root;
        } else {
            left.right = root;
        }
        // 将根结点的前驱结点指向左侧子链表的最后一个结点
        root.left = left.left != null ? left.left : left;
        // 将根结点的后继结点指向右侧子链表的第一个结点
        root.right = right;
        // 将右侧子链表最后一个结点的的后继结点置为根结点
        if (right.left != null) {
            right.left.right = left;
        } else {
            right.right = left;
        }
        // 将左侧子链表的第一个结点的前驱指向右侧子链表的最后一个结点
        left.left = right.left != null ? right.left : right;
        // 将右侧链表的第一个结点的前驱结点指向当前结点
        right.left = root;
        return left;
    }
}
