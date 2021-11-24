package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/11/24 3:25 下午
 */
class Q423Test {

    @ParameterizedTest
    @CsvSource({"one,1", "zerozero,00","owoztneoer,012", "fviefuro,45", "owozenttshveegneveiiofer,012578"})
    void originalDigits(String s, String result) {
        assertEquals(result, new Q423().originalDigits1(s));
        assertEquals(result, new Q423().originalDigits(s));
    }
}