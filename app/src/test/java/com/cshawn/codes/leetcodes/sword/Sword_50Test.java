package com.cshawn.codes.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/18 10:04 下午
 */
class Sword_50Test {

    @ParameterizedTest
    @CsvSource({"abc,a", "aabb,' '", ",' '", "abcab,c"})
    void firstUniqChar(String str, char ch) {
        assertEquals(ch, new Sword_50().firstUniqChar(str));
    }

    @ParameterizedTest
    @CsvSource({"abc,a", "aabb,' '", ",' '", "abcab,c"})
    void firstUniqChar2(String str, char ch) {
        assertEquals(ch, new Sword_50().firstUniqChar2(str));
    }
}