/**
 * @Author C.Shawn
 * @Date 2022/1/10 09:08
 */

package everyday

import "testing"

func Test_isAdditiveNumber(t *testing.T) {
	type args struct {
		num string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case1", args{"112358"}, true},
		{"case2", args{"199100199"}, true},
		{"case3", args{"19910929"}, true},
		{"case4", args{"1991110201"}, true},
		{"case5", args{"1991"}, false},
		{"case6", args{"11111111111111111111111111111111111111111111111111111111112222222222222222222222222222233333333333333333333333333333"}, true},
		{"case7", args{"123"}, true},
		{"case8", args{"101"}, true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isAdditiveNumber(tt.args.num); got != tt.want {
				t.Errorf("isAdditiveNumber() = %v, want %v", got, tt.want)
			}
		})
	}
}
