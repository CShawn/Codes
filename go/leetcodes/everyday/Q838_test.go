//
// @Author C.Shawn
// @Date 2022/2/21 13:07

package everyday

import "testing"

func Test_pushDominoes(t *testing.T) {
	type args struct {
		dominoes string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{"RR.L"}, "RR.L"},
		{"case2", args{".L.R...LR..L.."}, "LL.RR.LLRRLL.."},
		{"case3", args{".L.R."}, "LL.RR"},
		{"case4", args{"R.R.L"}, "RRR.L"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := pushDominoes(tt.args.dominoes); got != tt.want {
				t.Errorf("pushDominoes() = %v, want %v", got, tt.want)
			}
		})
	}
}
