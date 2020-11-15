package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/** 
 * @author C.Shawn
 * @date 2020/11/15 19:04
 */
public class Sword_5Test {
    private Sword_5 test = new Sword_5();

    @ParameterizedTest
    @EmptySource()
    public void replaceSpace_empty(String s) {
        assertEquals("", test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    public void replaceSpace_noSpace(String s) {
        assertEquals(s, test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"  "})
    public void replaceSpace_allSpaces(String s) {
        assertEquals("%20%20", test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {" bc"})
    public void replaceSpace_start(String s) {
        assertEquals("%20bc", test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a c"})
    public void replaceSpace_middle(String s) {
        assertEquals("a%20c", test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab "})
    public void replaceSpace_end(String s) {
        assertEquals("ab%20", test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a  d"})
    public void replaceSpace_multiple(String s) {
        assertEquals("a%20%20d", test.replaceSpace(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a c e"})
    public void replaceSpace_several(String s) {
        assertEquals("a%20c%20e", test.replaceSpace(s));
    }
}
