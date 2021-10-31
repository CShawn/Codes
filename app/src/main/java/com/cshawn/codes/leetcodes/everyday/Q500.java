package com.cshawn.codes.leetcodes.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/10/31 10:56 上午
 */
public class Q500 {
    private String[] lines = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    private int[] maps = new int[3];

    public String[] findWords1(String[] words) {
        initMap();
        List<String> list = new ArrayList<>(words.length);
        for (String word : words) {
            String w = word.toLowerCase();
            int flag = 1 << word.charAt(0) - 'a';
            int target = 0;
            for (int map : maps) {
                if ((map & flag) != 0) {
                    target = map;
                    break;
                }
            }
            boolean match = true;
            for (int i = 1; i < w.length(); i++) {
                flag = 1 << word.charAt(i) - 'a';
                if ((flag & target) == 0) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    private void initMap() {
        if (maps[0] == 0) {
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                for (int j = 0; j < line.length(); j++) {
                    maps[i] |= 1 << line.charAt(j) - 'a';
                }
            }
        }
    }

    // 记录每个字符对应的行号
    private int[] lineMap = new int[26];
    public String[] findWords(String[] words) {
        initLineMap();
        List<String> list = new ArrayList<>(words.length);
        for (String word : words) {
            String w = word.toLowerCase();
            int line = lineMap[w.charAt(0) - 'a'];
            boolean match = true;
            for (int i = 1; i < w.length(); i++) {
                if (lineMap[w.charAt(i) - 'a'] != line) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    private void initLineMap() {
        if (lineMap[0] == 0) {
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                for (int j = 0; j < line.length(); j++) {
                    lineMap[line.charAt(j) - 'a'] = i;
                }
            }
        }
    }
}