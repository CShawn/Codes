/**
跳跃游戏 IV
给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
每一步，你可以从下标 i 跳到下标：
	i + 1 满足：i + 1 < arr.length
	i - 1 满足：i - 1 >= 0
	j 满足：arr[i] == arr[j] 且 i != j
请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
注意：任何时候你都不能跳到数组外面。

示例 1：
输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
输出：3
解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
示例 2：
输入：arr = [7]
输出：0
解释：一开始就在最后一个元素处，所以你不需要跳跃。
示例 3：
输入：arr = [7,6,9,6,9,6,9,7]
输出：1
解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
示例 4：
输入：arr = [6,1,9]
输出：2
示例 5：
输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
输出：3

提示：
	1 <= arr.length <= 5 * 10^4
	-10^8 <= arr[i] <= 10^8
*/
package everyday

// BFS
func minJumps(arr []int) int {
	if len(arr) == 1 {
		return 0
	}
	// 构造map
	same := make(map[int][]int)
	for i, num := range arr {
		same[num] = append(same[num], i)
	}
	// 记录当前节点是否已访问
	visited := map[int]bool{0: true}
	type pair struct{ index, step int }
	queue := []pair{{}}
	target := len(arr) - 1
	for len(queue) > 0 {
		size := len(queue)
		for j := 0; j < size; j++ {
			cur := queue[j]
			curIndex, step := cur.index, cur.step
			if curIndex == target {
				return step
			}
			for _, k := range same[arr[curIndex]] {
				if !visited[k] {
					visited[k] = true
					queue = append(queue, pair{k, step + 1})
				}
			}
			// 将相同数字的节点删除
			// 如果后续再到达与此值相同的节点，其步骤显然大于当前step，所以可以直接删除此值相同的列表以减少计算
			delete(same, arr[curIndex])
			// 如果curIndex+1越界，那么当前为target，不可能到达此处，所以不用判断
			if !visited[curIndex+1] {
				visited[curIndex+1] = true
				queue = append(queue, pair{curIndex + 1, step + 1})
			}
			if curIndex > 0 && !visited[curIndex-1] {
				queue = append(queue, pair{curIndex - 1, step + 1})
			}
		}
		queue = queue[size:]
	}
	return 0
}
