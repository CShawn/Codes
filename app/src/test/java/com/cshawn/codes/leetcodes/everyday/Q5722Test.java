package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/4 12:41 下午
 */
class Q5722Test {

    @ParameterizedTest
    @CsvSource({
            "Hello how are you Contestant,4,Hello how are you",
            "What is the solution to this problem,4,What is the solution",
            "chopper is not a tanuki,5,chopper is not a tanuki"
    })
    void truncateSentence(String s, int k, String result) {
        Assertions.assertEquals(result, new Q5722().truncateSentence(s, k));
    }
}