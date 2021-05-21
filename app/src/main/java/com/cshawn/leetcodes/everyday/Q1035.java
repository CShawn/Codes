package com.cshawn.leetcodes.everyday;

/**
 * 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i]  和 nums2[j]  的直线，这些直线需要同时满足满足：
 *   nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * 示例 1：
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。 
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 *
 * 示例 2：
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 *
 * 示例 3：
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 *
 * 提示：
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncrossed-lines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/21 5:59 下午
 */
public class Q1035 {
    // 动态规划
    // 相当于求两个数组的最长公共子序列
    public int maxUncrossedLines1(int[] nums1, int[] nums2) {
        // dp[i][j]表示nums1[0:i-1]与nums2[0:j-1]的最长公共子序列
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i + 1][j + 1] = nums1[i] == nums2[j] ? dp[i][j] + 1 :
                        Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[nums1.length][nums2.length];
    }

    // 优化空间，滚动数组
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int bit = i & 1;
                dp[bit ^ 1][j + 1] = nums1[i] == nums2[j] ? dp[bit][j] + 1 :
                        Math.max(dp[bit][j + 1], dp[bit ^ 1][j]);
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }
}
