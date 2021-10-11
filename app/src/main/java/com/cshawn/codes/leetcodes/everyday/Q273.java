package com.cshawn.codes.leetcodes.everyday;

/**
 * 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 *
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 *
 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 *
 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * 示例 4：
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * 提示：0 <= num <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/11 8:15 上午
 */
public class Q273 {
    private final String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    private final String hundred = "Hundred";
    public String numberToWords1(int num) {
        if (num == 0) {
            return "Zero";
        }
        String str = String.valueOf(num);
        int len = str.length();
        int split = (len - 1) / 3;
        int last = len % 3;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = split; i >= 0; i--) {
            int count = i == split ? last : 0;
            int c = str.charAt(index++) - '0';
            boolean allZero = c == 0;
            if (count == 0) {
                if (c != 0) {
                    sb.append(singles[c]).append(' ').append(hundred).append(' ');
                }
                count = 2;
                c = str.charAt(index++) - '0';
                if (allZero && c != 0) {
                    allZero = false;
                }
            }
            if (count == 2) {
                if (c == 1) {
                    sb.append(teens[str.charAt(index++) - '0']).append(' ');
                } else {
                    if (c != 0) {
                        sb.append(tens[c]).append(' ');
                    }
                    int n = str.charAt(index++) - '0';
                    if (n != 0) {
                        allZero = false;
                        sb.append(singles[n]).append(' ');
                    }
                }
            } else if (c != 0) {
                if (allZero) {
                    allZero = false;
                }
                sb.append(singles[c]).append(' ');
            }
            if (!allZero) {
                sb.append(thousands[i]).append(' ');
            }
        }
        return sb.toString().trim();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int p = 3;
        int power = 1000_000_000;
        while (power > 0) {
            convert(num / power, sb, p--);
            num %= power;
            power /= 1000;
        }
        return sb.toString().trim();
    }

    private void convert(int num, StringBuilder sb, int p) {
        if (num == 0) {
            return;
        }
        if (num > 99) {
            sb.append(singles[num / 100]).append(' ').append(hundred).append(' ');
            num %= 100;
        }
        if (num > 19) {
            sb.append(tens[num / 10]).append(' ');
            num %= 10;
        }
        if (num > 9) {
            sb.append(teens[num % 10]).append(' ');
        } else if (num != 0) {
            sb.append(singles[num]).append(' ');
        }
        sb.append(thousands[p]).append(' ');
    }
}