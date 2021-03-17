package com.cshawn.leetcodes.crack;

/**
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
