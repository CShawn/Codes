package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/15 10:53 上午
 */
public class Q6 {
    public String convert1(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        // 计算每组循环的宽度
        int width = numRows + numRows - 2;
        char[][] c = new char[numRows][width * (s.length() / width + 1)];
        // 当前字符索引
        int index = 0;
        // 当前填充的列
        int col = 0;
        while (index < s.length()) {
            // 填充一列
            for (int i = 0; i < numRows && index < s.length(); i++) {
                c[i][col] = s.charAt(index++);
            }
            // 右移列
            col++;
            // 斜线填充
            for (int j = 0; j < numRows - 2 && index < s.length(); j++) {
                c[numRows - j - 2][col++] = s.charAt(index++);
            }
        }
        // 合并字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] != '\0') {
                    sb.append(c[i][j]);
                }
            }
        }
        return sb.toString();
    }

    // 方法2：直接拼接
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] c = new char[s.length()];
        int index = 0;
        // 计算每组循环的宽度
        int width = numRows + numRows - 2;
        // 填充第一行
        for (int i = 0; i < c.length && index < c.length; i += width) {
            c[index++] = s.charAt(i);
        }
        // 填充中间行
        for (int i = 1; i < numRows; i++) {
            // 每次跳跃至下一组
            for (int j = i; j < c.length; j += width) {
                c[index++] = s.charAt(j);
                // 当前行的斜线上的元素
                int k = j + (numRows - i - 1) * 2;
                if (k < c.length && k > j) {
                    c[index++] = s.charAt(k);
                }
            }
        }
        // 填充最后一行
        for (int i = numRows - 1; i < c.length && index < c.length; i += width) {
            c[index++] = s.charAt(i);
        }
        return new String(c);
    }
}
