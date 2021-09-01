package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/1 9:05 上午
 */
class Q165Test {

    @ParameterizedTest
    @CsvSource({"1.01,1.001,0", "1.0,1.0.0,0", "1.0,1.0.1,-1", "0.1,1.0,-1", "1.0.1,1,1", "1.0.1,001.0.001,0", "7.5.2.4,7.5.3,-1"})
    void compareVersion(String version1, String version2, int result) {
        assertEquals(result, new Q165().compareVersion(version1, version2));
    }
}