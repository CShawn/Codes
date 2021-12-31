/**
 * @Author C.Shawn
 * @Date 2021/12/31 13:46
 */

package everyday

import "testing"

func Test_checkPerfectNumber(t *testing.T) {
	type args struct {
		num int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case1", args{28}, true},
		{"case2", args{6}, true},
		{"case3", args{496}, true},
		{"case4", args{8128}, true},
		{"case5", args{2}, false},
		{"case6", args{1}, false},
		{"case7", args{3}, false},
		{"case8", args{4}, false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := checkPerfectNumber(tt.args.num); got != tt.want {
				t.Errorf("checkPerfectNumber() = %v, want %v", got, tt.want)
			}
		})
	}
}
