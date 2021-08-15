package com.cshawn.codes.leetcodes.crack;

/**
 * 插入
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 * 示例1:
 *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 *  输出：N = 1100(10001001100)
 *
 * 示例2:
 *  输入： N = 0, M = 31(11111), i = 0, j = 4
 *  输出：N = 31(11111)
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/17 10:08 下午
 */
public class Q5_1 {
    // 将N的i~j变为0，再与M<<i相或
    public int insertBits(int N, int M, int i, int j) {
        // 得到j-i+1位的1，左移到i位，再取反得到i~j位的0
        int mask = ~(((1 << (j - i + 1)) - 1) << i);
        N &= mask;
        return N | (M << i);
    }
}
