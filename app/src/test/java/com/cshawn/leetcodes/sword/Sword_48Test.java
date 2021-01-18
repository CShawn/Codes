package com.cshawn.leetcodes.sword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/18 4:48 下午
 */
class Sword_48Test {

    @ParameterizedTest
    @CsvSource({",0", "a,1", "ab,2", "aa,1", "aba,2", "abb,2", "abc,3", "abcddcabde,5"})
    void lengthOfLongestSubstring(String str, int expected) {
        assertEquals(expected, new Sword_48().lengthOfLongestSubstring(str));
    }

    @ParameterizedTest
    @CsvSource({",0", "a,1", "ab,2", "aa,1", "aba,2", "abb,2", "abc,3", "abcddcabde,5"})
    void lengthOfLongestSubstring2(String str, int expected) {
        assertEquals(expected, new Sword_48().lengthOfLongestSubstring2(str));
    }

    @ParameterizedTest
    @CsvSource({",0", "a,1", "ab,2", "aa,1", "aba,2", "abb,2", "abc,3", "abcddcabde,5"})
    void lengthOfLongestSubstring3(String str, int expected) {
        assertEquals(expected, new Sword_48().lengthOfLongestSubstring3(str));
    }
}