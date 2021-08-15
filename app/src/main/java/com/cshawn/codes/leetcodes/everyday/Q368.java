package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 *
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/23 5:31 下午
 */
public class Q368 {
    // 动态规划
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new LinkedList<>();
        // dp[i]表示以nums[i]结尾的最长整除子集的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // 小数才有可能是大数的因数，所以先排序
        Arrays.sort(nums);
        // 最大的整除子集长度，子集中最大的数
        int maxSize = 1, maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 遍历i之前所有的数字是否可以被nums[i]整除
            // 最小的质因子是2，所以可将当前元素i除以2，遍历到这个数就可以了，可以提速
            for (int j = 0; /*j < i*/ nums[j] * 2L <= (long) nums[i]; j++) {
                // 当可以整除时，dp[i]=dp[j]+1,取0到j能得到的最大值
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 当前长度变大时，更新最大的长度及最大的数
            if (dp[i] > maxSize) {
                // 更新最大的长度
                maxSize = dp[i];
                // 更新当前最大的数
                maxNum = nums[i];
            }
        }
        // 逆序遍历dp，将最大长度的子集最大数找出，再找次大数，依次得到整个子集
        for (int k = dp.length - 1; k >= 0 && maxSize > 0; k--) {
            // 找到最大长度相同且当前最大数可整除此数时，满足条件，加入结果集
            if (dp[k] == maxSize && maxNum % nums[k] == 0) {
                result.add(nums[k]);
                // 将长度减1，查找长度减1的索引
                maxSize--;
                // 更新当前值为下一个最大值
                maxNum = nums[k];
            }
        }
        return result;
    }
}
