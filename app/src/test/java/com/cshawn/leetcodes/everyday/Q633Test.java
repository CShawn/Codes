package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/28 6:46 下午
 */
class Q633Test {

    @ParameterizedTest
    @CsvSource({"0,true", "1,true", "2,true", "3,false", "4,true", "5,true", "10000000,true"})
    void judgeSquareSum(int num, boolean result) {
        Assertions.assertEquals(result, new Q633().judgeSquareSum(num));
    }
}