package com.cshawn.codes.leetcodes.sword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/12/22 1:55 下午
 */
public class Sword_35 {
    static class Node {
        int val;
        Node next;
        Node random;
        private int order;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node order(int order) {
            this.order = order;
            return this;
        }

        public Node next(Node next) {
            this.next = next;
            return this;
        }

        public Node random(Node random) {
            this.random = random;
            return this;
        }

        public List<Integer[]> toArray() {
            List<Integer[]> list = new ArrayList<>();
            Node temp = this;
            while (temp != null) {
                list.add(getItem(temp));
                temp = temp.next;
            }
            return list;
        }

        private Integer[] getItem(Node node) {
            return new Integer[]{node.val, node.random != null ? node.random.order : null};
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 用来记录最终结果
        Node copy = new Node(0);
        // 用来记录更新当前结点
        Node temp = new Node(0);
        // temp在中途会不断变化，将最终记录的结点指定最初定义的temp，在最终返回时不会丢失
        copy.next = temp;
        // 使用map存储原始结点对应的复制结点
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            // 查找map中是否当前结点的复制结点
            Node node = map.get(head);
            Node copied;
            if (node != null) {
                // 有则赋值
                copied = node;
            } else {
                // 无则复制
                copied = new Node(head.val);//.order(head.order);
                map.put(head, copied);
            }
            if (head.next != null) {
                // 查找map中是否已有next结点的复制结点
                Node next = map.get(head.next);
                if (next != null) {
                    // 有则赋值
                    copied.next = next;
                } else {
                    // 无则复制
                    copied.next = new Node(head.next.val);//.order(head.next.order);
                    map.put(head.next, copied.next);
                }
            }
            if (head.random != null) {
                // 查找map中是否已有random结点的复制结点
                Node random = map.get(head.random);
                if (random != null) {
                    // 有则赋值
                    copied.random = random;
                } else {
                    // 无则复制
                    copied.random = new Node(head.random.val);//.order(head.random.order);
                    map.put(head.random, copied.random);
                }
            }
            // 更新复制的结点
            temp.next = copied;
            // 将原始结点向后移动
            head = head.next;
            // 将复制的结点向后移动
            temp = temp.next;
        }
        // 返回最初定义的temp的下一个结点
        return copy.next.next;
    }

    /**
     * 在每个结点后复制一个结点，赋值随机结点后再将链表拆分为部分
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        // 在每个结点后复制一个结点
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                // 赋值随机结点为原来结点的随机结点的后一个结点（复制出来的）
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
        // 拆分新链表的表头
        Node copied = head.next;
        // 临时结点用来不断遍历链表
        Node copiedNode = head.next;
        while (node != null) {
            // 将原链表中的元素重新指回
            node.next = node.next.next;
            node = node.next;
            // 后续有结点时将复制的结点指向复制的结点
            if (copiedNode.next != null) {
                copiedNode.next = copiedNode.next.next;
                copiedNode = copiedNode.next;
            }
        }
        return copied;
    }
}
