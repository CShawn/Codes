package com.cshawn.leetcodes.sword;
/**
 * 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：2 <= n <= 58
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/23 23:19
 */
public class Sword_14_2 {
    /**
     * 很明显，用动态规划遇到大数已经不能进行，可以考虑贪心算法，每次都分成局部最大积。
     * 那么，需要尽量将数字拆分成2和3。
     * 可以这么理解：2和3是最小的两个素数，无法再拆分，比它们大的数都可以拆分成2和3。
     * 当然也可以通过数学推导https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
     * 可知，尽量分成3段来达到最大值。
     */
    int cuttingRope(int n) {
        int mod = 1000000007;
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // 求余数，按3分剩余多少
        int left = n % 3;
        int count = n / 3;
        if (left == 1) {
            return (int) (pow(3, count - 1) * 4 % mod);
        } else if(left == 2) {
            return (int) (pow(3, count) * 2 % mod);
        } else {
            return (int) (pow(3, count) % mod);
        }
    }

    private long pow(int n, int t) {
        long pow = 1;
        for (int i = 0; i < t; i++) {
            pow = n * pow % 1000000007;
        }
        return pow;
    }
}
