package com.cshawn.leetcodes.sword;

/**
 * 机器人的运动范围 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。 一个机器人从坐标 [0, 0]
 * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外）， 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。 但它不能进入方格 [35,
 * 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
 * 示例 1： 输入：m = 2, n = 3, k = 1 输出：3
 * 示例 2： 输入：m = 3, n = 1, k = 0 输出：1
 * 提示： 1 <= n,m <= 100 0 <= k <= 20 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/22 21:00
 */
public class Sword_13 {
    // 1. 最简单的，直接遍历全部，判断各位数和满足条件即可。
    // 2. 因为从左上角开始，而各位数的和是递增的，所以，只用考虑两个方向：向右和向下。此时，类似于二叉树的遍历。
    //    到达符合条件的结束点时，不必再向后遍历，因此比第一种方法有优化。
    public int movingCount(int m, int n, int k) {
        boolean[][] temp = new boolean[m][n];
        return check(temp, 0, 0, k);
    }

    private int check(boolean[][] temp, int x, int y, int k) {
        // 越界或已访问过或不满足条件，则返回0
        if (x >= temp.length || y >= temp[x].length || temp[x][y] || getSum(x) + getSum(y) > k) {
            return 0;
        }
        // 记录已访问状态
        temp[x][y] = true;
        // 总数加1,再计算右移和下移情况下的数量并相加
        return 1 + check(temp, x + 1, y, k) + check(temp, x, y + 1, k);
    }

    /**
     * 获取一个数各位数之和
     * @param num 任意数字
     * @return 各位数之和
     */
    private int getSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
