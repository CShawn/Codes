package com.cshawn.codes.leetcodes.everyday;

import java.util.Arrays;

/**
 * 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 *
 * 示例 2：
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 *
 * 示例 3：
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 * 提示：
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/4/16 9:27 下午
 */
public class Q87 {
    // memo[x][y][z]表示s1从x开始，s2从y开始，长度为z的子串是否匹配：匹配为1，不匹配为-1，未计算为0
    private byte[][][] memo;
    private String s1, s2;
    // 用于当作map存储字符
    private byte[] map;

    // 记忆化搜索
    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        memo = new byte[s1.length()][s2.length()][s2.length() + 1];
        map = new byte[26];
        return dfs(0, 0, s1.length());
    }

    // 递归判断各种情况
    private boolean dfs(int i, int j, int length) {
        // 此i,j,length已计算过时，直接记录的值是否匹配
        if (memo[i][j][length] != 0) {
            return memo[i][j][length] == 1;
        }
        // 两个子串相同时，直接返回匹配
        if (s1.substring(i, i + length).equals(s2.substring(j, j + length))) {
            memo[i][j][length] = 1;
            return true;
        }
        // 当两个子串中包含的字符个数不同时，返回不匹配
        if (!charactersSame(i, j, length)) {
            memo[i][j][length] = -1;
            return false;
        }
        // 对子串进行再次分割，选择子串要分割的长度为k
        for (int k = 1; k < length; k++) {
            // 不交换，分割左侧为长度为k的子串
            if (dfs(i, j, k) && dfs(i + k, j + k, length - k)) {
                memo[i][j][length] = 1;
                return true;
            }
            // 交换，分割s1左侧为长度为k的子串，s2右侧为长度为k的子串，判断左右两侧交换后是否匹配
            if (dfs(i, j + length - k, k) && dfs(i + k, j, length - k)) {
                memo[i][j][length] = 1;
                return true;
            }
        }
        // 若不匹配则记录并返回
        memo[i][j][length] = -1;
        return false;
    }

    // 判断s1从i开始，s2从j开始，长度为length的子串是否包含相同个数的字符
    private boolean charactersSame(int i, int j, int length) {
        Arrays.fill(map, (byte)0);
        for (int k = 0; k < length; k++) {
            map[s1.charAt(i + k) - 'a']++;
        }
        for (int k = 0; k < length; k++) {
            map[s2.charAt(j + k) - 'a']--;
        }
        for (int k = 0; k < map.length; k++) {
            if (map[k] != 0) {
                return false;
            }
        }
        return true;
    }
}
