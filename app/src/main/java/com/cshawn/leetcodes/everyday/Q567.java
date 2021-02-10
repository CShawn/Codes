package com.cshawn.leetcodes.everyday;

/**
 * 字符串的排列
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/10 10:06 上午
 */
public class Q567 {
    // 滑动窗口，哈希表
    // 使用哈希表存储每个字符出现的数量，因只包含小写字母，可以使用26长度的数组来优化
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null) {
            return true;
        }
        if (s2 == null) {
            return false;
        }
        if (s1.isEmpty()) {
            return true;
        }
        // 字符串长度在[1, 10000]之间，不需要判空
        int[] target = new int[26];
        int[] match = new int[26];
        // 初始化要匹配的目标字符集
        for (int i = 0; i < s1.length(); i++) {
            target[s1.charAt(i) - 'a']++;
        }
        int matchs = 0;
        // 定义左右指针，结果数据
        int left = 0, right = 0;
        while (right < s2.length()) {
            int c = s2.charAt(right) - 'a';
            if (target[c] == 0) {
                // s1中不包含当前字符，则重新开始，清空之前的匹配情况
                matchs = 0;
                for (int i = left; i < right; i++) {
                    match[s2.charAt(i) - 'a'] = 0;
                }
                // right右移，left=right
                right++;
                left = right;
            } else {
                // s1中包含当前字符
                // 累加当前字符的个数
                match[c]++;
                // 累加总匹配字符数
                matchs++;
                if (match[c] > target[c]) {
                    // 当前字符个数大于目标时，从左侧不断删除字符
                    while (match[c] > target[c]) {
                        int ch = s2.charAt(left++) - 'a';
                        // 将字符个数减1
                        match[ch]--;
                        // 匹配个数减1
                        matchs--;
                    }
                }
                // right右移
                right++;
                // 当匹配到字符个数恰好与目标相等且当前滑动窗口长度与目标字符串长度相等时，则认为可以匹配
                if (matchs == s1.length() && right - left == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
