package com.cshawn.codes.leetcodes.everyday;

/**
 * 爱生气的书店老板
 * 书店老板有一家店打算试营业customers.length分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * 
 * 示例：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 
 * 提示：
 * 1 <= X <=customers.length ==grumpy.length <= 20000
 * 0 <=customers[i] <= 1000
 * 0 <=grumpy[i] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/23 9:17 上午
 */
public class Q1052 {
    // grumpy为0的顾客数需要加起来，此外一个连续的长度为X的子数组中的grumpy为1可以变为0
    // 那么，是个很简单的滑动窗口，且窗口长度固定为X
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        // grumpy为0的顾客总数；滑动窗口中grumpy为1的顾客数最大值
        int common = 0, change = 0;
        int left = 0, right = 0;
        int temp = 0;
        while (right < customers.length) {
            if (right - left + 1 > X) {
                if (grumpy[left] == 1) {
                    temp -= customers[left];
                }
                left++;
            }
            if (grumpy[right] == 0) {
                // 累加为0的元素
                common += customers[right];
            } else {
                // 统计当前滑动窗口内为1的元素之和
                temp += customers[right];
            }
            right++;
            // 更新当前滑动窗口中为1的元素和的最大值
            if (temp > change) {
                change = temp;
            }
        }
        return common + change;
    }

    // 先统计前X个，去掉内部的判断
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int common = 0;
        int right;
        int temp = 0;
        if (X < 0) {
            X = 0;
        }
        int min = Math.min(X, customers.length);
        for (right = 0; right < min; right++) {
            if (grumpy[right] == 0) {
                common += customers[right];
            } else {
                temp += customers[right];
            }
        }
        int change = temp;
        while (right < customers.length) {
            if (grumpy[right - X] == 1) {
                temp -= customers[right - X];
            }
            if (grumpy[right] == 0) {
                // 累加为0的元素
                common += customers[right];
            } else {
                // 统计当前滑动窗口内为1的元素之和
                temp += customers[right];
            }
            right++;
            // 更新当前滑动窗口中为1的元素和的最大值
            if (temp > change) {
                change = temp;
            }
        }
        return common + change;
    }
}
