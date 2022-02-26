//
// @Author C.Shawn
// @Date 2022/2/26 18:28

package everyday

import "testing"

func Test_maximumDifference(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{7, 1, 5, 4}}, 4},
		{"case2", args{[]int{9, 4, 3, 2}}, -1},
		{"case3", args{[]int{1, 5, 2, 10}}, 9},
		{"case4", args{[]int{2, 6, 1, 3, 4}}, 4},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maximumDifference(tt.args.nums); got != tt.want {
				t.Errorf("maximumDifference() = %v, want %v", got, tt.want)
			}
		})
	}
}
