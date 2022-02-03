//
// @Author C.Shawn
// @Date 2022/2/2 09:51

package everyday

import "testing"

func Test_reversePrefix(t *testing.T) {
	type args struct {
		word string
		ch   byte
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{"abcdefd", 'd'}, "dcbaefd"},
		{"case2", args{"xyxzxe", 'z'}, "zxyxxe"},
		{"case3", args{"abdx", 'c'}, "abdx"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := reversePrefix(tt.args.word, tt.args.ch); got != tt.want {
				t.Errorf("reversePrefix() = %v, want %v", got, tt.want)
			}
		})
	}
}
