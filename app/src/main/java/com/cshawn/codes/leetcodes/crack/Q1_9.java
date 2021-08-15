package com.cshawn.codes.leetcodes.crack;

/**
 * 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：字符串长度在[0, 100000]范围内。
 * 说明:你能只调用一次检查子串的方法吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/24 8:18 下午
 */
public class Q1_9 {
    public boolean isFlipedString1(String s1, String s2) {
        // 为空或长度不等则不满足
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        // 在s1中查找s2第1个字符出现的位置
        int find = 0;
        // 分别指向两个字符串的指针
        int i = 0, j = 0;
        while (i < s1.length()) {
            // 在s1中查找s2第1个字符出现的位置
            while (find < s1.length() && s1.charAt(find) != s2.charAt(j)) {
                find++;
            }
            // 查找到末尾未匹配则不满足
            if (find == s1.length()) {
                return false;
            }
            // 向后移一位
            i = find + 1;
            j = 1;
            while (i < s1.length()) {
                // 两个字符不同，则从find向后重新匹配出现的位置
                if (s1.charAt(i) != s2.charAt(j)) {
                    // find向后移时，如果越界则不满足
                    if(++find == s1.length()) {
                        return false;
                    }
                    // 归零重新开始
                    i = 0;
                    j = 0;
                    break;
                }
                // 字符相同则同时后移
                i++;
                j++;
            }
        }
        // 匹配完反转的后部分字符串时，s1从头匹配s2的后半部分
        i = 0;
        while (i < find) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    // 优化方法1
    public boolean isFlipedString2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        // 在s1中查找s2第1个字符出现的位置
        int find = 0;
        // 分别指向两个字符串的指针
        int i = 0, j = 0;
        while (true) {
            // 在s1中查找s2第1个字符出现的位置
            while (find < s1.length() && s1.charAt(find) != s2.charAt(0)) {
                find++;
            }
            // 查找到末尾未匹配则不满足
            if (find == s1.length()) {
                return false;
            }
            // 向后移一位
            i = find + 1;
            j = 1;
            while (j < s2.length()) {
                // 两个字符不同，则从find向后重新匹配出现的位置
                if (s1.charAt(i % s1.length()) != s2.charAt(j)) {
                    find++;
                    // 归零重新开始
                    j = 0;
                    break;
                }
                // 字符相同则同时后移
                i++;
                j++;
            }
            if (j == s2.length()) {
                return true;
            }
        }
    }

    // 将s2扩展2倍，则s2中必包含s1
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }
}
