package com.cshawn.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @Date 2020/11/28 20:24
 */
public class Sword_21Test {
    public static class ArrayArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of(new int[0]),
                Arguments.of(new int[]{1, 3}),
                Arguments.of(new int[]{1, 2, 3}),
                Arguments.of(new int[]{2, 1, 3}),
                Arguments.of(new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1}),
                Arguments.of(new int[]{1, 3, 2})
            );
        }
    }
    private Sword_21 test = new Sword_21();
    @ParameterizedTest
    @ArgumentsSource(ArrayArgumentsProvider.class)
    public void exchange(int[] nums) {
        if (nums.length == 0 || nums[0] % 2 == 0) {
            assertArrayEquals(nums, test.exchange(nums));
        } else {
            int[] result = test.exchange(nums);
            int evenIndex = -1;
            boolean inOrder = true;
            for (int i = 0; i < result.length; i++) {
                if (evenIndex == -1) {
                    if (nums[i] % 2 == 0) {
                        evenIndex = i;
                    }
                } else {
                    if (nums[i] % 2 != 0) {
                        inOrder = false;
                    }
                }
            }
            assertTrue(inOrder);
        }
    }
}
