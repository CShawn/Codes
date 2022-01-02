/**
消除游戏
列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
给你整数 n ，返回 arr 最后剩下的数字。

示例 1：
输入：n = 9
输出：6
解释：
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr = [2, 4, 6, 8]
arr = [2, 6]
arr = [6]

示例 2：
输入：n = 1
输出：1

提示：1 <= n <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/elimination-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author C.Shawn
 * @Date 2022/1/2 15:31
*/

package everyday

// 方法1：等差数列模拟
// 每次删除后，剩余的数字都等差数列，a1 + k * step
func lastRemaining1(n int) int {
	a1, step, count := 1, 1, n
	// 方向
	flag := true
	for count > 1 {
		if flag {
			// 正向删除时，每次删除第1个，下一次剩余的为第2个数字
			a1 += step
		} else {
			// 反向时，取决于剩余数字的个数
			if count&1 == 1 {
				a1 += step
			}
		}
		flag = !flag
		step <<= 1
		count >>= 1
	}
	return a1
}

// 方法2：公式递归
func lastRemaining(n int) int {
	if n == 1 {
		return 1
	}
	m := n >> 1
	return (m + 1 - lastRemaining(m)) << 1
}
