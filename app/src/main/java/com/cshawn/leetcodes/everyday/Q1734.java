package com.cshawn.leetcodes.everyday;

/**
 * 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 * 示例 1：
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 *
 * 示例 2：
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 * 提示：
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/11 5:13 下午
 */
public class Q1734 {
    // 题中前 n 个正整数的排列，即1~n的数字排列
    // 所有数字异或，最终结果为1 ^ n
    // 因为每个数为原数组两两异或，中间的数都重复一次，将encoded隔一个数异或，最终结果为a1 ^ a(n-1)
    public int[] decode1(int[] encoded) {
        // 1~n异或的结果
        int all = 0;
        // a1~a(n-1)异或的结果
        int whitNoLast = encoded[0];
        for (int i = 1; i <= encoded.length + 1; i++) {
            all ^= i;
            if ((i & 1) == 0 && i < encoded.length) {
                whitNoLast ^= encoded[i];
            }
        }
        int[] result = new int[encoded.length + 1];
        // 得到最后一个元素的值
        result[encoded.length] = all ^ whitNoLast;
        // 依次得到每个元素的值
        for (int i = encoded.length - 1; i >= 0; i--) {
            result[i] = encoded[i] ^ result[i + 1];
        }
        return result;
    }

    public int[] decode(int[] encoded) {
        // 1~n异或的结果
        int all = 0;
        // a2~an异或的结果
        int whitNoFirst = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            all ^= i;
            if ((i & 1) == 1 && i < encoded.length) {
                whitNoFirst ^= encoded[i];
            }
        }
        int[] result = new int[encoded.length + 1];
        // 得到第一个元素的值
        result[0] = all ^ whitNoFirst;
        // 依次得到每个元素的值
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }
}
