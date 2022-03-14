/**
两个列表的最小索引总和
假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 
示例 1:
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。

示例 2:
输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。


提示:
1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30 
list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
list1 的所有字符串都是 唯一 的。
list2 中的所有字符串都是 唯一 的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

use std::collections::HashMap;

pub struct Q599{}
impl Q599 {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        let shorter: Vec<String>;
        let longer: Vec<String>;
        if list1.len() < list2.len() {
            shorter = list1;
            longer = list2;
        } else {
            shorter = list2;
            longer = list1;
        }
        let mut map = HashMap::new();
        for i in 0..shorter.len() {
            map.insert(&shorter[i], i);
        }
        let mut max = i32::MAX;
        let mut res: Vec<String> = Vec::new();
        for i in 0..longer.len() {
            let value = map.get(&longer[i]);
            if let Some(index) = value {
                let cur = (index + i) as i32;
                if cur < max {
                    max = cur;
                    res = Vec::new();
                    res.push(longer[i].to_string());
                } else if cur == max {
                    res.push(longer[i].to_string());
                }
            }
        }
        res
    }
}

#[test]
pub fn test_find_restaurant() {
    assert_eq!(Q599::find_restaurant(vec!["Shogun".to_string(), "Tapioca Express".to_string(), "Burger King".to_string(), "KFC".to_string()],
        vec!["Piatti".to_string(), "The Grill at Torrey Pines".to_string(), "Hungry Hunter Steakhouse".to_string(), "Shogun".to_string()]), vec!["Shogun".to_string()]);
    assert_eq!(Q599::find_restaurant(vec!["Shogun".to_string(), "Tapioca Express".to_string(), "Burger King".to_string(), "KFC".to_string()],
        vec!["KFC".to_string(), "Shogun".to_string(), "Burger King".to_string()]), vec!["Shogun".to_string()]);
}