//
// @Author C.Shawn
// @Date 2022/2/7 10:40

package everyday

import "testing"

func Test_longestDiverseString(t *testing.T) {
	type args struct {
		a int
		b int
		c int
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{1, 1, 7}, "ccbccacc"},
		{"case2", args{2, 2, 1}, "bbaac"},
		{"case3", args{7, 1, 0}, "aabaa"},
		{"case4", args{1, 0, 3}, "ccac"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := longestDiverseString(tt.args.a, tt.args.b, tt.args.c); got != tt.want {
				t.Errorf("longestDiverseString() = %v, want %v", got, tt.want)
			}
		})
	}
}
