package com.cshawn.codes.leetcodes.everyday;

/**
 * 有效数字
 * 有效数字（按顺序）可以分成以下几个部分：
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 *
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/6/17 9:21 下午
 */
public class Q65 {
    private final int init = 0;
    private final int operator = 1;
    private final int intValue = 2;
    private final int dot = 3;
    private final int floatValue = 4;
    private final int e = 5;
    private final int eOperator = 6;
    private final int eValue = 7;
    private int status = init;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }
        for (int i = 0; i < s.length(); i++) {
            if(!change(s, i)) {
                return false;
            }
        }
        if (status == dot) {
            char c = s.charAt(s.length() - 2);
            return c >= '0' && c <= '9';
        }
        return status == intValue || status == floatValue || status == eValue;
    }

    private boolean change(String s, int i) {
        char c = s.charAt(i);
        switch (status) {
            case init:
                if (c == '+' || c == '-') {
                    status = operator;
                } else if (c >= '0' && c <= '9') {
                    status = intValue;
                } else if (c == '.') {
                    status = dot;
                } else {
                    return false;
                }
                break;
            case operator:
                if (c >= '0' && c <= '9') {
                    status = intValue;
                } else if (c == '.') {
                    status = dot;
                } else {
                    return false;
                }
                break;
            case intValue:
                if (c == '.') {
                    status = dot;
                } else if (c == 'e' || c == 'E') {
                    status = e;
                } else if (!(c >= '0' && c <= '9')){
                    return false;
                }
                break;
            case dot:
                if(c >= '0' && c <= '9') {
                    status = floatValue;
                } else if ((c == 'e' || c == 'E') && i >= 2 && s.charAt(i - 2) >= '0' && s.charAt(i - 2) <= '9') {
                    status = e;
                } else {
                    return false;
                }
                break;
            case floatValue:
                if (c == 'e' || c == 'E') {
                    status = e;
                } else if (!(c >= '0' && c <= '9')){
                    return false;
                }
                break;
            case e:
                if(c == '+' || c == '-') {
                    status = eOperator;
                } else if (c >= '0' && c <= '9'){
                    status = eValue;
                } else {
                    return false;
                }
                break;
            case eOperator:
                if (c >= '0' && c <= '9'){
                    status = eValue;
                } else {
                    return false;
                }
                break;
            case eValue:
                if (!(c >= '0' && c <= '9')) {
                    return false;
                }
                break;
        }
        return true;
    }
}
