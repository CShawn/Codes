package com.cshawn.codes.leetcodes.everyday;

/**
 * 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 *
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 *
 * 示例 3：
 * 输入：stones = [1,2]
 * 输出：1
 *
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/8 6:46 下午
 */
public class Q1049 {
    // 方法1：动态规划
    // 题意相当于对数组中的元素添加正负号，使得相加的和最小，类似于Q494
    // 设数组总和为sum, 添加负号的元素和为neg,则剩余元素的和为sum-neg，最终结果为(sum-neg)-neg=sum-2*neg
    // 要使sum-2*neg接近0，则sum-neg接近neg, 那么正数的和接近sum/2
    // 最终要求在stone中元素和不大于sum/2的最大值
    public int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int limit = sum >> 1;
        // dp[i][j]表示前i个元素能否凑到j；最终查找所有true中最大的j
        boolean[][] dp = new boolean[stones.length + 1][limit + 1];
        // 不选择元素凑出0，是可行的
        dp[0][0] = true;
        // j>num时，可选择当前元素，dp[i][j]=dp[i-1][j-num] + num；不选当前元素时，dp[i][j]=dp[i-1][j]
        for (int i = 1; i < dp.length; i++) {
            int stone = stones[i - 1];
            for (int j = 0; j < dp[i].length; j++) {
                if (j >= stone) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stone];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = limit; i >= 0; i--) {
            if (dp[stones.length][i]) {
                return sum - (i << 1);
            }
        }
        return 0;
    }

    // 优化空间：滚动数组
    public int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int limit = sum >> 1;
        // dp[i][j]表示前i个元素能否凑到j；最终查找所有true中最大的j
        boolean[][] dp = new boolean[2][limit + 1];
        // 不选择元素凑出0，是可行的
        dp[0][0] = true;
        // j>num时，可选择当前元素，dp[i][j]=dp[i-1][j-num] + num；不选当前元素时，dp[i][j]=dp[i-1][j]
        for (int i = 1; i <= stones.length; i++) {
            int cur = i & 1;
            int pre = cur ^ 1;
            int stone = stones[i - 1];
            for (int j = 0; j <= limit; j++) {
                if (j >= stone) {
                    dp[cur][j] = dp[pre][j] || dp[pre][j - stone];
                } else {
                    dp[cur][j] = dp[pre][j];
                }
            }
        }
        for (int i = limit; i >= 0; i--) {
            if (dp[stones.length & 1][i]) {
                return sum - (i << 1);
            }
        }
        return 0;
    }

    // 优化空间：倒序遍历
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int limit = sum >> 1;
        boolean[] dp = new boolean[limit + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int j = limit; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }
        for (int i = limit; i >= 0; i--) {
            if (dp[i]) {
                return sum - (i << 1);
            }
        }
        return 0;
    }
}