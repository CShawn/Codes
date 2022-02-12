/**
飞地的数量
给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。

示例 1：
输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
输出：3
解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
示例 2：
输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
输出：0
解释：所有 1 都在边界上或可以到达边界。

提示：
	m == grid.length
	n == grid[i].length
	1 <= m, n <= 500
	grid[i][j] 的值为 0 或 1
*/
package everyday

// DFS
func numEnclaves1(grid [][]int) int {
	visited := make([][]bool, len(grid))
	total := 0
	can := 0
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, len(grid[i]))
	}
	for i := 0; i < len(visited); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				total++
				if i == 0 || i == len(grid)-1 || j == 0 || j == len(grid[i])-1 {
					can += dfs1020(grid, visited, i, j)
				}
			}
		}
	}
	return total - can
}

func dfs1020(grid [][]int, visited [][]bool, i int, j int) int {
	if i >= len(grid) || i < 0 || j >= len(grid[i]) || j < 0 {
		return 0
	}
	if visited[i][j] || grid[i][j] == 0 {
		return 0
	}
	visited[i][j] = true
	return 1 + dfs1020(grid, visited, i+1, j) + dfs1020(grid, visited, i-1, j) + dfs1020(grid, visited, i, j+1) + dfs1020(grid, visited, i, j-1)
}

// DFS 优化，不存储已访问节点改为将节点置0，判断是否可到达边界
var can = true

func numEnclaves(grid [][]int) int {
	result := 0
	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				can = true
				count := dfs10202(grid, i, j)
				if can {
					result += count
				}
			}
		}
	}
	return result
}

func dfs10202(grid [][]int, i int, j int) int {
	if i >= len(grid) || i < 0 || j >= len(grid[i]) || j < 0 {
		can = false
		return 0
	}
	if grid[i][j] == 0 {
		return 0
	}
	grid[i][j] = 0
	return 1 + dfs10202(grid, i+1, j) + dfs10202(grid, i-1, j) + dfs10202(grid, i, j+1) + dfs10202(grid, i, j-1)
}
