package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/18 5:30 下午
 */
class Q92Test {

    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new ListNode(1), 1, 1, new int[]{1}),
                    Arguments.arguments(new ListNode(1).next(2), 1, 1, new int[]{1,2}),
                    Arguments.arguments(new ListNode(1).next(2), 2, 2, new int[]{1,2}),
                    Arguments.arguments(new ListNode(1).next(2), 1, 2, new int[]{2,1}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 1, 1, new int[]{1,2,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 1, 2, new int[]{2,1,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 2, 2, new int[]{1,2,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 2, 3, new int[]{1,3,2}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 3, 3, new int[]{1,2,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 1, 3, new int[]{3,2,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void reverseBetween1(ListNode list, int left, int right, int[] result) {
        Assertions.assertArrayEquals(result, new Q92().reverseBetween1(list, left, right).toArray());
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void reverseBetween(ListNode list, int left, int right, int[] result) {
        Assertions.assertArrayEquals(result, new Q92().reverseBetween(list, left, right).toArray());
    }
}