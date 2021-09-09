package com.cshawn.codes.leetcodes.everyday;

import java.util.LinkedList;
import java.util.List;

/**
 * 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 示例 1:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 *
 * 示例 3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/9/9 8:36 上午
 */
public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < words.length) {
            sb.setLength(0);
            int start = index;
            int len = 0;
            while (index < words.length) {
                int append = len + words[index].length() + index - start;
                if (append <= maxWidth) {
                    len += words[index++].length();
                    // 最后一行
                    if (index == words.length) {
                        for (int i = start; i < index; i++) {
                            sb.append(words[i]).append(' ');
                        }
                        if (sb.length() > maxWidth) {
                            sb.setLength(maxWidth);
                        } else {
                            for (int i = sb.length(); i < maxWidth; i++) {
                                sb.append(' ');
                            }
                        }
                        result.add(sb.toString());
                    }
                } else {
                    int gap = index - start - 1;
                    // 当前行只有一个单词
                    if (gap == 0) {
                        sb.append(words[start]);
                        for (int i = sb.length(); i < maxWidth; i++) {
                            sb.append(' ');
                        }
                    } else {
                        int space = maxWidth - len;
                        int average = space / gap;
                        int remain = space % gap;
                        for (int i = start; i < index - 1; i++) {
                            sb.append(words[start++]);
                            for (int j = 0; j < average; j++) {
                                sb.append(' ');
                            }
                            if (remain-- > 0) {
                                sb.append(' ');
                            }
                        }
                        sb.append(words[start]);
                    }
                    result.add(sb.toString());
                    break;
                }
            }
        }
        return result;
    }
}
