//
// @Author C.Shawn
// @Date 2022/1/30 10:51

package everyday

import (
	"reflect"
	"testing"
)

func Test_uncommonFromSentences(t *testing.T) {
	type args struct {
		s1 string
		s2 string
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{"case1", args{"this apple is sweet", "this apple is sour"}, []string{"sweet", "sour"}},
		{"case2", args{"apple apple", "banana"}, []string{"banana"}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := uncommonFromSentences(tt.args.s1, tt.args.s2); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("uncommonFromSentences() = %v, want %v", got, tt.want)
			}
		})
	}
}
