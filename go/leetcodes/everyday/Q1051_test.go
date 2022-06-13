/********************************************************************
 *             Copyright (c) 2022  NovaStar Tech Co. Ltd.
 *
 * PROPRIETARY RIGHTS of the following material in either
 * electronic or paper format are pertained to NovaStar Tech Co. Ltd.
 * All manufacturing, reproduction, use, and sales involved with
 * this subject MUST be conformed to the license agreement signed
 * with NovaStar Tech Co. Ltd.
 *******************************************************************/

// @Description
// @Author C.Shawn
// @Date 2022/6/13 09:07

package everyday

import "testing"

func Test_heightChecker(t *testing.T) {
	type args struct {
		heights []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{1, 1, 4, 2, 1, 3}}, 3},
		{"case2", args{[]int{5, 1, 2, 3, 4}}, 5},
		{"case3", args{[]int{1, 2, 3, 4, 5}}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := heightChecker(tt.args.heights); got != tt.want {
				t.Errorf("heightChecker() = %v, want %v", got, tt.want)
			}
		})
	}
}
