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
 * @date 2021/3/25 8:48 上午
 */
class Q82Test {
    static class DataArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.arguments(new ListNode(1), new int[]{1}),
                    Arguments.arguments(new ListNode(1).next(2), new int[]{1,2}),
                    Arguments.arguments(new ListNode(1).next(2).next(2), new int[]{1}),
                    Arguments.arguments(new ListNode(1).next(1).next(2), new int[]{2}),
                    Arguments.arguments(new ListNode(1).next(1), new int[0]),
                    Arguments.arguments(new ListNode(1).next(1).next(2).next(2), new int[0]),
                    Arguments.arguments(new ListNode(1).next(2).next(2).next(3), new int[]{1,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(3), new int[]{1,2,3}),
                    Arguments.arguments(new ListNode(1).next(2).next(2).next(3).next(3), new int[]{1}),
                    Arguments.arguments(new ListNode(1).next(2).next(3).next(3).next(3), new int[]{1,2})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void deleteDuplicates1(ListNode list, int[] result) {
        ListNode node = new Q82().deleteDuplicates1(list);
        Assertions.assertArrayEquals(result, node != null ? node.toArray() : new int[0]);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void deleteDuplicates2(ListNode list, int[] result) {
        ListNode node = new Q82().deleteDuplicates2(list);
        Assertions.assertArrayEquals(result, node != null ? node.toArray() : new int[0]);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentProvider.class)
    void deleteDuplicates3(ListNode list, int[] result) {
        ListNode node = new Q82().deleteDuplicates3(list);
        Assertions.assertArrayEquals(result, node != null ? node.toArray() : new int[0]);
    }
}