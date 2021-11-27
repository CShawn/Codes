package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 随机翻转矩阵
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足matrix[i][j] == 0 的下标(i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 * 实现 Solution 类：
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 *
 * 示例：
 * 输入
 * ["Solution", "flip", "flip", "flip", "reset", "flip"]
 * [[3, 1], [], [], [], [], []]
 * 输出
 * [null, [1, 0], [2, 0], [0, 0], null, [2, 0]]
 *
 * 解释
 * Solution solution = new Solution(3, 1);
 * solution.flip();  // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * solution.flip();  // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
 * solution.flip();  // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
 * solution.reset(); // 所有值都重置为 0 ，并可以再次选择下标返回
 * solution.flip();  // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * 
 *
 * 提示：
 * 1 <= m, n <= 104
 * 每次调用flip 时，矩阵中至少存在一个值为 0 的格子。
 * 最多调用 1000 次 flip 和 reset 方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-flip-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/11/27 12:09 下午
 */
public class Q519 {
    // Q384的二维扩展
    // 此种解法超出内存限制
    static class Solution1 {
        private int[] matrix;
        private Random random;
        private int size;
        private int n;
        private int cur;

        public Solution1(int m, int n) {
            this.n = n;
            size = m * n;
            matrix = new int[size];
            random = new Random();
            reset();
        }

        public int[] flip() {
            int index = random.nextInt(cur--);
            int tmp = matrix[index];
            matrix[index] = matrix[cur];
            matrix[cur] = tmp;
            return new int[]{tmp / n, tmp % n};
        }

        public void reset() {
            cur = size;
            for (int i = 0; i < size; i++) {
                matrix[i] = i;
            }
        }
    }

    // 使用Map存在映射的索引，Map中存储的数量为flip调用的次数
    static class Solution {
        private Map<Integer, Integer> map;
        private Random random;
        private int size;
        private int n;
        private int cur;

        public Solution(int m, int n) {
            this.n = n;
            size = m * n;
            map = new HashMap<>();
            random = new Random();
        }

        public int[] flip() {
            int index = random.nextInt(cur--);
            int tmp = map.getOrDefault(index, index);
            map.put(index, map.getOrDefault(cur, cur));
            return new int[]{tmp / n, tmp % n};
        }

        public void reset() {
            cur = size;
            map.clear();
        }
    }
}
