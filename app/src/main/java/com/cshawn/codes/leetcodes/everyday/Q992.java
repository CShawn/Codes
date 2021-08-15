package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * K 个不同整数的子数组
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * 返回 A 中好子数组的数目。
 *
 * 示例 1：
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * 示例 2：
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 * 提示：
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/9 10:21 上午
 */
public class Q992 {
    // 滑动窗口，哈希表
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A.length == 0 || K == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, result = 0;
        while (right < A.length || map.size() >= K) {
            if (map.size() < K) {
                // 不足则向右添加元素
                add(map, A[right++]);
            } else if (map.size() > K) {
                // 多于则不断删除左侧元素直到等于K
                while (map.size() > K) {
                    remove(map, A[left++]);
                }
            } else {
                int temp = left;
                // 正好K个时
                while (map.size() == K) {
                    // 累计子数组个数
                    result++;
                    // 不断从左侧删除元素
                    remove(map, A[temp++]);
                }
                // 将删除的左侧元素再添加回来
                for (int i = left; i < temp; i++) {
                    add(map, A[i]);
                }
                if (right < A.length) {
                    // 添加当前元素并右移右指针
                    add(map, A[right++]);
                } else {
                    // right越界时退出
                    break;
                }
            }
        }
        return result;
    }

    // 递减当前元素出现的次数
    private void remove(Map<Integer, Integer> map, int value) {
        Integer count = map.get(value);
        if (count != null && count != 1) {
            map.put(value, count - 1);
        } else {
            map.remove(value);
        }
    }

    // 累计当前元素出现的次数
    private void add(Map<Integer, Integer> map, int value) {
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
        }
    }
}
