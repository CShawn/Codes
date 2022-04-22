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
// @Date 2022/4/22 19:14

package everyday

import "testing"

func Test_maxRotateFunction(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{4, 3, 2, 6}}, 26},
		{"case2", args{[]int{6}}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxRotateFunction(tt.args.nums); got != tt.want {
				t.Errorf("maxRotateFunction() = %v, want %v", got, tt.want)
			}
		})
	}
}
