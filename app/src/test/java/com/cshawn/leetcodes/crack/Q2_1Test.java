package com.cshawn.leetcodes.crack;

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
 * @date 2021/2/24 9:45 下午
 */
class Q2_1Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((ListNode)null, (ListNode)null),
                    Arguments.of(new ListNode(1), new ListNode(1)),
                    Arguments.of(new ListNode(1).next(2).next(3), new ListNode(1).next(2).next(3)),
                    Arguments.of(new ListNode(1).next(2).next(1), new ListNode(1).next(2)),
                    Arguments.of(new ListNode(1).next(1).next(2), new ListNode(1).next(2)),
                    Arguments.of(new ListNode(1).next(2).next(3).next(2), new ListNode(1).next(2).next(3)),
                    Arguments.of(new ListNode(1).next(2).next(2).next(2), new ListNode(1).next(2))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeDuplicateNodes1(ListNode head, ListNode result) {
        ListNode l = new Q2_1().removeDuplicateNodes1(head);
        Assertions.assertArrayEquals(result != null ? result.toArray() : null, l != null ? l.toArray() : null);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeDuplicateNodes(ListNode head, ListNode result) {
        ListNode l = new Q2_1().removeDuplicateNodes(head);
        Assertions.assertArrayEquals(result != null ? result.toArray() : null, l != null ? l.toArray() : null);
    }
}