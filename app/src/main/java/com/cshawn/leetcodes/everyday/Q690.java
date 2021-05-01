package com.cshawn.leetcodes.everyday;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Integer;
/**
 * 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度和直系下属的id 。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 * 
 * 示例：
 * 
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 * 
 * 提示：
 * 
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author C.Shawn
 * @date 2021/3/29 4:33 下午
 */
class Q690 {
    // 散列表+深度优先遍历
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Employee e = map.get(id);
        if (e == null) {
            return 0;
        }
        return getImportance(map,  id);
    }
    
    private int dfs(Map<Integer, Employee> map, int id) {
	    Employee e = map.get(id);
        int result = e.importance;
        if (e.subordinates == null || e.subordinates.isEmpty()) {
            return result;
        }
        for (Integer sId : e.subordinates) {
            result += dfs(map, sId);
        }
        return result;
    }

    class Employee {
        public int id;
        public int importance;
    	public List<Integer> subordinates;
    }
}
