/**
递增的三元子序列
给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

示例 1：
输入：nums = [1,2,3,4,5]
输出：true
解释：任何 i < j < k 的三元组都满足题意
示例 2：
输入：nums = [5,4,3,2,1]
输出：false
解释：不存在满足题意的三元组
示例 3：
输入：nums = [2,1,5,0,4,6]
输出：true
解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6

提示：
	1 <= nums.length <= 5 * 10^5
	-2^31 <= nums[i] <= 2^31 - 1

进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
*/
package everyday

import "math"

// 最长递增子数列，动态规划，超时
func increasingTriplet1(nums []int) bool {
	dp := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				if dp[j]+1 > dp[i] {
					dp[i] = dp[j] + 1
				}
				if dp[i] == 3 {
					return true
				}
			}
		}
	}
	return false
}

// 满足条件的中间元素索引为i,则i左侧存在比它小的元素，右侧存在比它大的元素
func increasingTriplet2(nums []int) bool {
	leftMin := make([]int, len(nums))
	rightMax := make([]int, len(nums))
	leftMin[0] = nums[0]
	rightMax[len(nums)-1] = nums[len(nums)-1]
	for i := 1; i < len(nums); i++ {
		if nums[i] < leftMin[i-1] {
			leftMin[i] = nums[i]
		} else {
			leftMin[i] = leftMin[i-1]
		}
	}
	for i := len(nums) - 2; i >= 0; i-- {
		if nums[i] > rightMax[i+1] {
			rightMax[i] = nums[i]
		} else {
			rightMax[i] = rightMax[i+1]
		}
	}
	for i := 1; i < len(nums)-1; i++ {
		if leftMin[i-1] < nums[i] && nums[i] < rightMax[i+1] {
			return true
		}
	}
	return false
}

// 贪心
func increasingTriplet(nums []int) bool {
	first := nums[0]
	second := math.MaxInt32
	for i := 1; i < len(nums); i++ {
		if nums[i] > second {
			return true
		} else if nums[i] > first {
			second = nums[i]
		} else {
			first = nums[i]
		}
	}
	return false
}
