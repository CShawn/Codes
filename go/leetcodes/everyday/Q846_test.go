/**
 * @Author C.Shawn
 * @Date 2021/12/30 14:52
 */

package everyday

import "testing"

func Test_isNStraightHand(t *testing.T) {
	type args struct {
		hand      []int
		groupSize int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case1", args{[]int{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3}, true},
		{"case2", args{[]int{1, 2, 3, 4, 5}, 4}, false},
		{"case3", args{[]int{1, 2, 3, 4, 5, 7}, 3}, false},
		{"case4", args{[]int{1, 1, 2, 2, 3, 3}, 2}, false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isNStraightHand1(tt.args.hand, tt.args.groupSize); got != tt.want {
				t.Errorf("isNStraightHand() = %v, want %v", got, tt.want)
			}
			if got := isNStraightHand(tt.args.hand, tt.args.groupSize); got != tt.want {
				t.Errorf("isNStraightHand() = %v, want %v", got, tt.want)
			}
		})
	}
}
