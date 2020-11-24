package com.cshawn.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @Date 2020/11/24 9:55
 */
class Sword_15Test {
    private final Sword_15 test = new Sword_15();

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "9, 2", "2147483647, 31", "-2147483648, 1"})
    void hammingWeight(int n, int count) {
        assertEquals(count, test.hammingWeight(n));
    }
}