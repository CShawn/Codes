package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/9/25 11:07 上午
 */
class Q583Test {

    @ParameterizedTest
    @CsvSource({"sea,eat,2", "a,a,0", "a,b,2", "ac,bd,4", "abc,abc,0", "bc,abdbec,4"})
    void minDistance(String word1, String word2, int result) {
        assertEquals(result, new Q583().minDistance1(word1, word2));
        assertEquals(result, new Q583().minDistance(word1, word2));
    }
}