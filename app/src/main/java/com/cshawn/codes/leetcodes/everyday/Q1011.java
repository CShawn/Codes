package com.cshawn.codes.leetcodes.everyday;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 *
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 *
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 *
 * 提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/26 8:18 下午
 */
public class Q1011 {
    // 结果在weights的最大值和总和之间，即船的运载能力最小要大于等于最重的货物，最大必然小于货物的总重
    // 可使用二分法在此范围内寻找右边界
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
//        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
//            right += weight;
        }
        // 货物总和最多为left*size，要D天运完，所以船的最大运载能力可以优化为：
        int right = left * weights.length / D + 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (canTransfer(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 判断一艘载重量为capacity的船是否可以在days天内运完
    private boolean canTransfer(int[] weights, int days, int capacity) {
        int sum = 0;
        // 计算到最后剩余的货物需要运一天，因而从1开始
        int day = 1;
        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }
            if (sum + weight <= capacity) {
                sum += weight;
            } else {
                sum = weight;
                if (++day > days) {
                    return false;
                }
            }
        }
        return true;
    }
}
