package com.cshawn.leetcodes.everyday;

/**
 * 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例 1：
 * 输入：n = 13
 * 输出：6
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 提示：0 <= n <= 2 * 109
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/13 4:10 下午
 */
public class Q233 {
    public int countDigitOne(int n) {
        int result = 0, temp = n, power = 1;
        while (temp != 0) {
            int next = power * 10;
            int cur = n % next / power;
            int before = n / next;
            int after = n % power;
            if (cur == 0) {
                result += before * power;
            } else if (cur == 1) {
                result += before * power + after + 1;
            } else {
                result += (before + 1) * power;
            }
            power = next;
            temp /= 10;
        }
        return result;
    }
}
