//
// @Author C.Shawn
// @Date 2022/2/12 12:19

package everyday

import "testing"

func Test_numEnclaves(t *testing.T) {
	type args struct {
		grid [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[][]int{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}}, 3},
		{"case2", args{[][]int{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}}, 0},
		{"case3", args{[][]int{{1}}}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numEnclaves1(tt.args.grid); got != tt.want {
				t.Errorf("numEnclaves() = %v, want %v", got, tt.want)
			}
			if got := numEnclaves(tt.args.grid); got != tt.want {
				t.Errorf("numEnclaves() = %v, want %v", got, tt.want)
			}
		})
	}
}
