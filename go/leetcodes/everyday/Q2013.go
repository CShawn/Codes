/**
检测正方形
给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
	添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
	给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
实现 DetectSquares 类：
	DetectSquares() 使用空数据结构初始化对象
	void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
	int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。

示例：
输入：
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
输出：
[null, null, null, null, 1, 0, null, 2]
解释：
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // 返回 1 。你可以选择：
                               //   - 第一个，第二个，和第三个点
detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
detectSquares.add([11, 2]);    // 允许添加重复的点。
detectSquares.count([11, 10]); // 返回 2 。你可以选择：
                               //   - 第一个，第二个，和第三个点
                               //   - 第一个，第三个，和第四个点

提示：
	point.length == 2
	0 <= x, y <= 1000
	调用 add 和 count 的 总次数 最多为 5000
*/
package everyday

import "strconv"

type DetectSquares struct {
	pointCount map[string]int
	xPoints    map[int][]int
	// 方法2，可将两个集合存储为一个map[int]map[int]int，存储x对应的（y对应的x的个数）
}

func Constructor() DetectSquares {
	return DetectSquares{
		pointCount: make(map[string]int),
		xPoints:    make(map[int][]int),
	}
}

func (this *DetectSquares) Add(point []int) {
	key := getKey(point[0], point[1])
	if this.pointCount[key] == 0 {
		this.xPoints[point[0]] = append(this.xPoints[point[0]], point[1])
	}
	this.pointCount[key]++
}

func (this *DetectSquares) Count(point []int) int {
	result := 0
	x0 := point[0]
	y0 := point[1]
	for _, y1 := range this.xPoints[x0] {
		if y1 == y0 {
			continue
		}
		side := y1 - y0
		if side < 0 {
			side = -side
		}
		x1 := x0 - side
		count1 := this.pointCount[getKey(x1, y0)]
		if count1 != 0 {
			count2 := this.pointCount[getKey(x1, y1)]
			if count2 != 0 {
				result += count1 * count2 * this.pointCount[getKey(x0, y1)]
			}
		}

		x1 = x0 + side
		count1 = this.pointCount[getKey(x1, y0)]
		if count1 == 0 {
			continue
		}
		count2 := this.pointCount[getKey(x1, y1)]
		if count2 == 0 {
			continue
		}
		result += count1 * count2 * this.pointCount[getKey(x0, y1)]
	}
	return result
}

func getKey(x, y int) string {
	return strconv.Itoa(x) + "-" + strconv.Itoa(y)
}
