package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author C.Shawn
 * @date 2021/5/4 11:03 下午
 */
class Q690Test {

    @Test
    void getImportance() {
        //[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1, 11
        List<Q690.Employee> list = new ArrayList<>();
        list.add(new Q690.Employee(1, 5, 2, 3));
        list.add(new Q690.Employee(2, 3));
        list.add(new Q690.Employee(3, 3));
        Assertions.assertEquals(11, new Q690().getImportance(list, 1));
    }
}