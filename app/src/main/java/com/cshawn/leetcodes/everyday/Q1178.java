package com.cshawn.leetcodes.everyday;

import java.util.*;

/**
 * 猜字谜
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 * 示例：
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"], 
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa" 
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *  
 * 提示：
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/26 5:15 下午
 */
public class Q1178 {
    // 将字符串处理为boolean[26]数组，数据过大时直接超时
    public List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>(puzzles.length);
        // 处理words
        boolean[][] wordChars = new boolean[words.length][];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            wordChars[i] = new boolean[26];
            for (int j = 0; j < word.length(); j++) {
                wordChars[i][word.charAt(j) - 'a'] = true;
            }
        }
        // 每次处理一个puzzle
        boolean[] puzzleChars = new boolean[26];
        for (String puzzle : puzzles) {
            Arrays.fill(puzzleChars, false);
            for (int i = 0; i < puzzle.length(); i++) {
                puzzleChars[puzzle.charAt(i) - 'a'] = true;
            }
            // puzzle的第一个字符
            int head = puzzle.charAt(0) - 'a';
            // 满足条件的个数
            int count = 0;
            for (boolean[] word : wordChars) {
                // 包含第一个字符
                if (word[head]) {
                    boolean match = true;
                    for (int i = 0; i < 26; i++) {
                        // word中的字符不在puzzle中则不满足条件
                        if (word[i] && !puzzleChars[i]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        count++;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    // 方法2：因方法1中数组长度<=26，可以转为bit，用一个int表示。将所有words转为int放入哈希表中。
    // 对于puzzle同理处理，即状态压缩。
    // 根据puzzle因要包括首个字符，所以必须先算上首个字符，加上剩余的字符的排列组合情况即为word，
    // 因此可以求出所有符合puzzle的words，在哈希表中查找对应数字
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>(puzzles.length);
        Map<Integer, Integer> wordSet = new HashMap<>();
        // 转换words
        for (String word : words) {
            int num = 0;
            for (int i = 0; i < word.length(); i++) {
                if (((num >> (word.charAt(i) - 'a')) & 1) == 0) {
                    // 将每个字符转为对应位置的1
                    num += 1 << (word.charAt(i) - 'a');
                }
            }
            wordSet.put(num, wordSet.getOrDefault(num, 0) + 1);
        }
        // 存储puzzle非首字符的字符
        Set<Integer> puzzleSet = new HashSet<>();
        Integer[] puzzleArray = new Integer[6];
        int count, end, matched;
        for (String puzzle : puzzles) {
            matched = 0;
            puzzleSet.clear();
            // puzzle对应的words为首字符转数字加上剩余字符的全排列对应数字
            int head = 1 << (puzzle.charAt(0) - 'a');
            for (int i = 1; i < puzzle.length(); i++) {
                if (puzzle.charAt(i) != puzzle.charAt(0)) {
                    puzzleSet.add(puzzle.charAt(i) - 'a');
                }
            }
            // 总共count个不同字符
            count = puzzleSet.size();
            puzzleSet.toArray(puzzleArray);
            // count个元素全排列有end个
            end = 1 << count;
            // 剩余的字符转为int总和
            int leftSum;
            // 利用二进制，将每位上的1对应到puzzleArray内字符位置即可得到全部排列
            for (int num = 0; num < end; num++) {
                leftSum = 0;
                // num为0~2^count-1，对应二进制最多count-1位
                for (int c = 0; c < count; c++) {
                    // 当数字右移c位为0，则不必再继续后移（都是0）
                    if (num >> c == 0) {
                        break;
                    }
                    // (num >> c) & 1相当于分别获取num二进制每位上的数字
                    if (((num >> c) & 1) != 0) {
                        // 当二进制为1时，需要使用此位，即puzzleArray倒数第c个位置上的1要使用
                        leftSum += 1 << puzzleArray[count - 1 - c];
                    }
                }
                // head + leftSum为一种排列方式
                if (wordSet.containsKey(head + leftSum)) {
                    matched += wordSet.get(head + leftSum);
                }
            }
            result.add(matched);
        }
        return result;
    }
}
