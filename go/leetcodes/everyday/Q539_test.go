//
// @Author C.Shawn
// @Date 2022/1/18 09:39

package everyday

import "testing"

func Test_findMinDifference(t *testing.T) {
	type args struct {
		timePoints []string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]string{"23:59", "00:00"}}, 1},
		{"case2", args{[]string{"23:59", "00:00", "00:00"}}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findMinDifference(tt.args.timePoints); got != tt.want {
				t.Errorf("findMinDifference() = %v, want %v", got, tt.want)
			}
		})
	}
}
