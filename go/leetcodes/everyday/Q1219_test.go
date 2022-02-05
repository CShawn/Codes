//
// @Author C.Shawn
// @Date 2022/2/5 18:54

package everyday

import "testing"

func Test_getMaximumGold(t *testing.T) {
	type args struct {
		grid [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[][]int{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}}, 24},
		{"case2", args{[][]int{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}}, 28},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := getMaximumGold(tt.args.grid); got != tt.want {
				t.Errorf("getMaximumGold() = %v, want %v", got, tt.want)
			}
		})
	}
}
