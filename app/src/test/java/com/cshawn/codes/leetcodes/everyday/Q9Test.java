package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/15 10:15 下午
 */
class Q9Test {

    @ParameterizedTest
    @CsvSource({"0,true", "1,true", "-9,false", "12,false", "121,true", "1221,true", "222,true", "220,false"})
    void isPalindrome(int x, boolean isPalindrome) {
        Assertions.assertEquals(isPalindrome, new Q9().isPalindrome(x));
    }
}