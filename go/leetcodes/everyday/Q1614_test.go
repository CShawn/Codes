/**
 * @Author C.Shawn
 * @Date 2022/1/7 10:35
 */

package everyday

import "testing"

func Test_maxDepth(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{"(1+(2*3)+((8)/4))+1"}, 3},
		{"case1", args{"(1)+((2))+(((3)))"}, 3},
		{"case1", args{"1+(2*3)/(2-1)"}, 1},
		{"case1", args{"1"}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxDepth(tt.args.s); got != tt.want {
				t.Errorf("maxDepth() = %v, want %v", got, tt.want)
			}
		})
	}
}
