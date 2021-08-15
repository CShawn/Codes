package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/14 9:31 下午
 */
class Sword_44Test {

    @ParameterizedTest
    @CsvSource({"0,0", "9,9", "10,1", "189,9", "190,1", "647,5", "999483,8", "1000000000,1"})
    void findNthDigit(int n, int digit) {
        assertEquals(digit, new Sword_44().findNthDigit(n));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "9,9", "10,1", "189,9", "190,1", "647,5", "999483,8", "1000000000,1"})
    void findNthDigit2(int n, int digit) {
        assertEquals(digit, new Sword_44().findNthDigit2(n));
    }
}