package com.cshawn.leetcodes.everyday;

/**
 * 可获得的最大点数
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * 示例 1：
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 *
 * 示例 2：
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 *
 * 示例 3：
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 *
 * 示例 4：
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。 
 *
 * 示例 5：
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 *
 * 提示：
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/6 12:10 下午
 */
public class Q1423 {
    // 方法1：动态规划，秒写秒超时
    public int maxScore1(int[] cardPoints, int k) {
        if (cardPoints.length == 0 || k == 0) {
            return 0;
        }
        return max(cardPoints, 0, cardPoints.length - 1, k);
    }

    private int max(int[] cardPoints, int start, int end, int k) {
        if (k == 0) {
            return 0;
        }
        if (start == end) {
            return cardPoints[start];
        }
        return Math.max(
                cardPoints[start] + max(cardPoints, start + 1, end, k - 1),
                cardPoints[end] + max(cardPoints, start, end - 1, k - 1)
        );
    }

    // 方法2：滑动窗口。最终结果相当于左右两侧去掉k个元素，剩余的连续元素的和最小，当然就是滑动窗口了
    public int maxScore2(int[] cardPoints, int k) {
        // 定义左右指针，临时存储和，数组总和，剩余连续元素和的最小值
        int left = 0, right = 0, temp = 0, sum, min;
        while (right - left + 1 <= cardPoints.length - k) {
            temp += cardPoints[right++];
        }
        min = temp;
        sum = temp;
        while (right < cardPoints.length) {
            // 累加总和
            sum += cardPoints[right];
            // 统计当前连续元素的和
            temp -= cardPoints[left++];
            temp += cardPoints[right++];
            // 更新最小值
            if (temp < min) {
                min = temp;
            }
        }
        // 返回总和减去剩余的连续元素和
        return sum - min;
    }

    // 方法3：滑动窗口。直接统计当前滑动窗口两侧的元素和最大，不用方法2的方式（且方法2可能超出Int最大值）
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == 0 || k == 0) {
            return 0;
        }
        int temp = 0, result;
        int left = 0;
        // 先累加前k个元素和，即全从左侧拿取元素
        while (left < k && left < cardPoints.length) {
            temp += cardPoints[left++];
        }
        // 当k比数组长时，直接返回全部元素和
        if (k >= cardPoints.length) {
            return temp;
        }
        result = temp;
        // 定义右侧位置
        int right = cardPoints.length - 1;
        while (--left >= 0) {
            // 减去左侧最后一个元素，加上右侧一个元素。即在左侧舍去一个，再在右侧拿取一个元素
            temp -= cardPoints[left];
            temp += cardPoints[right--];
            // 更新最大值
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
