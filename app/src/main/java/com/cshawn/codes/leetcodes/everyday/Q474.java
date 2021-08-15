package com.cshawn.codes.leetcodes.everyday;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * 
 * 提示：
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/6 22:10
 */
public class Q474 {
    // 动态规划
    public int findMaxForm1(String[] strs, int m, int n) {
        // dp[i][j][k]表示长度为i的子数组中，最多j个0，k个1的最大子集长度
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            String s = strs[i - 1];
            int[] info = getInfo(s);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 先将当前值设为i-1的最大子集长度
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= info[0] && k >= info[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - info[0]][k - info[1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    /**
     * 计算str中0和1的个数，返回长度为2的数组
     * @param str
     * @return
     */
    private int[] getInfo(String str) {
        int[] info = new int[2];
        for (int i = 0; i < str.length(); i++) {
            info[str.charAt(i) - '0']++;
        }
        return info;
    }

    // 优化空间，滚动数组
    public int findMaxForm2(String[] strs, int m, int n) {
        // i只与i-1有关，可使用滚动数组
        int[][][] dp = new int[2][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            String s = strs[i - 1];
            int[] info = getInfo(s);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 先将当前值设为i-1的最大子集长度
                    dp[i & 1][j][k] = dp[i & 1 ^ 1][j][k];
                    if (j >= info[0] && k >= info[1]) {
                        dp[i & 1][j][k] = Math.max(dp[i & 1 ^ 1][j][k], dp[i & 1 ^ 1][j - info[0]][k - info[1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length & 1][m][n];
    }

    // 优化空间，倒序遍历
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] info = getInfo(s);
            for (int j = m; j >= info[0]; j--) {
                for (int k = n; k >= info[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - info[0]][k - info[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
