package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @Date 2020/11/24 22:24
 */
public class Sword_17Test {
    private final Sword_17 test = new Sword_17();

    @ParameterizedTest
    @CsvSource({"1, 9, '1', '9'","2, 99, '1', '99'"})
    void myPow(int n, long count, String start, String end) {
        String[] s = test.printNumbers(n);
        assertEquals(count, s.length);
        assertEquals(start, s[0]);
        assertEquals(end, s[s.length - 1]);
    }
}
