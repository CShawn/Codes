package com.cshawn.codes.leetcodes.everyday;

/**
 * 汉明距离总和
 * 两个整数的汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 * 输入: 4, 14, 2
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 注意:
 * 数组中元素的范围为从0到10^9。
 * 数组的长度不超过10^4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/28 3:10 下午
 */
public class Q477 {
    // 统计每位上1和0出现的个数，相乘即为该位上异或后1出现的次数，累加即得答案
    public int totalHammingDistance(int[] nums) {
        int result = 0, ones;
        for (int i = 0; i < 32; i++) {
            ones = 0;
            for (int num : nums) {
                ones += (num >> i) & 1;
            }
            result += ones * (nums.length - ones);
        }
        return result;
    }
}
