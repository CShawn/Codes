//
// @Author C.Shawn
// @Date 2022/1/21 16:46

package everyday

import "testing"

func Test_minJumps(t *testing.T) {
	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{7}}, 0},
		{"case2", args{[]int{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}}, 3},
		{"case3", args{[]int{7, 6, 9, 6, 9, 6, 9, 7}}, 1},
		{"case4", args{[]int{6, 1, 9}}, 2},
		{"case5", args{[]int{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}}, 3},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minJumps(tt.args.arr); got != tt.want {
				t.Errorf("minJumps() = %v, want %v", got, tt.want)
			}
		})
	}
}
