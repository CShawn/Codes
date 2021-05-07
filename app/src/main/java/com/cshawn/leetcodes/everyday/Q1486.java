package com.cshawn.leetcodes.everyday;

/**
 * 数组异或操作
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * 示例 1：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 * 示例 2：
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * 示例 3：
 * 输入：n = 1, start = 7
 * 输出：7
 *
 * 示例 4：
 * 输入：n = 10, start = 5
 * 输出：2
 * 提示：
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/7 11:17 上午
 */
public class Q1486 {
    public int xorOperation1(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }

    // 方法2：数学运算
    // start⊕(start+2i)⊕(start+4i)⊕⋯⊕(start+2(n−1))
    // 令s=start/2,那么：(s⊕(s+1)⊕(s+2)⊕⋯⊕(s+n−1))×2+e，其中e表示运算结果的最后一位bit值
    // 做上述运算是为了凑数：4i⊕(4i+1)⊕(4i+2)⊕(4i+3)=0
    // 又因为x⊕y⊕y=x，那么令s⊕(s+1)⊕(s+2)⊕⋯⊕(s+n−1)=x, (0^1^2^3^...^s-1) = y
    // 则原式子等同于(0^1^2^3^...^s-1)^(0^1^2^3^...^s-1^s^(s+1)^(s+2)^⋯^(s+n−1))
    // 函数sumXor(n)=0^1^2^3^...^n，则原式=(sumXor(s−1)⊕sumXor(s+n−1))×2+e
    // 当x=4k，sumXor= x,
    // 当x=4k+1，sumXor=(x−1)⊕x= 1,
    // 当x=4k+2，sumXor=(x−2)⊕(x−1)⊕x= x+1,
    // 当x=4k+3，sumXor=(x−3)⊕(x−2)⊕(x−1)⊕x= 0,
    // 对于计算的最后一位bit,2*i为偶数，那么最后一位取决于start和n的奇偶性，
    // strat为偶数或start为奇数时n为偶数，这两种情况下e为0，其他e为1, e = n & start & 1
    public int xorOperation(int n, int start) {
        int s = start >> 1;
        int last = n & start & 1;
        int pre = sumXor(s - 1) ^ sumXor(s + n - 1);
        return pre << 1 | last;
    }

    private int sumXor(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            default: 
                return 0;
        }
    }
}
