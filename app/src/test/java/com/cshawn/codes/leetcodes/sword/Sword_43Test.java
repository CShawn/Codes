package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/1/12 10:25 下午
 */
class Sword_43Test {

    @ParameterizedTest
    @CsvSource({"0,0", "6,1", "10,2", "12,5", "13,6", "20,12", "258,156"})
    void countDigitOne(int n, int count) {
        assertEquals(count, new Sword_43().countDigitOne(n));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "6,1", "10,2", "12,5", "13,6", "20,12", "258,156"})
    void countDigitOne2(int n, int count) {
        assertEquals(count, new Sword_43().countDigitOne2(n));
    }
}