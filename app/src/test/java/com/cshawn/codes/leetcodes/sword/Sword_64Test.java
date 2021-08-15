package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/1/27 8:59 下午
 */
class Sword_64Test {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,3", "5,15", "9,45", "100,5050"})
    void sumNums(int n, int sum) {
        Assertions.assertEquals(sum, new Sword_64().sumNums(n));
    }
}