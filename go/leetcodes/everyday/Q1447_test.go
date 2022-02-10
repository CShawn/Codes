//
// @Author C.Shawn
// @Date 2022/2/10 18:29

package everyday

import (
	"reflect"
	"testing"
)

func Test_simplifiedFractions(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{"case1", args{1}, []string{}},
		{"case2", args{2}, []string{"1/2"}},
		{"case3", args{3}, []string{"1/2", "1/3", "2/3"}},
		{"case4", args{4}, []string{"1/2", "1/3", "2/3", "1/4", "3/4"}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := simplifiedFractions(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("simplifiedFractions() = %v, want %v", got, tt.want)
			}
		})
	}
}
