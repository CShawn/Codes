package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/8/19 9:17 上午
 */
class Q345Test {

    @ParameterizedTest
    @CsvSource({"hello,holle", "acefo,ocefa", "leetcode,leotcede", "aeiou,uoiea","aeppicod,oippecad", "aA,Aa"})
    void reverseVowels(String s, String result) {
        Assertions.assertEquals(result, new Q345().reverseVowels1(s));
        Assertions.assertEquals(result, new Q345().reverseVowels(s));
    }
}