/**
格雷编码
n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
	每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
	第一个整数是 0
	一个整数在序列中出现 不超过一次
	每对 相邻 整数的二进制表示 恰好一位不同 ，且
	第一个 和 最后一个 整数的二进制表示 恰好一位不同

给你一个整数 n ，返回任一有效的 n 位格雷码序列 。

示例 1：
输入：n = 2
输出：[0,1,3,2]
解释：
[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
- 00 和 01 有一位不同
- 01 和 11 有一位不同
- 11 和 10 有一位不同
- 10 和 00 有一位不同
[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
- 00 和 10 有一位不同
- 10 和 11 有一位不同
- 11 和 01 有一位不同
- 01 和 00 有一位不同

示例 2：
输入：n = 1
输出：[0,1]

提示: 1 <= n <= 16

*/
package everyday

// 方法1：回溯
func grayCode1(n int) []int {
	set := map[int]interface{}{0: nil}
	limit := 1 << n
	result := make([]int, limit)
	bits := 0
	for limit != 0 {
		limit >>= 1
		bits++
	}
	dfs(result, bits, set, 1)
	return result
}

func dfs(result []int, bits int, set map[int]interface{}, index int) bool {
	if index == len(result) {
		return true
	}
	pre := result[index-1]
	for i := 0; i < bits; i++ {
		flag := 1 << i
		bit := (pre & flag) >> i
		change := pre
		if bit == 1 {
			change &= ^flag
		} else {
			change |= flag
		}
		if _, ok := set[change]; !ok && change < len(result) {
			if index != len(result)-1 || result[0]&change&((result[0]&change)-1) == 0 {
				result[index] = change
				set[change] = nil
				if dfs(result, bits, set, index+1) {
					return true
				}
			}
		}
	}
	return false
}

// 方法2：对称性构造
// 观察发现，k+1位格雷码长度是k位格雷码的2倍，且去掉最高位的1后，数组的前后两部分是对称的
// 所以可以通过不断对称复制并增加高位1，可以实现最终的结果
func grayCode2(n int) []int {
	res := []int{0}
	for i := 0; i < n; i++ {
		preSize := len(res)
		for j := preSize - 1; j >= 0; j-- {
			res = append(res, res[j]|1<<i)
		}
	}
	return res
}

// 方法3：二进制数转格雷码
// 公式：g(i)=b(i+1)⊕b(i),    0≤i<n
func grayCode(n int) []int {
	res := make([]int, 1<<n)
	for i := range res {
		res[i] = (i >> 1) ^ i
	}
	return res
}
