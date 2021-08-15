package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description
 * @Author C.Shawn
 * @Date 2020/11/23 19:45
 */
class Sword_14Test {
    private Sword_14 test = new Sword_14();
    @ParameterizedTest
    @CsvSource({"2, 1", "3, 2", "4, 4", "5, 6", "10, 36", "58, 1549681956"})
    void cuttingRope(int n, int expected) {
        assertEquals(expected, test.cuttingRope(n));
    }
}