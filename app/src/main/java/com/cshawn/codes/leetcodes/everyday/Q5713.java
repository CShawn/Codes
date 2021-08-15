package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同整数的数目
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
 *
 * 示例 1：
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 *
 * 示例 2：
 * 输入：word = "leet1234code234"
 * 输出：2
 *
 * 示例 3：
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * 提示：
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 * @author C.Shawn
 * @date 2021/3/28 11:23 上午
 */
public class Q5713 {
    public int numDifferentIntegers(String word) {
        char[] arr = word.toCharArray();
        Set<Integer> set = new HashSet<>();
        int num;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                num = 0;
                while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                set.add(num);
            }
        }
        return set.size();
    }
}
