package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/30 5:11 下午
 */
public class Q297 {
    public static class Codec {
        private final String separator = ",";
        private final String nullNode = "null";
        private Queue<TreeNode> queue = new LinkedList<>();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            queue.clear();
            queue.offer(root);
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(separator);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append(nullNode);
                    sb.append(separator);
                }
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            queue.clear();
            String[] arr = data.split(separator);
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.offer(root);
            int index = 0;
            while (!queue.isEmpty()) {
                TreeNode parent = queue.poll();
                String left = arr[++index];
                if (!nullNode.equals(left)) {
                    TreeNode node = new TreeNode(Integer.parseInt(left));
                    parent.left = node;
                    queue.offer(node);
                }
                String right = arr[++index];
                if (!nullNode.equals(right)) {
                    TreeNode node = new TreeNode(Integer.parseInt(right));
                    parent.right = node;
                    queue.offer(node);
                }
            }
            return root;
        }
    }
}
