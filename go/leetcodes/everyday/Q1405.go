/**
最长快乐字符串
如果字符串中不含有任何 &#39;aaa&#39;，&#39;bbb&#39; 或 &#39;ccc&#39; 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
	s 是一个尽可能长的快乐字符串。
	s 中 最多 有a 个字母 &#39;a&#39;、b 个字母 &#39;b&#39;、c 个字母 &#39;c&#39; 。
	s 中只含有 &#39;a&#39;、&#39;b&#39; 、&#39;c&#39; 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

示例 1：
输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。
示例 2：
输入：a = 2, b = 2, c = 1
输出："aabbc"
示例 3：
输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。

提示：
	0 <= a, b, c <= 100
	a + b + c > 0
*/
package everyday

func longestDiverseString(a int, b int, c int) string {
	var maxChar, midChar, minChar byte
	var maxCount, midCount, minCount int
	if a > b {
		maxChar = 'a'
		maxCount = a
		minChar = 'b'
		minCount = b
	} else {
		maxChar = 'b'
		maxCount = b
		minChar = 'a'
		minCount = a
	}
	if c > maxCount {
		midChar = maxChar
		midCount = maxCount
		maxChar = 'c'
		maxCount = c
	} else if c < minCount {
		midChar = minChar
		midCount = minCount
		minChar = 'c'
		minCount = c
	} else {
		midChar = 'c'
		midCount = c
	}
	if (minCount+midCount+1)<<1 < maxCount {
		maxCount = (minCount + midCount + 1) << 1
	}
	group := (maxCount + 1) >> 1
	bothLess := midCount < group
	bothGreater := minCount >= group
	midLast := midCount % group
	midGroup := midLast == 0
	minLast := minCount % group
	minGroup := minLast == 0
	left := minCount + midCount - group
	result := make([]byte, 0)
	for maxCount > 0 {
		if maxCount == 1 {
			result = append(result, maxChar)
			maxCount--
		} else {
			result = append(result, maxChar, maxChar)
			maxCount -= 2
		}
		mid := midCount
		if midCount > 0 {
			result = append(result, midChar)
			midCount--
		}
		if !bothLess && ((midGroup && midCount > 0) || midLast > 0) {
			result = append(result, midChar)
			midCount--
			midLast--
		}
		if minCount > 0 && (!bothLess || mid == 0) {
			result = append(result, minChar)
			minCount--
		}
		if (bothGreater && ((minGroup && minCount > 0) || minLast > 0)) || (bothLess && left > 0) {
			result = append(result, minChar)
			minCount--
			minLast--
			if bothLess && left > 0 {
				left--
			}
		}
	}
	return string(result)
}
