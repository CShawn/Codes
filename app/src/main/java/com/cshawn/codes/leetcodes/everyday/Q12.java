package com.cshawn.codes.leetcodes.everyday;

/**
 * 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 提示：1 <= num <= 3999
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/5/14 9:10 下午
 */
public class Q12 {
    // 方法1：除法，取余
    public String intToRoman1(int num) {
        char[] value = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (num != 0) {
            int last = num % 10;
            if (last != 0) {
                if (last < 4) {
                    for (int i = 0; i < last; i++) {
                        sb.insert(0, value[cur]);
                    }
                } else if (last == 4) {
                    sb.insert(0, value[cur + 1]).insert(0, value[cur]);
                } else if (last == 9) {
                    sb.insert(0, value[cur + 2]).insert(0, value[cur]);
                } else {
                    for (int i = 0; i < last - 5; i++) {
                        sb.insert(0, value[cur]);
                    }
                    sb.insert(0, value[cur + 1]);
                }
            }
            num /= 10;
            cur += 2;
        }
        return sb.toString();
    }

    // 方法2：减法
    public String intToRoman(int num) {
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                sb.append(str[i]);
                num -= value[i];
            }
        }
        return sb.toString();
    }
}