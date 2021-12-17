package com.cshawn.codes.leetcodes.everyday;

/**
 * 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 *
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 *
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 *
 * 示例 4：
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 *
 * 提示：
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/17 9:27 上午
 */
public class Q1518 {
    // 方法1：递归
    public int numWaterBottles1(int numBottles, int numExchange) {
        return numBottles + exchangeWithEmpty(numBottles, numExchange);
    }

    private int exchangeWithEmpty(int empty, int numExchange) {
        int change = empty / numExchange;
        if (change == 0) {
            return 0;
        }
        return change + exchangeWithEmpty(change + empty % numExchange, numExchange);
    }

    // 方法2：循环
    public int numWaterBottles2(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            numBottles -= numExchange;
            numBottles++;
            result++;
        }
        return result;
    }

    // 方法3：数学
    // 每次换酒，减少numExchange个瓶子换1瓶酒并增加1个瓶子，即减少numExchange-1个瓶子，可换1瓶酒
    // 设可换x次，求刚好不满足numBottles - x * (numExchange - 1) >= numExchange的最大x
    // x <= (numBottles - numExchange) / (numExchange - 1)
    // 刚好不满足则x = (numBottles - numExchange) / (numExchange - 1) + 1
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles < numExchange ? numBottles : (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles;
    }
}