package com.cshawn.codes.leetcodes.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 *
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * 提示：元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/8/19 8:39 上午
 */
public class Q345 {
    public String reverseVowels1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        Set<Character> goals = new HashSet<>();
        goals.add('a');
        goals.add('e');
        goals.add('i');
        goals.add('o');
        goals.add('u');
        goals.add('A');
        goals.add('E');
        goals.add('I');
        goals.add('O');
        goals.add('U');
        int left = 0, right = s.length() - 1;
        char temp;
        while (left < right) {
            char a = arr[left];
            char b = arr[right];
            if (!goals.contains(a)) {
                left++;
                continue;
            }
            if (!goals.contains(b)) {
                right--;
                continue;
            }
            if (a != b) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            left++;
            right--;
        }
        return new String(arr);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> goals = new HashSet<>();
        goals.add('a');
        goals.add('e');
        goals.add('i');
        goals.add('o');
        goals.add('u');
        goals.add('A');
        goals.add('E');
        goals.add('I');
        goals.add('O');
        goals.add('U');
        char[] result = new char[s.length()];
        int left = 0, right = s.length() - 1;
        char a, b;
        while (left <= right) {
            a = s.charAt(left);
            b = s.charAt(right);
            if (!goals.contains(a)) {
                result[left++] = a;
            } else if (!goals.contains(b)) {
                result[right--] = b;
            } else {
                result[left++] = b;
                result[right--] = a;
            }
        }
        return new String(result);
    }
}