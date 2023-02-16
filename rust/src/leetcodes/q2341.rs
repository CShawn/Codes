/**
2341. 数组能形成多少数对
给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：

从 nums 选出 两个 相等的 整数
从 nums 中移除这两个整数，形成一个 数对
请你在 nums 上多次执行此操作直到无法继续执行。

返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。

 

示例 1：

输入：nums = [1,3,2,1,3,2,2]
输出：[3,1]
解释：
nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
示例 2：

输入：nums = [1,1]
输出：[1,0]
解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。
示例 3：

输入：nums = [0]
输出：[0,1]
解释：无法形成数对，nums 中剩下 1 个数字。
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-number-of-pairs-in-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
use std::collections::HashSet;

pub struct Q2341 {}
impl Q2341 {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        let mut res = vec![0i32;2];
        let mut set: HashSet<i32> = HashSet::new();
        for num in nums.iter() {
            if set.contains(num) {
                res[0] = res[0]+1;
                set.remove(num);
            } else {
                set.insert(*num);
            }
        }
        res[1] = set.len() as i32;
        res
    }
}

#[test]
pub fn test_number_of_pairs() {
    assert_eq!(Q2341::number_of_pairs(vec![1,3,2,1,3,2,2]), vec![3,1]);
    assert_eq!(Q2341::number_of_pairs(vec![1,1]), vec![1,0]);
}