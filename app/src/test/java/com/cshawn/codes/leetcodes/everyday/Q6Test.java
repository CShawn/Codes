package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/15 10:54 上午
 */
class Q6Test {

    @ParameterizedTest
    @CsvSource({"abc,0,abc", "abc,1,abc", "abcd,2,acbd", "PAYPALISHIRING,3,PAHNAPLSIIGYIR", "PAYPALISHIRING,4,PINALSIGYAHRPI", "A,1,A"})
    void convert(String s, int row, String result) {
        Assertions.assertEquals(result, new Q6().convert(s, row));
    }
}