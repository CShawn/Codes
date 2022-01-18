/**
最小时间差
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

示例 1：
输入：timePoints = ["23:59","00:00"]
输出：1

示例 2：
输入：timePoints = ["00:00","23:59","00:00"]
输出：0

提示：
	2 4
	timePoints[i] 格式为 "HH:MM"
*/
package everyday

import (
	"math"
	"sort"
)

// 排序 + 鸽巢原理（超出枚举数量必有重复）
func findMinDifference(timePoints []string) int {
	if len(timePoints) > 1440 {
		return 0
	}
	sort.Strings(timePoints)
	first := getMinutes(timePoints[0])
	pre := first
	min := math.MaxInt32
	for _, s := range timePoints[1:] {
		cur := getMinutes(s)
		if (cur - pre) < min {
			min = cur - pre
		}
		pre = cur
	}
	t := first + 1440 - pre
	if t < min {
		min = t
	}
	return min
}

func getMinutes(t string) int {
	return (int(t[0]-'0')*10+int(t[1]-'0'))*60 + int(t[3]-'0')*10 + int(t[4]-'0')
}
