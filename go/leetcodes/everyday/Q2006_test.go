//
// @Author C.Shawn
// @Date 2022/2/9 10:02

package everyday

import "testing"

func Test_countKDifference(t *testing.T) {
	type args struct {
		nums []int
		k    int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{1, 2, 2, 1}, 1}, 4},
		{"case2", args{[]int{1, 3}, 3}, 0},
		{"case3", args{[]int{3, 2, 1, 5, 4}, 2}, 3},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countKDifference1(tt.args.nums, tt.args.k); got != tt.want {
				t.Errorf("countKDifference() = %v, want %v", got, tt.want)
			}
			if got := countKDifference(tt.args.nums, tt.args.k); got != tt.want {
				t.Errorf("countKDifference() = %v, want %v", got, tt.want)
			}
		})
	}
}
