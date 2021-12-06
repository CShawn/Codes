package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/6 2:17 下午
 */
class Q1816Test {

    @ParameterizedTest
    @CsvSource({
            "Hello how are you Contestant,4,Hello how are you",
            "Hello how are you Contestant,1,Hello",
            "What is the solution to this problem,4,What is the solution",
            "chopper is not a tanuki,5,chopper is not a tanuki"
    })
    void truncateSentence(String s, int k, String result) {
        assertEquals(result, new Q1816().truncateSentence(s, k));
    }
}