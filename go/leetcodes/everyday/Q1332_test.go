//
// @Author C.Shawn
// @Date 2022/1/22 19:44

package everyday

import "testing"

func Test_removePalindromeSub(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{"ababa"}, 1},
		{"case2", args{"abb"}, 2},
		{"case3", args{"baabb"}, 2},
		{"case4", args{"a"}, 1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := removePalindromeSub(tt.args.s); got != tt.want {
				t.Errorf("removePalindromeSub() = %v, want %v", got, tt.want)
			}
		})
	}
}
