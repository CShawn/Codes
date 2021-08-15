package com.cshawn.codes.leetcodes.crack;

import com.cshawn.codes.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/2/25 10:27 下午
 */
class Q2_6Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new ListNode(0), true, new int[]{0}),
                    Arguments.of(new ListNode(4).next(3), false, new int[]{4,3}),
                    Arguments.of(new ListNode(2).next(2), true, new int[]{2,2}),
                    Arguments.of(new ListNode(4).next(4).next(4), true, new int[]{4,4,4}),
                    Arguments.of(new ListNode(3).next(3).next(5), false, new int[]{3,3,5})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isPalindrome1(ListNode list, boolean result, int[] array) {
        Assertions.assertEquals(result, new Q2_6().isPalindrome1(list));
        Assertions.assertArrayEquals(array, list.toArray());
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isPalindrome(ListNode list, boolean result, int[] array) {
        Assertions.assertEquals(result, new Q2_6().isPalindrome(list));
        Assertions.assertArrayEquals(array, list.toArray());
    }
}