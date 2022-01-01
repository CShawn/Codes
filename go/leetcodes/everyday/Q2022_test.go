/**
 * @Author C.Shawn
 * @Date 2022/1/1 14:46
 */

package everyday

import (
	"reflect"
	"testing"
)

func Test_construct2DArray(t *testing.T) {
	type args struct {
		original []int
		m        int
		n        int
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		{"case1", args{[]int{1, 2, 3, 4}, 2, 2}, [][]int{{1, 2}, {3, 4}}},
		{"case2", args{[]int{1, 2, 3}, 1, 3}, [][]int{{1, 2, 3}}},
		{"case3", args{[]int{1, 2}, 1, 1}, [][]int{}},
		{"case4", args{[]int{2}, 1, 2}, [][]int{}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := construct2DArray1(tt.args.original, tt.args.m, tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("construct2DArray() = %v, want %v", got, tt.want)
			}
			if got := construct2DArray(tt.args.original, tt.args.m, tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("construct2DArray() = %v, want %v", got, tt.want)
			}
		})
	}
}
