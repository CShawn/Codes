package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2020/11/18 22:46
 */
public class Sword_10_1Test {
    private Sword_10_1 test = new Sword_10_1();
    @ParameterizedTest(name = "n = {0}, expected = {1}")
    @CsvSource({"0, 0", "1, 1", "2, 1", "6, 8", "45, 134903163", "100, 687995182"})
    public void fib(int n, int expected) {
        assertEquals(expected, test.fib(n));
    }
}
