package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/10/27 5:06 下午
 */
class Q20Test {

    @ParameterizedTest
    @CsvSource({"(),true", "()[]{},true", "(],false", "(()){}[[{()}]],true", "][,false", "([)],false"})
    void isValid(String s, boolean result) {
        assertEquals(result, new Q20().isValid(s));
    }
}