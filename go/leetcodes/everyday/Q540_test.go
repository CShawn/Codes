//
// @Author C.Shawn
// @Date 2022/2/14 09:10

package everyday

import "testing"

func Test_singleNonDuplicate(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{1, 1, 2, 3, 3, 4, 4, 8, 8}}, 2},
		{"case2", args{[]int{3, 3, 7, 7, 10, 11, 11}}, 10},
		{"case3", args{[]int{3}}, 3},
		{"case4", args{[]int{3, 3, 4}}, 4},
		{"case5", args{[]int{3, 4, 4}}, 3},
		{"case6", args{[]int{3, 4, 4, 5, 5}}, 3},
		{"case7", args{[]int{3, 3, 4, 5, 5}}, 4},
		{"case8", args{[]int{3, 3, 4, 4, 5}}, 5},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := singleNonDuplicate(tt.args.nums); got != tt.want {
				t.Errorf("singleNonDuplicate() = %v, want %v", got, tt.want)
			}
		})
	}
}
