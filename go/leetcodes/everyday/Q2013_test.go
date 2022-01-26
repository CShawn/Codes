//
// @Author C.Shawn
// @Date 2022/1/26 17:35

package everyday

import (
	"reflect"
	"testing"
)

func TestDetectSquares_Count(t *testing.T) {
	obj := Constructor()
	obj.Add([]int{3, 10})
	obj.Add([]int{11, 2})
	obj.Add([]int{3, 2})
	t.Run("case1", func(t *testing.T) {
		if got := obj.Count([]int{11, 10}); !reflect.DeepEqual(got, 1) {
			t.Errorf("Count() = %v, want %v", got, 1)
		}
	})
	t.Run("case2", func(t *testing.T) {
		if got := obj.Count([]int{14, 8}); !reflect.DeepEqual(got, 0) {
			t.Errorf("Count() = %v, want %v", got, 0)
		}
	})
	obj.Add([]int{11, 2})
	t.Run("case3", func(t *testing.T) {
		if got := obj.Count([]int{11, 10}); !reflect.DeepEqual(got, 2) {
			t.Errorf("Count() = %v, want %v", got, 2)
		}
	})

	obj = Constructor()
	obj.Add([]int{419, 351})
	obj.Add([]int{798, 351})
	obj.Add([]int{798, 730})
	t.Run("case1", func(t *testing.T) {
		if got := obj.Count([]int{419, 730}); !reflect.DeepEqual(got, 1) {
			t.Errorf("Count() = %v, want %v", got, 1)
		}
	})
}
