package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/10/4 1:31 下午
 */
class Q482Test {

    @ParameterizedTest
    @CsvSource({"5F3Z-2e-9-w,4,5F3Z-2E9W", "2-5g-3-J,2,2-5G-3J", "-1--3--t-5,2,13-T5", "---,3,''"})
    void licenseKeyFormatting(String s, int k, String result) {
        assertEquals(result, new Q482().licenseKeyFormatting(s, k));
    }
}