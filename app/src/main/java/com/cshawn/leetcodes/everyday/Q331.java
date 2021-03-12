package com.cshawn.leetcodes.everyday;

import java.util.Stack;

/**
 * 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *       9
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 *
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 *
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/12 2:28 下午
 */
public class Q331 {
    // 方法1：用栈存储每个节点所含有的子节点个数，
    // 每遇到一个空节点，则将栈顶个节点个数减1；每遇到一个非空节点，栈顶元素减1，它可以有两个子节点，入栈2。
    // 每当栈顶元素为0时出栈。过程中栈空则不满足条件，若满足条件则最终栈为空
    public boolean isValidSerialization1(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        Stack<Integer> nodeCount = new Stack<>();
        nodeCount.push(1);
        int i = 0;
        while (i < preorder.length()) {
            if (nodeCount.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else {
                // 数量-1，数量减为0则出栈
                if (nodeCount.peek() == 1) {
                    nodeCount.pop();
                } else {
                    nodeCount.push(nodeCount.pop() - 1);
                }
                if (preorder.charAt(i) == '#') {
                    i++;
                } else {
                    // 为数字时，再入栈2个节点个数
                    nodeCount.push(2);
                    // 跳过数字
                    while (i < preorder.length() && preorder.charAt(i) != ',') {
                        i++;
                    }
                }
            }
        }
        return nodeCount.isEmpty();
    }

    // 方法2：优化方法1，只用统计包含的子节点个数，
    // 每遇到一个空节点，则减1；每遇到一个非空节点，减1，再加2，相当于加1。
    // 过程中个数为0则不满足条件，若满足条件则最终为0
    public boolean isValidSerialization2(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        int count = 1;
        int i = 0;
        while (i < preorder.length()) {
            if (count == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else {
                if (preorder.charAt(i) == '#') {
                    count--;
                    i++;
                } else {
                    count++;
                    // 跳过数字
                    while (i < preorder.length() && preorder.charAt(i) != ',') {
                        i++;
                    }
                }
            }
        }
        return count == 0;
    }

    // 方法3：树中所有节点的入度和与出度和相等。与方法1、2统计子节点个数类似
    // 空节点的入度为1，出度为0；非空节点的入度为1，出度为2;
    public boolean isValidSerialization3(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        // 入度为负，出度为正
        // 根节点没有入度，但在循环中统一计算时认为每个节点的入度为1（要减去1），因此初始化入度为1
        int degree = 1;
        int i = 0;
        while (i < preorder.length()) {
            if (preorder.charAt(i) == ',') {
                i++;
            } else {
                // 节点的入度为1，减1
                degree--;
                // 未遍历结束时，还未遍历到当前节点的子节点，因此出度大于入度；
                // 如果入度大于等于出度则不满足条件
                if (degree < 0) {
                    return false;
                }
                if (preorder.charAt(i) == '#') {
                    i++;
                } else {
                    // 非空节点的出度为2
                    degree += 2;
                    // 跳过数字
                    while (i < preorder.length() && preorder.charAt(i) != ',') {
                        i++;
                    }
                }
            }
        }
        return degree == 0;
    }

    // 方法4：当确定了一个节点后（非空节点后紧跟两个空节点），可以将其忽略，转换为一个空节点，最终会将一整棵树变为空
    public boolean isValidSerialization4(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        // 存储树的节点
        Stack<Character> nodes = new Stack<>();
        int i = 0;
        while (i < preorder.length()) {
            if (preorder.charAt(i) == ',') {
                i++;
            } else {
                //"9,3,4,#,#,1,#,#,2,#,6,#,#"
                if (preorder.charAt(i) == '#') {
                    // 遇到一个空节点时，如果前一个节点也是空节点，则将这三个节点转为一个空节点
                    // 栈顶为空节点，不断将两个空节点与一个非空节点共3个节点，转为一个空节点
                    while (!nodes.isEmpty() && nodes.peek() == '#') {
                        nodes.pop();
                        // 当空节点前没有节点时，亦不满足条件
                        if (nodes.isEmpty()) {
                            return false;
                        }
                        nodes.pop();
                    }
                    nodes.push('#');
                    i++;
                } else {
                    // 非空节点用'0'表示，不用存入真实数值
                    nodes.push('0');
                    // 跳过数字
                    while (i < preorder.length() && preorder.charAt(i) != ',') {
                        i++;
                    }
                }
            }
        }
        return nodes.size() == 1 && nodes.pop() == '#';
    }
}
