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
 * @date 2021/2/25 9:20 下午
 */
class Q2_7Test {
    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            ListNode node = new ListNode(6);
            ListNode node2 = new ListNode(7);
            return Stream.of(
                    Arguments.of(null, null, null),
                    Arguments.of(new ListNode(1), null, null),
                    Arguments.of(null, new ListNode(1), null),
                    Arguments.of(new ListNode(1), new ListNode(2), null),
                    Arguments.of(new ListNode(1).next(node), new ListNode(2).next(node), node),
                    Arguments.of(new ListNode(1).next(2).next(node2).next(0), new ListNode(4).next(5).next(6).next(node2).next(8).next(9), node2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    void getIntersectionNode1(ListNode a, ListNode b, ListNode intersection) {
        Assertions.assertEquals(intersection, new Q2_7().getIntersectionNode1(a, b));
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    void getIntersectionNode(ListNode a, ListNode b, ListNode intersection) {
        Assertions.assertEquals(intersection, new Q2_7().getIntersectionNode(a, b));
    }
}