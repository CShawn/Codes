/**
一手顺子
Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。

示例 1：
输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
输出：true
解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。

示例 2：
输入：hand = [1,2,3,4,5], groupSize = 4
输出：false
解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。

提示：
1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hand-of-straights
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author C.Shawn
 * @Date 2021/12/30 14:02
*/
package everyday

import "sort"

// TreeMap
func isNStraightHand1(hand []int, groupSize int) bool {
	if len(hand)%groupSize != 0 {
		return false
	}
	count := make(map[int]int)
	for _, i := range hand {
		count[i]++
	}
	keys := make([]int, 0)
	for key := range count {
		keys = append(keys, key)
	}
	sort.Sort(sort.IntSlice(keys))
	size := len(hand) / groupSize
	for size > 0 {
		pre := -1
		i := 0
		for _, key := range keys {
			if count[key] > 0 {
				if pre == -1 || key-pre == 1 {
					count[key]--
					pre = key
				} else {
					return false
				}
				i++
				if i == groupSize {
					break
				}
			}
		}
		if i != groupSize {
			return false
		}
		size--
	}
	return true
}

// 排序
func isNStraightHand(hand []int, groupSize int) bool {
	if len(hand)%groupSize != 0 {
		return false
	}
	if groupSize == 1 {
		return true
	}
	sort.Ints(hand)
	for i := 0; i < len(hand); i++ {
		if hand[i] == -1 {
			continue
		}
		value, count, group := hand[i], 0, false
		for j := i; j < len(hand); j++ {
			if hand[j] == -1 {
				continue
			}
			if hand[j] == value+count {
				count++
				hand[j] = -1
				if count == groupSize {
					group = true
					break
				}
			} else if hand[j] > value+count {
				return false
			}
		}
		if !group {
			return false
		}
	}
	return true
}
