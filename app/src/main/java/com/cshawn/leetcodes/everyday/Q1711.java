package com.cshawn.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * 提示：
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/7/7 8:47 上午
 */
public class Q1711 {
    public int countPairs1(int[] deliciousness) {
        // 统计相同数字出现的次数，并求出最值
        Map<Integer, Integer> repeat = new HashMap<>();
        int max = 0, min = Integer.MAX_VALUE;
        for (int de : deliciousness) {
            if (de > max) {
                max = de;
            }
            if (de < min) {
                min = de;
            }
            repeat.put(de, repeat.getOrDefault(de, 0) + 1);
        }
        // 2的幂最小为1，不是0
        if (min < 1) {
            min = 1;
        }
        int max1 = 32 - Integer.numberOfLeadingZeros(max);
        int min1 = 32 - Integer.numberOfLeadingZeros(min) - 1;
        // 存储2的幂次的数组
        int[] sums = new int[max1 - min1 + 1];
        int index = 0;
        for (int i = min1; i <= max1; i++) {
            sums[index++] = 1 << i;
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : repeat.entrySet()) {
            int cur = entry.getKey();
            for (int sum : sums) {
                int last = sum - cur;
                int count = repeat.getOrDefault(last, 0);
                if (count == 0) {
                    continue;
                }
                if (cur == last && count > 1) {
                    // 两数相同时，n * (n - 1) / 2
                    result = (int) ((result + (long)count * (count - 1) / 2 % 1000000007) % 1000000007);
                } else if (last != cur) {
                    // 不同时，个数相乘
                    result = (int) ((result + entry.getValue() * (long)count  % 1000000007) % 1000000007);
                }
            }
            repeat.put(cur, 0);
        }
        return result;
    }

    // Map统计当前位置之前数字出现的次数, 不过没有方法1快
    public int countPairs(int[] deliciousness) {
        // 求出最值
        int max = 0, min = Integer.MAX_VALUE;
        for (int de : deliciousness) {
            if (de > max) {
                max = de;
            }
            if (de < min) {
                min = de;
            }
        }
        // 2的幂最小为1，不是0
        if (min < 1) {
            min = 1;
        }
        int max1 = 32 - Integer.numberOfLeadingZeros(max);
        int min1 = 32 - Integer.numberOfLeadingZeros(min) - 1;
        // 存储2的幂次的数组
        int[] sums = new int[max1 - min1 + 1];
        int index = 0;
        for (int i = min1; i <= max1; i++) {
            sums[index++] = 1 << i;
        }
        int result = 0;
        Map<Integer, Integer> repeat = new HashMap<>();
        for (int d : deliciousness) {
            for (int sum : sums) {
                int count = repeat.getOrDefault(sum - d, 0);
                result = (result + count) % 1000000007;
            }
            repeat.put(d, repeat.getOrDefault(d, 0) + 1);
        }
        return result;
    }
}
