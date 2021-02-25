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
 * @date 2021/2/25 12:54 下午
 */
class Q2_2Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of((ListNode)null, -8, -1),
                    Arguments.of((ListNode)null, 3, -1),
                    Arguments.of((ListNode)null, 0, -1),
                    Arguments.of(new ListNode(1), 0, -1),
                    Arguments.of(new ListNode(1), -1, -1),
                    Arguments.of(new ListNode(1), 0, -1),
                    Arguments.of(new ListNode(1), 1, 1),
                    Arguments.of(new ListNode(1), 2, -1),
                    Arguments.of(new ListNode(1).next(2).next(3), 1, 3),
                    Arguments.of(new ListNode(1).next(2).next(3), 2, 2),
                    Arguments.of(new ListNode(1).next(2).next(3), 3, 1),
                    Arguments.of(new ListNode(1).next(2).next(3), 4, -1),
                    Arguments.of(new ListNode(1).next(2).next(3), -1, -1),
                    Arguments.of(new ListNode(1).next(2).next(3), 0, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void kthToLast(ListNode head, int k, int result) {
        Assertions.assertEquals(result, new Q2_2().kthToLast(head, k));
    }
}