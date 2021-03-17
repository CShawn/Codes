package com.cshawn.leetcodes.crack;

/**
 * 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * 示例 1：
 * 输入: num = 1775(110111011112)
 * 输出: 8
 *
 * 示例 2：
 * 输入: num = 7(01112)
 * 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/17 11:15 下午
 */
public class Q5_3 {
    // 右移判断连续1的个数，遇到0时将
    public int reverseBits(int num) {
        // 结果
        int result = 0;
        // 上一段连续1的个数
        int preCount = 0;
        // 当前连续1的个数
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
                result = Math.max(result, count);
            } else {
                result = Math.max(result, preCount + count);
                preCount = count;
                count = 0;
            }
            num >>>= 1;
        }
        result = Math.max(result, preCount + count);
        return result < 32 ? result + 1 : result;
    }
}
