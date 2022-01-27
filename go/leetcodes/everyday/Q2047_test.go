//
// @Author C.Shawn
// @Date 2022/1/27 19:10

package everyday

import "testing"

func Test_countValidWords(t *testing.T) {
	type args struct {
		sentence string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{"cat and  dog"}, 3},
		{"case2", args{"!this  1-s b8d!"}, 0},
		{"case3", args{"alice and  bob are playing stone-game10"}, 5},
		{"case4", args{"he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."}, 6},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countValidWords(tt.args.sentence); got != tt.want {
				t.Errorf("countValidWords() = %v, want %v", got, tt.want)
			}
		})
	}
}
