/**
寻找比目标字母大的最小字母
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
在比较时，字母是依序循环出现的。举个例子：
如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'

示例 1：
输入: letters = ["c", "f", "j"]，target = "a"
输出: "c"

示例 2:
输入: letters = ["c","f","j"], target = "c"
输出: "f"

示例 3:
输入: letters = ["c","f","j"], target = "d"
输出: "f"
 
提示：
2 <= letters.length <= 104
letters[i] 是一个小写字母
letters 按非递减顺序排序
letters 最少包含两个不同的字母
target 是一个小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

struct Q744{}
impl Q744 {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        if target >= letters[letters.len() - 1] {
            return letters[0];
        }
        let mut left = 0;
        let mut right = letters.len() - 1;
        let mut mid;
        while left < right {
            mid = left + ((right - left) >> 1);
            if letters[mid] > target {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        letters[left]
    }
}

#[test]
pub fn test_next_greatest_letter() {
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'a'), 'c');
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'c'), 'f');
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'e'), 'f');
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'f'), 'j');
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'g'), 'j');
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'j'), 'c');
    assert_eq!(Q744::next_greatest_letter(vec!['c', 'f', 'j'], 'm'), 'c');
}