//
// @Author C.Shawn
// @Date 2022/2/8 18:51

package everyday

import (
	"reflect"
	"testing"
)

func Test_gridIllumination(t *testing.T) {
	type args struct {
		n       int
		lamps   [][]int
		queries [][]int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"case1", args{5, [][]int{{0, 0}, {4, 4}}, [][]int{{1, 1}, {1, 0}}}, []int{1, 0}},
		{"case2", args{5, [][]int{{0, 0}, {4, 4}}, [][]int{{1, 1}, {1, 1}}}, []int{1, 1}},
		{"case3", args{5, [][]int{{0, 0}, {0, 4}}, [][]int{{0, 4}, {0, 1}, {1, 4}}}, []int{1, 1, 0}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := gridIllumination(tt.args.n, tt.args.lamps, tt.args.queries); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("gridIllumination() = %v, want %v", got, tt.want)
			}
		})
	}
}
