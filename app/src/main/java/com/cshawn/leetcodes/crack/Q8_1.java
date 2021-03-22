package com.cshawn.leetcodes.crack;

/**
 * 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 示例2:
 *  输入：n = 5
 *  输出：13
 * 提示:n范围在[1, 1000000]之间
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/21 10:07 下午
 */
public class Q8_1 {
    // 到达当前台阶可以从前一个或前两个或前三个台阶一步上来，显然是个斐波那契数列
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int n_3 = 1, n_2 = 2, n_1 = 4, sum = 0;
        for (int i = 4; i <= n; i++) {
            sum = ((n_3 + n_2) % 1000000007 + n_1) % 1000000007;
            n_3 = n_2;
            n_2 = n_1;
            n_1 = sum;
        }
        return sum;
    }
}
