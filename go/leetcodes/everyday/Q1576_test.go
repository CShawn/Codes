/**
 * @Author C.Shawn
 * @Date 2022/1/5 09:19
 */

package everyday

import "testing"

func Test_modifyString(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{"?zs"}, "azs"},
		{"case2", args{"ubv?w"}, "ubvaw"},
		{"case3", args{"j?qg??b"}, "jaqgacb"},
		{"case4", args{"??yw?ipkj?"}, "abywaipkja"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := modifyString1(tt.args.s); got != tt.want {
				t.Errorf("modifyString() = %v, want %v", got, tt.want)
			}
			if got := modifyString(tt.args.s); got != tt.want {
				t.Errorf("modifyString() = %v, want %v", got, tt.want)
			}
		})
	}
}
