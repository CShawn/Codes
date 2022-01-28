//
// @Author C.Shawn
// @Date 2022/1/28 11:09

package everyday

import "testing"

func Test_numberOfWeakCharacters(t *testing.T) {
	type args struct {
		properties [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[][]int{{5, 5}, {6, 3}, {3, 6}}}, 0},
		{"case2", args{[][]int{{5, 5}, {6, 6}}}, 1},
		{"case3", args{[][]int{{1, 5}, {10, 4}, {4, 3}}}, 1},
		{"case4", args{[][]int{{1, 1}, {2, 1}, {2, 2}, {1, 2}}}, 1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numberOfWeakCharacters(tt.args.properties); got != tt.want {
				t.Errorf("numberOfWeakCharacters() = %v, want %v", got, tt.want)
			}
		})
	}
}
