package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Sword_3Test {
    Sword_3 test = new Sword_3();

    @ParameterizedTest
    @MethodSource
    public void findRepeatNumber(int[] nums) {
        int find = test.findRepeatNumber(nums);
        assertEquals(2, find);
    }
    
    @ParameterizedTest
    @MethodSource
    public void findRepeatNumber_none(int[] nums) {
        int find = test.findRepeatNumber(nums);
        assertEquals(-1, find);
    }

    static Stream<int[]> findRepeatNumber() {
        return Stream.of(new int[]{2, 3, 1, 0, 2, 5, 3});
    }

    static Stream<int[]> findRepeatNumber_none() {
        return Stream.of(new int[]{0,1,2});
    }
}
