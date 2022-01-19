//
// @Author C.Shawn
// @Date 2022/1/19 09:28

package everyday

import "testing"

func Test_containsNearbyDuplicate(t *testing.T) {
	type args struct {
		nums []int
		k    int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case1", args{[]int{1, 2, 3, 1}, 3}, true},
		{"case2", args{[]int{1, 0, 1, 1}, 1}, true},
		{"case3", args{[]int{1, 2, 3, 1, 2, 3}, 2}, false},
		{"case4", args{[]int{1}, 1}, false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := containsNearbyDuplicate(tt.args.nums, tt.args.k); got != tt.want {
				t.Errorf("containsNearbyDuplicate() = %v, want %v", got, tt.want)
			}
		})
	}
}
