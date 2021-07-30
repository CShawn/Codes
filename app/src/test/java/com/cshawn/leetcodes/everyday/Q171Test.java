package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/30 3:07 下午
 */
class Q171Test {

    @ParameterizedTest
    @CsvSource({"1,A", "26,Z", "27,AA", "52,AZ", "676,YZ", "702,ZZ", "2147483647,FXSHRXW"})
    void titleToNumber(int result, String columnTitle) {
        Assertions.assertEquals(result, new Q171().titleToNumber(columnTitle));
    }
}