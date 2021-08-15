package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/3/12 3:28 下午
 */
class Q331Test {

    @ParameterizedTest
    @CsvSource(delimiterString = ";", value = {
            ";false",
            "'';false",
            "1;false",
            "9,3,4,#,#,1,#,#,2,#,6,#,#;true",
            "1,#;false",
            "9,#,#,1;false"
    })
    void isValidSerialization1(String s, boolean result) {
        Assertions.assertEquals(result, new Q331().isValidSerialization1(s));
        Assertions.assertEquals(result, new Q331().isValidSerialization2(s));
        Assertions.assertEquals(result, new Q331().isValidSerialization3(s));
        Assertions.assertEquals(result, new Q331().isValidSerialization4(s));
    }
}