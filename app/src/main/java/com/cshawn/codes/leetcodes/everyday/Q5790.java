package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 查询差绝对值的最小值
 * 一个数组 a 的 差绝对值的最小值 定义为：0 <= i < j < a.length 且 a[i] != a[j] 的 |a[i] - a[j]| 的 最小值。如果 a 中所有元素都 相同 ，那么差绝对值的最小值为 -1 。
 * 比方说，数组 [5,2,3,7,2] 差绝对值的最小值是 |2 - 3| = 1 。注意答案不为 0 ，因为 a[i] 和 a[j] 必须不相等。
 * 给你一个整数数组 nums 和查询数组 queries ，其中 queries[i] = [li, ri] 。对于每个查询 i ，计算 子数组 nums[li...ri] 中 差绝对值的最小值 ，子数组 nums[li...ri] 包含 nums 数组（下标从 0 开始）中下标在 li 和 ri 之间的所有元素（包含 li 和 ri 在内）。
 * 请你返回 ans 数组，其中 ans[i] 是第 i 个查询的答案。
 * 子数组 是一个数组中连续的一段元素。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 * 示例 1：
 * 输入：nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]
 * 输出：[2,1,4,1]
 * 解释：查询结果如下：
 * - queries[0] = [0,1]：子数组是 [1,3] ，差绝对值的最小值为 |1-3| = 2 。
 * - queries[1] = [1,2]：子数组是 [3,4] ，差绝对值的最小值为 |3-4| = 1 。
 * - queries[2] = [2,3]：子数组是 [4,8] ，差绝对值的最小值为 |4-8| = 4 。
 * - queries[3] = [0,3]：子数组是 [1,3,4,8] ，差的绝对值的最小值为 |3-4| = 1 。
 *
 * 示例 2：
 * 输入：nums = [4,5,2,2,7,10], queries = [[2,3],[0,2],[0,5],[3,5]]
 * 输出：[-1,1,1,3]
 * 解释：查询结果如下：
 * - queries[0] = [2,3]：子数组是 [2,2] ，差绝对值的最小值为 -1 ，因为所有元素相等。
 * - queries[1] = [0,2]：子数组是 [4,5,2] ，差绝对值的最小值为 |4-5| = 1 。
 * - queries[2] = [0,5]：子数组是 [4,5,2,2,7,10] ，差绝对值的最小值为 |4-5| = 1 。
 * - queries[3] = [3,5]：子数组是 [2,7,10] ，差绝对值的最小值为 |7-10| = 3 。
 *  
 * 提示：
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 100
 * 1 <= queries.length <= 2 * 104
 * 0 <= li < ri < nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/20 11:41 上午
 */
public class Q5790 {
    // 方法1：dp+备忘录：超时超空间
    public int[] minDifference1(int[] nums, int[][] queries) {
        int[][] memo = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i][i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (memo[i][j - 1] == 1) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        if (nums[k] != nums[j]) {
                            memo[i][j] = Math.min(memo[i][j], Math.abs(nums[k] - nums[j]));
                        }
                    }
                    memo[i][j] = Math.min(memo[i][j - 1], memo[i][j]);
                }
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = memo[queries[i][0]][queries[i][1]];
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }

    // 方法2：优化方法1的空间，仍超时
    public int[] minDifference2(int[] nums, int[][] queries) {
        int[] memo = new int[nums.length];
        int[] result = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (memo[j - 1] == 1) {
                    memo[j] = 1;
                } else {
                    memo[j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        if (nums[k] != nums[j]) {
                            memo[j] = Math.min(memo[j], Math.abs(nums[k] - nums[j]));
                        }
                    }
                    memo[j] = Math.min(memo[j - 1], memo[j]);
                }
            }
            for (int m = 0; m < queries.length; m++) {
                if (i == queries[m][0] && result[m] == 0) {
                    result[m] = memo[queries[m][1]];
                    if (result[m] == Integer.MAX_VALUE) {
                        result[m] = -1;
                    }
                }
            }
        }
        return result;
    }

    // 前缀和+计数
    public int[] minDifference(int[] nums, int[][] queries) {
        int C = 100;
        // sums[i][j]表示以i结尾的子数组中j出现的次数，j取值为[1,100]
        int[][] sums = new int[nums.length + 1][C + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = Arrays.copyOf(sums[i], C + 1);
            sums[i + 1][nums[i]]++;
        }
        int[] result = new int[queries.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 0; i < queries.length; i++) {
            // 记录上一次出现的数字
            int pre = 0, left = queries[i][0], right = queries[i][1];
            for (int k = 1; k <= C; k++) {
                // [left, right]的和为sums[right+1]-sums[left]
                if (sums[left][k] != sums[right + 1][k]) {
                    if (pre != 0) {
                        result[i] = Math.min(result[i], k - pre);
                    }
                    pre = k;
                }
            }
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}