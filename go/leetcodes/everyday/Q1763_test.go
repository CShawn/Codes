//
// @Author C.Shawn
// @Date 2022/2/1 08:53

package everyday

import "testing"

func Test_longestNiceSubstring(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{"YazaAay"}, "aAa"},
		{"case2", args{"Bb"}, "Bb"},
		{"case3", args{"dDzeE"}, "dD"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := longestNiceSubstring(tt.args.s); got != tt.want {
				t.Errorf("longestNiceSubstring() = %v, want %v", got, tt.want)
			}
		})
	}
}
