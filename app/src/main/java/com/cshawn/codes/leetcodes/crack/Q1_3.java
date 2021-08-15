package com.cshawn.codes.leetcodes.crack;

/**
 * @author C.Shawn
 * @date 2021/2/22 10:56 下午
 */
public class Q1_3 {
    public String replaceSpaces1(String S, int length) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int end = Math.min(S.length(), length);
        // 结果字符串数组
        char[] result = new char[end * 3];
        // 新字符串的索引
        int index = 0;
        for (int i = 0; i < end; i++) {
            if (S.charAt(i) == ' ') {
                result[index++] = '%';
                result[index++] = '2';
                result[index++] = '0';
            } else {
                result[index++] = S.charAt(i);
            }
        }
        return new String(result, 0, index);
    }

    // 如果默认length<S.length()则可以倒序遍历
    public String replaceSpaces(String S, int length) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] result = S.toCharArray();
        // 有效字符串的结尾，全部字符串的结尾
        int i = length - 1, j = S.length() - 1;
        while (i >= 0) {
            if (S.charAt(i) == ' ') {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            } else {
                result[j--] = S.charAt(i);
            }
            i--;
        }
        return new String(result, j + 1, S.length() - j - 1);
    }
}
