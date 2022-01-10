/**
累加数
累加数 是一个字符串，组成它的数字可以形成累加序列。
一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1：
输入："112358"
输出：true
解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

示例 2：
输入："199100199"
输出：true
解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199

提示：
	1 <= num.length <= 35
	num 仅由数字（0 - 9）组成

进阶：你计划如何处理由过大的整数输入导致的溢出?
*/

package everyday

// 回溯
// 找第1，2个数，1+2=3.之后2+3=4直接判断直到最后
// 因为两数之和的长度必然大于等于较长的数，所以，第3个数最大到达第1,2个数较长者，而第1个数最长到达总长的一半
func isAdditiveNumber(num string) bool {
	size := len(num)
	// 取第1个数字
	for firstLen := 1; firstLen <= (size-1)>>1; firstLen++ {
		first := num[:firstLen]
		for secondLen := 1; firstLen <= size-firstLen-secondLen && secondLen <= size-firstLen-secondLen &&
			(secondLen == 1 || num[firstLen] != '0'); secondLen++ {
			second := num[firstLen : firstLen+secondLen]
			if checkContinue(num, first, second, firstLen+secondLen) {
				return true
			}
		}
	}
	return false
}

func checkContinue(num string, first string, second string, thirdIndex int) bool {
	if thirdIndex == len(num) {
		return true
	}
	third := sum(first, second)
	next := thirdIndex + len(third)
	if next > len(num) {
		return false
	}
	return num[thirdIndex:next] == third && checkContinue(num, second, third, next)
}

func sum(a string, b string) string {
	var size int
	if len(a) > len(b) {
		size = len(a)
	} else {
		size = len(b)
	}
	sum := make([]byte, size)
	var carry byte = 0
	for i := 1; i <= size; i++ {
		indexA := len(a) - i
		var valueA byte = 0
		if indexA >= 0 {
			valueA = a[indexA] - '0'
		}
		indexB := len(b) - i
		var valueB byte = 0
		if indexB >= 0 {
			valueB = b[indexB] - '0'
		}
		s := valueA + valueB + carry
		sum[size-i] = s%10 + '0'
		carry = s / 10
	}
	if carry == 1 {
		sum = append([]byte{'1'}, sum...)
	}
	return string(sum)
}
