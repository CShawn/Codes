package com.cshawn.codes.leetcodes.everyday;

/**
 * 好因子的最大数目
 * 给你一个正整数 primeFactors 。你需要构造一个正整数 n ，它满足以下条件：
 * n 质因数（质因数需要考虑重复的情况）的数目 不超过 primeFactors 个。
 * n 好因子的数目最大化。如果 n 的一个因子可以被 n 的每一个质因数整除，我们称这个因子是 好因子 。
 * 比方说，如果 n = 12 ，那么它的质因数为 [2,2,3] ，那么 6 和 12 是好因子，但 3 和 4 不是。
 * 请你返回 n 的好因子的数目。由于答案可能会很大，请返回答案对 109 + 7 取余 的结果。
 * 请注意，一个质数的定义是大于 1 ，且不能被分解为两个小于该数的自然数相乘。
 * 一个数 n 的质因子是将 n 分解为若干个质因子，且它们的乘积为 n 。
 *
 * 示例 1：
 * 输入：primeFactors = 5
 * 输出：6
 * 解释：200 是一个可行的 n 。
 * 它有 5 个质因子：[2,2,2,5,5] ，且有 6 个好因子：[10,20,40,50,100,200] 。
 * 不存在别的 n 有至多 5 个质因子，且同时有更多的好因子。
 *
 * 示例 2：
 * 输入：primeFactors = 8
 * 输出：18
 * 提示：1 <= primeFactors <= 109
 * @author C.Shawn
 * @date 2021/3/28 11:22 上午
 */
public class Q5716 {
    //一个数字可以被分解为 p1^k1 * p2^k2 * p3^k3 * ... * pn^kn
    // 其中 p1,p2,p3,...,pn 均为不同的质数
    // 那么它的好因子数量为 k1 * k2 * k3 * ... * kn
    // 根据题意，k1 + k2 + k3 + ... + kn = primeFactors
    // 在和一定的情况下，令积最大，就要尽可能地 3 个 3 个地分割
    // 只有当最后剩下 4 的情况下，分成 2 * 2 比分成 3 * 1 更好
    // 思路参见Q343
    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors < 4) {
            return primeFactors;
        }
        int k = primeFactors / 3;
        int r = primeFactors % 3;
        if (r == 1) {
            return (int) (pow(3, k - 1) * 4L % 1000000007);
        } else if (r == 2) {
            return (int) (pow(3, k) * 2L % 1000000007);
        } else {
            return pow(3, k);
        }
    }

    private int pow(long n, long pow) {
        long result = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                result = (result * n) % 1000000007;
            }
            n = (n * n) % 1000000007;
            pow >>= 1;
        }
        return (int)result;
    }
}
