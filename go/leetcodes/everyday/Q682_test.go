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
// @Date 2022/3/26 20:47

package everyday

import "testing"

func Test_calPoints(t *testing.T) {
	type args struct {
		ops []string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]string{"5", "2", "C", "D", "+"}}, 30},
		{"case2", args{[]string{"5", "-2", "4", "C", "D", "9", "+", "+"}}, 27},
		{"case3", args{[]string{"1"}}, 1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := calPoints(tt.args.ops); got != tt.want {
				t.Errorf("calPoints() = %v, want %v", got, tt.want)
			}
		})
	}
}
