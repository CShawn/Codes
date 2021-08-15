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
 * @date 2021/2/25 8:42 下午
 */
class Q2_5Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new ListNode(0), new ListNode(6), new int[]{6}),
                    Arguments.of(new ListNode(4).next(3), new ListNode(2), new int[]{6,3}),
                    Arguments.of(new ListNode(4), new ListNode(2).next(3), new int[]{6,3}),
                    Arguments.of(new ListNode(4).next(5), new ListNode(8).next(3), new int[]{2,9}),
                    Arguments.of(new ListNode(4).next(5), new ListNode(9).next(5), new int[]{3,1,1})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void addTwoNumbers1(ListNode node1, ListNode node2, int[] result) {
        Assertions.assertArrayEquals(result, new Q2_5().addTwoNumbers1(node1, node2).toArray());
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void addTwoNumbers(ListNode node1, ListNode node2, int[] result) {
        Assertions.assertArrayEquals(result, new Q2_5().addTwoNumbers(node1, node2).toArray());
    }
}