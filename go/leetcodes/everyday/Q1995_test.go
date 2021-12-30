package everyday

import (
	"strconv"
	"testing"
)

func Test_countQuadruplets(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		args args
		want int
	}{
		{args{[]int{1, 2, 3, 6}}, 1},
		{args{[]int{3, 3, 6, 4, 5}}, 0},
		{args{[]int{1, 1, 1, 3, 5}}, 4},
	}
	for i, tt := range tests {
		t.Run("case"+strconv.Itoa(i), func(t *testing.T) {
			if got := countQuadruplets(tt.args.nums); got != tt.want {
				t.Errorf("countQuadruplets() = %v, want %v", got, tt.want)
			}
		})
	}
}
