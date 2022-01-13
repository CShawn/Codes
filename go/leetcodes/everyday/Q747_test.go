//
// @Author C.Shawn
// @Date 2022/1/13 17:27

package everyday

import "testing"

func Test_dominantIndex(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{3, 6, 1, 0}}, 1},
		{"case2", args{[]int{1, 2, 3, 4}}, -1},
		{"case3", args{[]int{1}}, 0},
		{"case4", args{[]int{2, 2, 3}}, -1},
		{"case5", args{[]int{2, 2, 4}}, 2},
		{"case6", args{[]int{0, 0, 0, 1}}, 3},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := dominantIndex(tt.args.nums); got != tt.want {
				t.Errorf("dominantIndex() = %v, want %v", got, tt.want)
			}
		})
	}
}
