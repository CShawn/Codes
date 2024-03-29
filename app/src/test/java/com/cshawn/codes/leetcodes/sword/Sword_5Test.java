package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** 
 * @author C.Shawn
 * @date 2020/11/15 19:04
 */
public class Sword_5Test {
    private Sword_5 test = new Sword_5();

    @ParameterizedTest
    @CsvSource({
        "' bc',%20bc", 
        "a c,a%20c", 
        "'ab ',ab%20", 
        "a  d,a%20%20d", 
        "a c e,a%20c%20e",
        "abc,abc",
        ",",
        "'   ',%20%20%20"
    })
    public void replaceSpace(String s, String replaced) {
        assertEquals(replaced, test.replaceSpace(s));
    }
}
