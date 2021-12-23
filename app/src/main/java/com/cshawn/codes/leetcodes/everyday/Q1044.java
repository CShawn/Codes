package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 最长重复子串
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 *
 * 示例 1：
 * 输入：s = "banana"
 * 输出："ana"
 *
 * 示例 2：
 * 输入：s = "abcd"
 * 输出：""
 *
 * 提示：
 * 2 <= s.length <= 3 * 104
 * s 由小写英文字母组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/12/23 9:03 上午
 */
public class Q1044 {
    // Rabin-Karp算法 + 二分查找 + 快速幂
    public String longestDupSubstring(String s) {
        Random random = new Random();
        // 生成两个进制
        int a1 = random.nextInt(75) + 26;
        int a2 = random.nextInt(75) + 26;
        // 生成两个模
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        // [出现的位置，长度]
        int[] res = binarySearch(arr, a1, a2, mod1, mod2);
        return res[0] != -1 ? s.substring(res[0], res[0] + res[1]): "";
    }

    private int[] binarySearch(int[] arr, int a1, int a2, int mod1, int mod2) {
        int left = 1, right = arr.length - 1, mid, len = 1, index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            int found = rabinKarp(arr, mid, a1, a2, mod1, mod2);
            if (found == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
                index = found;
                len = mid;
            }
        }
        return new int[]{index, len};
    }

    // Rabin-Karp算法，双哈希来保证哈希冲突
    private int rabinKarp(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        long base1 = pow(a1, m - 1, mod1);
        long base2 = pow(a2, m - 1, mod2);
        long h1 = 0, h2 = 0;
        for (int i = 0; i < m; i++) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1;
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        Set<Long> visited = new HashSet<>();
        visited.add(h1 * mod2 + h2);
        for (int i = 1; i <= arr.length - m; i++) {
            h1 = ((h1 - arr[i - 1] * base1 % mod1) * a1 % mod1 + arr[i + m - 1]) % mod1;
            h2 = ((h2 - arr[i - 1] * base2 % mod2) * a2 % mod2 + arr[i + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
            long cur = h1 * mod2 + h2;
            if (visited.contains(cur)) {
                return i;
            }
            visited.add(cur);
        }
        return -1;
    }

    // a ^ m % mod
    private long pow(long a, int m, int mod) {
        long res = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = res * a % mod;
                if (res < 0) {
                    res += mod;
                }
            }
            a = a * a % mod;
            if (a < 0) {
                a += mod;
            }
            m >>= 1;
        }
        return res;
    }
}
