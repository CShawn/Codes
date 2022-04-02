/**
二倍数对数组
给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。

示例 1：
输入：arr = [3,1,3,6]
输出：false

示例 2：
输入：arr = [2,1,2,6]
输出：false

示例 3：
输入：arr = [4,-2,2,-4]
输出：true
解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]

提示：
0 <= arr.length <= 3 * 104
arr.length 是偶数
-105 <= arr[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
struct Q954{}
impl Q954 {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        use std::collections::HashMap;
        let mut counter: HashMap<i32, i32> = HashMap::new();
        arr.iter().for_each(|elem| *counter.entry(*elem).or_insert(0) += 1);
        let zero = counter.get(&0).unwrap_or(&0);
        if zero & 1 == 1 {
            return false
        }
        let mut arr:Vec<i32> = counter.keys().map(|f| *f).collect();
        arr.sort_by_key(|a| a.abs());
        for num in arr {
            if counter.get(&(num<<1)).unwrap_or(&0) < counter.get(&num).unwrap() {
                return false;
            }
            counter.insert(num<<1, counter.get(&(num<<1)).unwrap_or(&0) - counter.get(&num).unwrap());
        }
        true
    }
}

#[test]
pub fn test_can_reorder_doubled() {
    assert_eq!(Q954::can_reorder_doubled(vec![3,1,3,6]), false);
    assert_eq!(Q954::can_reorder_doubled(vec![2,1,2,6]), false);
    assert_eq!(Q954::can_reorder_doubled(vec![4,-2,2,-4]), true);
    assert_eq!(Q954::can_reorder_doubled(vec![0,1,2,4]), false);
    assert_eq!(Q954::can_reorder_doubled(vec![0,0,2,4]), true);
}