/**
剑指 Offer 47. 礼物的最大价值
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

示例 1:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

提示：
0 < grid.length <= 200
0 < grid[0].length <= 200

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
struct O47{}
impl O47 {
    pub fn max_value(grid: Vec<Vec<i32>>) -> i32 {
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0;n];m];
        dp[0][0] = grid[0][0];
        for i in 1..m {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for j in 1..n {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for i in 1..m {
            for j in 1..n {
                dp[i][j] = grid[i][j] + dp[i][j-1].max(dp[i-1][j]);
            }
        }
        dp[m-1][n-1]
    }
}

#[test]
pub fn test_max_value() {
    assert_eq!(O47::max_value(vec![vec![1,3,1], vec![1,5,1], vec![4,2,1]]), 12);
    assert_eq!(O47::max_value(vec![vec![1,3,1,34], vec![1,5,5,1], vec![4,9,2,1]]), 41)
}