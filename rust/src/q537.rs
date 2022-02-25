/**
复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：

实部 是一个整数，取值范围是 [-100, 100]
虚部 也是一个整数，取值范围是 [-100, 100]
i2 == -1
给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。

示例 1：
输入：num1 = "1+1i", num2 = "1+1i"
输出："0+2i"
解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。

示例 2：
输入：num1 = "1+-1i", num2 = "1+-1i"
输出："0+-2i"
解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。

提示：num1 和 num2 都是有效的复数表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/complex-number-multiplication
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

pub struct Q537{}
impl Q537 {
    pub fn complex_number_multiply(num1: String, num2: String) -> String {
        let split1: Vec<&str> = num1.split('+').collect();
        let split2: Vec<&str> = num2.split('+').collect();
        let n1 = split1[0].parse::<i32>().unwrap();
        let n2 = split2[0].parse::<i32>().unwrap();
        let i1 = split1[1][0..split1[1].len()-1].parse::<i32>().unwrap();
        let i2 = split2[1][0..split2[1].len()-1].parse::<i32>().unwrap();
        (n1 * n2 + -1 * (i1 * i2)).to_string() + "+" + &(n1 * i2 + n2 * i1).to_string() + "i"
    }
}

#[test]
pub fn test_complex_number_multiply() {
    assert_eq!(Q537::complex_number_multiply(String::from("1+1i"), String::from("1+1i")), String::from("0+2i"));
    assert_eq!(Q537::complex_number_multiply(String::from("1+-1i"), String::from("1+-1i")), String::from("0+-2i"));
    assert_eq!(Q537::complex_number_multiply(String::from("1+0i"), String::from("1+0i")), String::from("1+0i"));
    assert_eq!(Q537::complex_number_multiply(String::from("1+-1i"), String::from("0+0i")), String::from("0+0i"));
    assert_eq!(Q537::complex_number_multiply(String::from("78+-76i"), String::from("-86+72i")), String::from("-1236+12152i"));
}