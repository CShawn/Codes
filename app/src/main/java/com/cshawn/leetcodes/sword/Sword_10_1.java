package com.cshawn.leetcodes.sword;

/**
 * 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * 提示：0 <= n <= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/18 21:56
 */
public class Sword_10_1 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // 定义n-1和n-2两个值用于临时存储
        int n_2 = 0;
        int n_1 = 1; 
        int sum = 0;
        // 自底向上，将邻近的n-1和n-2保存起来
        for (int i = 2; i <= n; i++) {
            // 先计算n-1和n-2的和
            sum = (n_1 + n_2) % 1000000007;
            // 更新n-2为之前的n-1
            n_2 = n_1;
            // 更新n-1为新的sum
            n_1 = sum;
        }
        return sum;
    }
}
