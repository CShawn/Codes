package com.cshawn.codes.leetcodes.everyday;

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
    // 那么就是在按宽度排序后，需要找出一连串信封，高度是递增的，求这个最长的连续个数，这不就是严格最长递增子数列嘛
    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        // 一个信封不用计算
        if (envelopes.length <= 0) {
            return envelopes.length;
        }
        // 当宽度相等时，高度较大亦不可满足条件，所以宽度相等时排序可将高度按降序排列，则在比较时只用关心宽度一个因素
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int result = 0;
        // dp[i]定义为以i结尾的最长递增子序列
        // dp[i] = 0~i中的j，a[i]>a[j]时,更新dp[i]+1的最大值
        int[] dp = new int[envelopes.length];
        // 填充为1
        // Arrays.fill(dp, 1);
        // 因至少一个元素，长度最小为1，因此赋值为1，
        // 但也可以省去这一步，初始化为0，在最后将result加1即可。
        // i为dp的当前索引
        for (int i = 1; i < envelopes.length; i++) {
            // j为在[0,i)范围内查找最大值
            for (int j = 0; j < i; j++) {
                // 只在当前值大于之前计算过的元素值时，才计算当前位置的长亮，
                // 因高度降序排列，因此宽度相同时不会被计算，因此不用关心高度因素
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 计算完一次dp[i]更新result
            result = Math.max(result, dp[i]);
        }
        return result + 1;
    }

    // 为得到严格最长递增子数列，则在构造子数列的过程中需要末尾的数字越小越好。
    // 在后续的过程中，如果遇到比末尾数字小的，但比倒数第2个数字大的，应该将末尾数字换掉；
    // 同理，将此数字与前边数字比较，比某个中间数字小，则应将比其小的数字换为此数字并继续进行，
    // 因为之前的数列是排序的，因而查找可以使用二分法
    // 最终数组的长度即为最长递增子数列
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }
        // 一个信封不用计算
        if (envelopes.length <= 0) {
            return envelopes.length;
        }
        // 当宽度相等时，高度较大亦不可满足条件，所以宽度相等时排序可将高度按降序排列，则在比较时只用关心宽度一个因素
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // 最长子数列，至少为1
        int result = 1;
        // 用于存储递增子数列
        int[] aux = new int[envelopes.length + 1];
        // 因result为1，所以初始位置为1，故而aux长度定为length+1更方便
        aux[result] = envelopes[0][1];
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > aux[result]) {
                aux[++result] = envelopes[i][1];
            } else {
                int left = 1, right = result, pos = 0;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (aux[mid] < envelopes[i][1]) {
                        // pos为最后一个比e[result]的数字，要替换其后一个数字
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                // e[result]比所有数字都小时，要替换起初数字即索引为1的数字
                aux[pos + 1] = envelopes[i][1];
            }
        }
        return result;
    }
}
