//
// @Author C.Shawn
// @Date 2022/2/13 10:32

package everyday

import "testing"

func Test_maxNumberOfBalloons(t *testing.T) {
	type args struct {
		text string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{"nlaebolko"}, 1},
		{"case2", args{"loonbalxballpoon"}, 2},
		{"case3", args{"leetcode"}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxNumberOfBalloons(tt.args.text); got != tt.want {
				t.Errorf("maxNumberOfBalloons() = %v, want %v", got, tt.want)
			}
		})
	}
}
