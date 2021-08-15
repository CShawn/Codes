package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/1/27 11:44 上午
 */
class Sword_62Test {

    @ParameterizedTest
    @CsvSource({"1,1,0", "1,8,0", "2,1,1", "5,1,4", "5,2,2", "5,3,3", "10,17,2"})
    void lastRemaining(int n, int m, int last) {
        Assertions.assertEquals(last, new Sword_62().lastRemaining(n, m));
        Assertions.assertEquals(last, new Sword_62().lastRemaining2(n, m));
        Assertions.assertEquals(last, new Sword_62().lastRemaining3(n, m));
    }
}