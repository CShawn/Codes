package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/4/18 11:19 上午
 */
class Q5734Test {

    @ParameterizedTest
    @CsvSource({"thequickbrownfoxjumpsoverthelazydog,true", "adgdfsaf,false"})
    void checkIfPangram(String s, boolean result) {
        Assertions.assertEquals(result, new Q5734().checkIfPangram(s));
    }
}