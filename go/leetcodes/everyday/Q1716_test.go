//
// @Author C.Shawn
// @Date 2022/1/15 18:35

package everyday

import "testing"

func Test_totalMoney(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{4}, 10},
		{"case2", args{10}, 37},
		{"case3", args{20}, 96},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := totalMoney(tt.args.n); got != tt.want {
				t.Errorf("totalMoney() = %v, want %v", got, tt.want)
			}
		})
	}
}
