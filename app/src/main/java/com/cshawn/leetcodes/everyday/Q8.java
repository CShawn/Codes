package com.cshawn.leetcodes.everyday;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * 示例 1：
 * 输入：s = "  42"
 * 输出：42
 *
 * 示例 2：
 * 输入：s = "4193 with words"
 * 输出：4193
 *
 * 示例 3：
 * 输入：s = "words and 987"
 * 输出：0
 *
 * 示例 5：
 * 输入：s = "-91283472332"
 * 输出：-2147483648
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/15 6:04 下午
 */
public class Q8 {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        // 最大数/10
        int max = Integer.MAX_VALUE / 10;
        // 最大数最后一位
        int bit = Integer.MAX_VALUE % 10;
        boolean negative = false, in = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (in) {
                if (c >= '0' && c <= '9') {
                    // 正数超出范围或相等而尾数大
                    if (result > max
                            || (result == max && ((!negative && c - '0' > bit) ||
                            // 负数超出范围或相等而尾数大
                            (negative && c - '0' > bit + 1)))
                    ) {
                        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    result = result * 10 + c - '0';
                } else {
                    break;
                }
            } else {
                if (c == ' ') {
                    continue;
                }
                if (c == '-') {
                    negative = true;
                    in = true;
                } else if (c == '+') {
                    in = true;
                } else if (c >= '0' && c <= '9') {
                    in = true;
                    result = c - '0';
                } else {
                    break;
                }
            }
        }
        return negative ? -result : result;
    }
}
