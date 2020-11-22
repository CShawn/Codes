package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2020/11/22 21:11
 */
public class Sword_13Test {
    private Sword_13 test = new Sword_13();
    @ParameterizedTest
    @CsvSource({"2,3,1,3", "3,1,0,1", "0,1,3,0", "12,4,11,47"})
    public void movingCount(int m, int n, int k, int count) {
        assertEquals(count, test.movingCount(m, n, k));
    }
}
