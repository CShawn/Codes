package com.cshawn.leetcodes.everyday;

/**
 * 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 * 示例 1：
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 *
 * 示例  2：
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 *
 * 示例 3：
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *
 * 提示：
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/13 9:22 下午
 */
public class Q1269 {
    // 动态规划
    public int numWays1(int steps, int arrLen) {
        // 在steps内最多可右移到steps/2的位置，取其与数组长度的较小值作为边界
        int end = Math.min(arrLen, (steps >> 1) + 1);
        // dp[i][j]表示当前处于i-1位置，剩余j步，回到0的方法数(为使i-1,i+1在有效范围内，数组扩容2行)
        // dp[i][j] = 三种移动方式下步数减1，即dp[i-1][j-1]+dp[i][j-1]+dp[i+1][j-1],需要按列递推
        int[][] dp = new int[end + 2][steps + 1];
        // 从0到0，剩余0步，有1种方法到达0，其他从x到0剩余0步，不可到达，为0
        dp[1][0] = 1;
        for (int j = 1; j <= steps; j++) {
            for (int i = 1; i < dp.length - 1 && i <= j + 1; i++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i][j - 1]) % 1000000007 + dp[i + 1][j - 1]) % 1000000007;
            }
        }
        return dp[1][steps];
    }

    // 方法2：优化方法1，降维，滚动数组
    // 方法1中，按列遍历，每一列只与前一列有关，可以优化空间，另外，可以行列交换一下，符合正常逻辑
    public int numWays(int steps, int arrLen) {
        int end = Math.min(arrLen, (steps >> 1) + 1);
        int[][] dp = new int[2][end + 2];
        dp[0][1] = 1;
        for (int step = 1; step <= steps; step++) {
            int bit = step & 1;
            int other = bit ^ 1;
            for (int i = 1; i < dp[bit].length - 1 && i <= step + 1; i++) {
                dp[bit][i] = ((dp[other][i - 1] + dp[other][i]) % 1000000007 + dp[other][i + 1]) % 1000000007;
            }
        }
        return dp[steps & 1][1];
    }
}
