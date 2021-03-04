package com.cshawn.leetcodes.everyday;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:不允许旋转信封。
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3 
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/4 4:13 下午
 */
public class Q354 {
    // 两重因素考虑能否变为一重因素，先按宽度排序，那么，需要考虑后者的高度大于前者的高度即可装入
    // 那么就是在按宽度排序后，需要找出一连串信封，高度是递增的，求这个最长的连续个数，这不就是最长递增子数列嘛
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        // 一个信封不用计算
        if (envelopes.length <= 0) {
            return envelopes.length;
        }
        // 当宽度相等时，高度较大亦不可满足条件，所以宽度相等时排序可将高度按降序排列
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int result = 1;
        // dp[i]定义为以i结尾的最长递增子序列
        // dp[i] = 0~i中的j，a[i]>a[j]时,更新dp[i]+1的最大值
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}
