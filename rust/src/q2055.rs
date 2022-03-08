/**
蜡烛之间的盘子
给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。

同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。

比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。

示例 1:
输入：s = "**|**|***|", queries = [[2,5],[5,9]]
输出：[2,3]
解释：
- queries[0] 有两个盘子在蜡烛之间。
- queries[1] 有三个盘子在蜡烛之间。

示例 2:
输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
输出：[9,0,0,0,0]
解释：
- queries[0] 有 9 个盘子在蜡烛之间。
- 另一个查询没有盘子在蜡烛之间。
 
提示：
3 <= s.length <= 105
s 只包含字符 '*' 和 '|' 。
1 <= queries.length <= 105
queries[i].length == 2
0 <= lefti <= righti < s.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plates-between-candles
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
pub struct Q2055 {}
impl Q2055 {
    // 前缀和+双指针；超时
    pub fn plates_between_candles1(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let chars: Vec<char> = s.chars().collect();
        let mut prefix: Vec<i32> = vec![0;chars.len()+1];
        for i in 0..chars.len() {
            if chars[i] == '*' {
                prefix[i+1] = prefix[i]+1;
            } else {
                prefix[i+1] = prefix[i];
            }
        }
        let mut res: Vec<i32> = vec![0;queries.len()];
        for i in 0..queries.len() {
            let mut left = queries[i][0];
            let mut right = queries[i][1];
            while left <= right && chars[left as usize] != '|' {
                left+=1;
            }
            while left <= right && chars[right as usize] != '|' {
                right-=1;
            }
            if left != right {
                res[i] = prefix[(right as usize)+1]-prefix[left as usize];
            }
        }
        res
    }

    // 优化方法1
    pub fn plates_between_candles(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let chars: Vec<char> = s.chars().collect();
        let mut prefix: Vec<i32> = vec![0;chars.len()+1];
        let mut before: Vec<i32> = vec![0;chars.len()];
        let mut after: Vec<i32> = vec![0;chars.len()];
        let mut pre:i32 = -1;
        let mut sum = 0;
        for i in 0..chars.len() {
            if chars[i] == '*' {
                sum+=1;
            } else {
                pre = i as i32;
            }
            prefix[i]=sum;
            before[i]=pre;
        }
        pre = -1;
        for i in (0..chars.len()).rev() {
            if chars[i] == '|' {
                pre=i as i32;
            }
            after[i]=pre;
        }
        let mut res: Vec<i32> = vec![0;queries.len()];
        for i in 0..queries.len() {
            let left = queries[i][0] as usize;
            let right = queries[i][1] as usize;
            if after[left] != -1 && before[right] != -1 && after[left] < before[right] {
                res[i] = prefix[before[right] as usize]-prefix[after[left] as usize];
            }
        }
        res
    }
}

#[test]
pub fn test_plates_between_candles() {
    assert_eq!(Q2055::plates_between_candles1("**|**|***|", vec![vec![2,5],vec![5,9]]), vec![2,3]);
    assert_eq!(Q2055::plates_between_candles1("***|**|*****|**||**|*", vec![vec![1,17],vec![4,5],vec![14,17],vec![5,11], vec![15,16]]), vec![9,0,0,0,0]);

    assert_eq!(Q2055::plates_between_candles("**|**|***|", vec![vec![2,5],vec![5,9]]), vec![2,3]);
    assert_eq!(Q2055::plates_between_candles("***|**|*****|**||**|*", vec![vec![1,17],vec![4,5],vec![14,17],vec![5,11], vec![15,16]]), vec![9,0,0,0,0]);
}