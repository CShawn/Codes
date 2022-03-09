/**
仅仅反转字母
给你一个字符串 s ，根据下述规则反转字符串：
	所有非英文字母保留在原有位置。
	所有英文字母（小写或大写）位置反转。
返回反转后的 s 。

示例 1：
输入：s = "ab-cd"
输出："dc-ba"

示例 2：
输入：s = "a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"

示例 3：
输入：s = "Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"

提示
	1 <= s.length <= 100
	s 仅由 ASCII 值在范围 [33, 122] 的字符组成
	s 不含 '\"' 或 '\\'
*/

pub struct Q917{}
impl Q917 {
    pub fn reverse_only_letters(s: String) -> String {
        let mut chars: Vec<char> = s.chars().collect();
        let mut left = 0;
        let mut right = s.len() - 1;
        while left < right {
            if !chars[left].is_alphabetic() {
                left += 1;
                continue
            }
            if !chars[right].is_alphabetic() {
                right -= 1;
                continue
            }
            chars.swap(left, right);
            left += 1;
            right -= 1;
        }
        chars.into_iter().collect()
    }
}

#[test]
pub fn test_reverse_only_letters() {
    assert_eq!(Q917::reverse_only_letters(String::from("ab-cd")), "dc-ba");
    assert_eq!(Q917::reverse_only_letters(String::from("a-bC-dEf-ghIj")), "j-Ih-gfE-dCba");
    assert_eq!(Q917::reverse_only_letters(String::from("Test1ng-Leet=code-Q!")), "Qedo1ct-eeLg=ntse-T!");
}
