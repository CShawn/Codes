package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 提示：
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random为空（null）或指向链表中的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/22 8:44 上午
 */
public class Q138 {
    // DFS + 哈希表
    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return copy(head, map);
    }

    private Node copy(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        Node n = map.get(node);
        if (n == null) {
            n = new Node(node.val);//.order(node.order);
            map.put(node, n);
            n.next = copy(node.next, map);
            n.random = copy(node.random, map);
        }
        return n;
    }

    // 方法2：在每个结点后复制一个结点，赋值随机结点后再将链表拆分
    public Node copyRandomList(Node head) {
        // 在每个结点后复制一个结点
        Node cur = head;
        while (cur != null) {
            Node cp = new Node(cur.val);//.order(cur.order);
            cp.next = cur.next;
            cur.next = cp;
            cur = cp.next;
        }
        // 复制随机结点
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // 拆分链表
        Node dummy = new Node(0);
        Node result = dummy;
        cur = head;
        while (cur != null) {
            result.next = cur.next;
            result = result.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }

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
}
