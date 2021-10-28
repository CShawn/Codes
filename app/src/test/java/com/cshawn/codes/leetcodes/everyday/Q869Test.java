package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/28 2:09 下午
 */
class Q869Test {

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,false","4,true","46,true","61,true","10,false","812,true","1240,true", "200,false", "76823,true", "55663,true", "65536,true"})
    void reorderedPowerOf2(int n, boolean result) {
        assertEquals(result, new Q869().reorderedPowerOf2_1(n));
        assertEquals(result, new Q869().reorderedPowerOf2(n));
    }
}