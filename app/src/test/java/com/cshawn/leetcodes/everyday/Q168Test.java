package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/6/29 21:10
 */
public class Q168Test {
    @ParameterizedTest
    @CsvSource({"1,A", "26,Z", "27,AA", "52,AZ", "676,YZ", "702,ZZ", "2147483647,FXSHRXW"})
    void convertToTitle(int columnNumber, String result) {
        Assertions.assertEquals(result, new Q168().convertToTitle(columnNumber));
    }
}
