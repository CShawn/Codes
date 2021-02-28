package com.cshawn.leetcodes.crack;

/**
 * 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * 
 * 示例1:
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
  * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 
 * 示例2:
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/2/28 21:21
 */
public class Q3_1 {
    class TripleInOne {
        private int[] aux;
        // 记录当前栈顶所指的位置
        private int[] positions;
        private int size;
        public TripleInOne(int stackSize) {
            size = stackSize;
            aux = new int[stackSize * 3];
            positions = new int[stackSize];
            // 初始化每个栈所指的位置
            for (int i = 0; i < stackSize; i++) {
                positions[i] = i * size;
            }
        }
        
        public void push(int stackNum, int value) {
            if (stackNum >= 0 && stackNum < size && positions[stackNum] < (stackNum + 1) * size) {
                aux[positions[stackNum]++] = value;
            }
        }
        
        public int pop(int stackNum) {
            if (stackNum < 0 || stackNum >= size || positions[stackNum] == stackNum * size) {
                return -1;
            }
            return aux[--positions[stackNum]];
        }
        
        public int peek(int stackNum) {
            if (stackNum < 0 || stackNum >= size || positions[stackNum] == stackNum * size) {
                return -1;
            }
            return aux[positions[stackNum] - 1];
        }
        
        public boolean isEmpty(int stackNum) {
            return stackNum < 0 || stackNum >= size || positions[stackNum] == stackNum * size;
        }
    }
}