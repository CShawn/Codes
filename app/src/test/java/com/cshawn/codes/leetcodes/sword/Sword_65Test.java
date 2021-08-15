package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/1/27 9:19 下午
 */
class Sword_65Test {

    @ParameterizedTest
    @CsvSource({"0,0,0", "1,1,2", "4,7,11", "45,76,121", "-45,76,31", "-42,-22,-64"})
    void add(int a, int b, int sum) {
        Assertions.assertEquals(sum, new Sword_65().add(a, b));
    }

    @ParameterizedTest
    @CsvSource({"0,0,0", "1,1,2", "4,7,11", "45,76,121", "-45,76,31", "-42,-22,-64"})
    void add2(int a, int b, int sum) {
        Assertions.assertEquals(sum, new Sword_65().add2(a, b));
    }
}