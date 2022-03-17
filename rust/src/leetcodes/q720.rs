/**
词典中最长的单词
给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。

示例 1：
输入：words = ["w","wo","wor","worl", "world"]
输出："world"
解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。

示例 2：
输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 

提示：
1 <= words.length <= 1000
1 <= words[i].length <= 30
所有输入的字符串 words[i] 都只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
use std::collections::HashSet;
use std::cmp::Ordering::Equal;

pub struct Q720{}
impl Q720 {
    pub fn longest_word(mut words: Vec<String>) -> String {
        let mut longest = String::new();
        words.sort_by(|a, b| {
            let c = a.len().cmp(&b.len());
            if c == Equal {
                b.cmp(a)
            } else {
                c
            }
        });
        let mut set: HashSet<String> = HashSet::new();
        set.insert(String::new());
        for word in words {
            if set.contains(&word[0..word.len()-1]) && word.len() >= longest.len() {
                longest = word.to_string();
                set.insert(word.to_string());
            }
        }
        longest
    }
}

#[test]
pub fn test_longest_word() {
    assert_eq!(Q720::longest_word(vec!["w".to_string(),"wo".to_string(),"wor".to_string(),"worl".to_string(), "world".to_string()]), "world".to_string());
    assert_eq!(Q720::longest_word(vec!["a".to_string(), "banana".to_string(), "app".to_string(), "appl".to_string(), "ap".to_string(), "apply".to_string(), "apple".to_string()]), "apple".to_string());
}