package com.cshawn.codes.leetcodes.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 * 给定两个整数，分别表示分数的分子numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 *
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 *
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 *
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 *
 * 提示：
 * -231 <=numerator, denominator <= 231 - 1
 * denominator != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/3 11:40 上午
 */
public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (num % den == 0) {
            return String.valueOf(num / den);
        }
        StringBuilder sb = new StringBuilder();
        if (num < 0 ^ den < 0) {
            sb.append('-');
        }
        num = Math.abs(num);
        den = Math.abs(den);
        sb.append(num / den).append('.');
        int begin = sb.length();
        long remainder = num % den;
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0 && !map.containsKey(remainder)) {
            map.put(remainder, begin++);
            num = remainder * 10;
            sb.append(num / den);
            remainder = num % den;
        }
        if (remainder != 0) {
            begin = map.get(remainder);
            sb.insert(begin, '(');
            sb.append(')');
        }
        return sb.toString();
    }
}
