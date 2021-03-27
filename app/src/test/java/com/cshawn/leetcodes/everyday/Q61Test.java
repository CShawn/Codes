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
 * @date 2021/3/27 9:37 上午
 */
class Q61Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(null, 5, new int[0]),
                    Arguments.arguments(new ListNode(1), 0, new int[]{1}),
                    Arguments.arguments(new ListNode(1), 1, new int[]{1}),
                    Arguments.arguments(new ListNode(1), 2, new int[]{1}),
                    Arguments.arguments(new ListNode(1), 3, new int[]{1}),
                    Arguments.arguments(new ListNode(1).next(2), 0, new int[]{1,2}),
                    Arguments.arguments(new ListNode(1).next(2), 1, new int[]{2,1}),
                    Arguments.arguments(new ListNode(1).next(2), 2, new int[]{1,2}),
                    Arguments.arguments(new ListNode(1).next(2), 3, new int[]{2,1}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 0, new int[]{1,2,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 1, new int[]{3,1,2}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 2, new int[]{2,3,1}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 3, new int[]{1,2,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), 4, new int[]{3,1,2})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void rotateRight1(ListNode node, int k, int[] result) {
        ListNode list = new Q61().rotateRight1(node, k);
        Assertions.assertArrayEquals(result, list != null ? list.toArray() : new int[0]);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void rotateRight(ListNode node, int k, int[] result) {
        ListNode list = new Q61().rotateRight(node, k);
        Assertions.assertArrayEquals(result, list != null ? list.toArray() : new int[0]);
    }
}