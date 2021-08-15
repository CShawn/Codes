package com.cshawn.codes.leetcodes.everyday;

/**
 * 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/3 1:54 下午
 */
public class Q338 {
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        // i为幂
        for (int i = 0; 1 << i < result.length; i++) {
            // origin为2的i次幂，其二进制含1个1
            int origin = 1 << i;
            result[origin] = 1;
            for (int j = origin + 1; j < origin << 1 && j < result.length; j++) {
                // j - origin为离j最近的一个2次幂的距离，如6 = 4 + 2，其1的个数即为两个索引对应的值的和
                // 而result[origin]为1，故直接加1即可
                result[j] = result[j - origin] + 1;
            }
        }
        return result;
    }

    // x & (x - 1)可以将x的最低位上的1变为0，那么x的1的个数比x-1的1的个数多一个
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    // x为偶数时，末位为0，右移1位含1的个数不变，而相当于除2，其值在之前已计算
    // x为奇数，则为result[x/2]+1。综上，为result[x>>1]+x&1
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
