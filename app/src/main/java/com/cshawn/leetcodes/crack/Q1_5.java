package com.cshawn.leetcodes.crack;

/**
 * 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * @author C.Shawn
 * @date 2021/2/23 9:22 下午
 */
public class Q1_5 {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // 最大修改次数，定义为int，可适用于多次修改
        int max = 1;
        // 定义两个索引，分别为两个字符串的当前位置
        for (int index1 = 0, index2 = 0;
             index1 < first.length() && index2 < second.length();
        ) {
            // 不相同时
            if (first.charAt(index1) != second.charAt(index2)) {
                if (max > 0) {
                    max--;
                    if (first.length() < second.length()) {
                        // 1短则右移2
                        index2++;
                    } else if (first.length() > second.length()) {
                        // 2短则右移1
                        index1++;
                    } else {
                        // 等长则同时右移
                        index1++;
                        index2++;
                    }
                } else {
                    // 若已消耗完修改次数
                    return false;
                }
            } else {
                // 相同则同时右移
                index1++;
                index2++;
            }
        }
        return true;
    }
}
