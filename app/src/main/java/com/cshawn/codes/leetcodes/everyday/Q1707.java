package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。
 * 换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。
 * 如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 *
 * 示例 1：
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 *
 * 示例 2：
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 *
 * 提示：
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/23 11:56 上午
 */
public class Q1707 {
    // 字典树
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        // 存储原数组的索引位置
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }
        // 按照查询限制数排序
        Arrays.sort(queries, Comparator.comparingInt(o -> o[1]));
        // 当前遍历到nums的位置
        int index = 0;
        int[] result = new int[queries.length];
        Trie trie = new Trie();
        for (int i = 0; i < queries.length; i++) {
            // 查询数比所有数小，返回-1
            if (queries[i][1] < nums[0]) {
                result[map.get(queries[i])] = -1;
                continue;
            }
            // 将当前小于查询数字的数加上字典树
            for (;index < nums.length && nums[index] <= queries[i][1]; index++) {
                trie.add(nums[index]);
            }
            int xOr = 0;
            Trie temp = trie;
            // 计算与queries[i][0]异或的最大值
            for (int k = 31; k >= 0; k--) {
                if (temp == null) {
                    break;
                }
                int bit = (queries[i][0] >> k) & 1;
                // 判断与当前bit位不同的bit是否存在，存在则当前位bit异或后可以得到1
                // 更新下一位的temp
                if (temp.nodes[bit ^ 1] != null) {
                    xOr |= (1 << k);
                    temp = temp.nodes[bit ^ 1];
                } else {
                    temp = temp.nodes[bit];
                }
            }
            // 得到最终异或值
            result[map.get(queries[i])] = xOr;
        }
        return result;
    }

    // 字典树
    class Trie {
        private Trie[] nodes = new Trie[2];
        public void add(int value) {
            Trie trie = this;
            for (int i = 31; i >= 0; i--) {
                int bit = (value >> i) & 1;
                if (trie.nodes[bit] == null) {
                    trie.nodes[bit] = new Trie();
                }
                trie = trie.nodes[bit];
            }
        }
    }
}
