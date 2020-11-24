package com.cshawn.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description
 * @Author C.Shawn
 * @Date 2020/11/24 18:02
 */
class Sword_16Test {
    private final Sword_16 test = new Sword_16();

    @ParameterizedTest
    @CsvSource({"1.3, 0, 1", "1, 343443434, 1", "2, 3, 8", "4, -1, 0.25"})
    void myPow(double x, int n, double power) {
        assertEquals(power, test.myPow(x, n));
    }
}