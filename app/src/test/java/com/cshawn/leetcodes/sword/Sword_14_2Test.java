package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @Date 2020/11/23 23:39
 */
public class Sword_14_2Test {
    private Sword_14_2 test = new Sword_14_2();
    @ParameterizedTest
    @CsvSource({"2, 1", "3, 2", "4, 4", "5, 6", "10, 36", "58, 549681949", "1000, 620946522"})
    void cuttingRope(int n, int expected) {
        assertEquals(expected, test.cuttingRope(n));
    } 
}
