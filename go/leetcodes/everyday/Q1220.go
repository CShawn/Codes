/**
统计元音字母序列的数目
给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
	字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
	每个元音 'a' 后面都只能跟着 'e'
	每个元音 'e' 后面只能跟着 'a' 或者是 'i'
	每个元音 'i' 后面 不能 再跟着另一个 'i'
	每个元音 'o' 后面只能跟着 'i' 或者是 'u'
	每个元音 'u' 后面只能跟着 'a'
由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。

示例 1：
输入：n = 1
输出：5
解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。

示例 2：
输入：n = 2
输出：10
解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。

示例 3：
输入：n = 5
输出：68

提示：
	1 <= n <= 2 * 10^4
*/
package everyday

// 方法1：动态规划
func countVowelPermutation1(n int) int {
	// base := []byte{'a', 'e', 'i', 'o', 'u'}
	// next := [][]byte{{'e'}, {'a', 'i'}, {'a', 'e', 'o', 'u'}, {'i', 'u'}, {'a'}}
	// pre := [][]byte{{'e', 'i', 'u'}, {'a', 'i'}, {'e', 'o'}, {'i'}, {'i', 'o'}}
	// pre[i][j] 代表当前长度为 i 且以字符 j(aeiou) 为结尾的字符串的数目
	// pre[i][0]=pre[i−1][1]+pre[i−1][2]+pre[i−1][4]
	// pre[i][1]=pre[i−1][0]+pre[i−1][2]
	// pre[i][2]=pre[i−1][1]+pre[i−1][3]
	// pre[i][3]=pre[i−1][2]
	// pre[i][4]=pre[i−1][2]+pre[i−1][3]
	// pre[i]只与dp[i-1]有关，可降为一维，记录一组dp[i-1]
	var mod int64 = 1000000007
	pre := make([]int64, 5)
	dp := make([]int64, 5)
	for i := 0; i < 5; i++ {
		pre[i] = 1
	}
	for i := 2; i <= n; i++ {
		dp[0] = (pre[1] + pre[2] + pre[4]) % mod
		dp[1] = (pre[0] + pre[2]) % mod
		dp[2] = (pre[1] + pre[3]) % mod
		dp[3] = pre[2]
		dp[4] = (pre[2] + pre[3]) % mod
		copy(pre, dp)
	}
	var result int64 = 0
	for _, r := range pre {
		result = (result + r) % mod
	}
	return int(result)
}

type matrix [5][5]int

const mod = 1000000007

func (m matrix) multiply(b matrix) matrix {
	c := matrix{}
	for i, row := range m {
		for j := range b[0] {
			for k, v := range row {
				c[i][j] = (c[i][j] + v*b[k][j]) % mod
			}
		}
	}
	return c
}

func (m matrix) pow(n int) matrix {
	res := matrix{}
	for i := range res {
		res[i][i] = 1
	}
	for ; n > 0; n >>= 1 {
		if n&1 > 0 {
			res = res.multiply(m)
		}
		m = m.multiply(m)
	}
	return res
}

// 方法2：矩阵快速幂
func countVowelPermutation(n int) (ans int) {
	// f(n) = {{0, 1, 0, 0, 0},
	//         {1, 0, 1, 0, 0},
	//         {1, 1, 0, 1, 1},
	//         {0, 0, 1, 0, 1},
	//         {1, 0, 0, 0, 0}} x f(n-1)
	//      =  {{}}^(n-1) x f(1)
	// f(1) = [1,1,1,1,1]
	m := matrix{
		{0, 1, 0, 0, 0},
		{1, 0, 1, 0, 0},
		{1, 1, 0, 1, 1},
		{0, 0, 1, 0, 1},
		{1, 0, 0, 0, 0},
	}
	res := m.pow(n - 1)
	for _, row := range res {
		for _, v := range row {
			ans = (ans + v) % mod
		}
	}
	return
}
