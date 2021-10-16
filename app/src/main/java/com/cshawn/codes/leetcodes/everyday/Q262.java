package com.cshawn.codes.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 给表达式添加运算符
 * 给定一个仅包含数字0-9的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、-或*，返回所有能够得到目标值的表达式。
 *
 * 示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"] 
 *
 * 示例2:
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 *
 * 示例 3:
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 *
 * 示例4:
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 *
 * 示例 5:
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 *
 * 提示：
 * 1 <= num.length <= 10
 * num 仅含数字
 * -231 <= target <= 231 - 1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/16 5:08 下午
 */
public class Q262 {
    // 回溯
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        backTracking(result, num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void backTracking(List<String> result, String num, int target, StringBuilder sb, int index, long value, long pre) {
        if (index == num.length()) {
            if (value == target) {
                result.add(sb.toString());
            }
            return;
        }
        int sign = sb.length();
        if (sign > 0) {
            // 为当前符号位占位
            sb.append(' ');
        }
        long res = 0;
        for (int i = index; i < num.length() && (i == index || num.charAt(index) != '0'); i++) {
            sb.append(num.charAt(i));
            res = res * 10 + num.charAt(i) - '0';
            if (index == 0) {
                backTracking(result, num, target, sb, i + 1, res, res);
            } else {
                sb.setCharAt(sign, '+');
                backTracking(result, num, target, sb, i + 1, value + res, res);
                sb.setCharAt(sign, '-');
                backTracking(result, num, target, sb, i + 1, value - res, -res);
                sb.setCharAt(sign, '*');
                backTracking(result, num, target, sb, i + 1, value - pre + pre * res, pre * res);
            }
        }
        sb.setLength(sign);
    }
}
