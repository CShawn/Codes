//
// @Author C.Shawn
// @Date 2022/1/17 09:31

package everyday

import "testing"

func Test_countVowelPermutation(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{1}, 5},
		{"case2", args{2}, 10},
		{"case3", args{5}, 68},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countVowelPermutation1(tt.args.n); got != tt.want {
				t.Errorf("countVowelPermutation() = %v, want %v", got, tt.want)
			}
			if got := countVowelPermutation(tt.args.n); got != tt.want {
				t.Errorf("countVowelPermutation() = %v, want %v", got, tt.want)
			}
		})
	}
}
