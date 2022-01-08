/**
 * @Author C.Shawn
 * @Date 2022/1/8 17:06
 */

package everyday

import (
	"reflect"
	"testing"
)

func Test_grayCode(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"case1", args{1}, []int{0, 1}},
		{"case2", args{2}, []int{0, 1, 3, 2}},
		{"case3", args{3}, []int{0, 1, 3, 2, 6, 7, 5, 4}},
		{"case4", args{4}, []int{0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := grayCode1(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("grayCode1() = %v, want %v", got, tt.want)
			}
			if got := grayCode2(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("grayCode2() = %v, want %v", got, tt.want)
			}
			if got := grayCode(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("grayCode() = %v, want %v", got, tt.want)
			}
		})
	}
}
