package com.cshawn.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/1/17 7:05 下午
 */
class Sword_46Test {

    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "88,1", "19,2", "256,2", "124,3", "809090003,1"})
    void translateNum(int num, int count) {
        assertEquals(count, new Sword_46().translateNum(num));
    }
}