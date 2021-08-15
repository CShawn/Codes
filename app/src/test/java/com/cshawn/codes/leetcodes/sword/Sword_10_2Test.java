package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2020/11/19 18:17
 */
class Sword_10_2Test {
    private Sword_10_2 test = new Sword_10_2();
    @ParameterizedTest(name = "n = {0}, expected = {1}")
    @CsvSource({"0, 0", "1, 1", "2, 2", "6, 13", "45, 836311896", "100, 782204094"})
    void numWays(int n, int ways) {
        assertEquals(ways, test.numWays(n));
    }
}