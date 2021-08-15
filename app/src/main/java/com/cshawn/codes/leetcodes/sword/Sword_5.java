package com.cshawn.codes.leetcodes.sword;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：0 <= s 的长度 <= 10000
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2020/11/15 19:04
 */
public class Sword_5 {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        // 创建新字符数组，长度为原长度3倍（%20为3个字符）
        char[] newStr = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) != ' ') {
                // 复制到新数组中
                newStr[index++] = s.charAt(i);
            } else {
                // 将紧接着的三个位置依次赋值为%20
                newStr[index++] = '%';
                newStr[index++] = '2';
                newStr[index++] = '0';
            }
        }
        return new String(newStr, 0, index);
    } 
}
