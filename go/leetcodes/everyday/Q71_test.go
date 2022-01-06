/**
 * @Author C.Shawn
 * @Date 2022/1/6 09:38
 */

package everyday

import "testing"

func Test_simplifyPath(t *testing.T) {
	type args struct {
		path string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{"/home/"}, "/home"},
		{"case2", args{"/home/.."}, "/"},
		{"case4", args{"/."}, "/"},
		{"case3", args{"/../"}, "/"},
		{"case4", args{"/..."}, "/..."},
		{"case5", args{"/home//foo/"}, "/home/foo"},
		{"case6", args{"/a/./b/../../c/"}, "/c"},
		{"case7", args{"/a/./b/.../../c/"}, "/a/b/c"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := simplifyPath1(tt.args.path); got != tt.want {
				t.Errorf("simplifyPath1() = %v, want %v", got, tt.want)
			}
			if got := simplifyPath2(tt.args.path); got != tt.want {
				t.Errorf("simplifyPath2() = %v, want %v", got, tt.want)
			}
			if got := simplifyPath(tt.args.path); got != tt.want {
				t.Errorf("simplifyPath() = %v, want %v", got, tt.want)
			}
		})
	}
}
