/**
七进制数
给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。

示例 1:
输入: num = 100
输出: "202"

示例 2:
输入: num = -7
输出: "-10"

提示：-107 <= num <= 107

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/base-7
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
pub struct Q504{}
impl Q504 {
    pub fn convert_to_base7(num: i32) -> String {
        if num == 0 {
            return "0".to_string();
        }
        let mut res = String::new();
        let mut n = num;
        if num < 0 {
            n = -num;
        }
        while n >= 7 {
            res += &(n%7).to_string();
            n /= 7;
        }
        if n !=0 {
            res += &n.to_string();
        }
        res = res.chars().rev().collect();
        if num < 0 {
            res = "-".to_string()+&res;
        }
        res
    }
}

#[test]
pub fn test_convert_to_base7() {
    assert_eq!(Q504::convert_to_base7(100, "202"));
    assert_eq!(Q504::convert_to_base7(-7, "-10"));
    assert_eq!(Q504::convert_to_base7(0, "0"));
}