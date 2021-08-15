package com.cshawn.codes.leetcodes.everyday;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/20 9:00 下午
 */
public class Q28 {
    // 方法1：双指针
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean match = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 方法2：KPM算法
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }
        int j = 0, k = -1;
        // 用于存储needle中每个字符不匹配时，需要回退到的位置
        int[] next = new int[needle.length()];
        // 第一个字符不匹配，则需要取haystack下一个字符并重新匹配
        next[0] = -1;
        while (j < needle.length() - 1) {
            // 当j,k两个位置的字符相同时，j+1不匹配时，可倒退至k+1的位置
            // 因为[0,k]与[j-k,j]完全相同，可回退这部分，直接将haystack[i]与needle[k+1]进行对比，从而优化速度
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                next[++j] = ++k;
            } else {
                // 相当于两个字符串匹配时，匹配到k不相等，那么将k回退到其对应的位置，再看j与此位置元素是否相同并计算next[j]
                k = next[k];
            }
        }
        // 开始遍历匹配
        int m = 0, n = 0;
        while (m < haystack.length() && n < needle.length()) {
            // 当n为-1时，重新从头匹配
            if (n == -1 || haystack.charAt(m) == needle.charAt(n)) {
                m++;
                n++;
            } else {
                // 跳到n所对应的倒退位置
                n = next[n];
            }
        }
        return n == needle.length() ? m - n : -1;
    }
}
