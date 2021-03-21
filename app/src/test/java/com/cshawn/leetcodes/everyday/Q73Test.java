package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.crack.Q1_8Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @date 2021/3/21 11:00 上午
 */
class Q73Test {

    @ParameterizedTest
    @ArgumentsSource(Q1_8Test.DataArgumentsProvider.class)
    void setZeroes1(int[][] matrix, int[][] result) {
        new Q73().setZeroes1(matrix);
        Assertions.assertArrayEquals(result, matrix);
    }

    @ParameterizedTest
    @ArgumentsSource(Q1_8Test.DataArgumentsProvider.class)
    void setZeroes(int[][] matrix, int[][] result) {
        new Q73().setZeroes(matrix);
        Assertions.assertArrayEquals(result, matrix);
    }
}