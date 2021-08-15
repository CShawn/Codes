package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/7/3 11:26 上午
 */
class Q451Test {

    @ParameterizedTest
    @CsvSource({"tree,eert,eetr", "cccaaa,cccaaa,aaaccc", "Aabb,bbAa,bbaA"})
    void frequencySort1(String s, String result, String result2) {
        Q451 test = new Q451();
        Assertions.assertTrue(result.equals(test.frequencySort1(s)) || result2.equals(test.frequencySort1(s)));
        Assertions.assertTrue(result.equals(test.frequencySort2(s)) || result2.equals(test.frequencySort2(s)));
        Assertions.assertTrue(result.equals(test.frequencySort3(s)) || result2.equals(test.frequencySort3(s)));
        Assertions.assertTrue(result.equals(test.frequencySort(s)) || result2.equals(test.frequencySort(s)));
    }
}