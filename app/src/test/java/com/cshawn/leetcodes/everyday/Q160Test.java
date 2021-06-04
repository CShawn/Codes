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
 * @date 2021/6/4 2:28 下午
 */
class Q160Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            ListNode common = new ListNode(7).next(8).next(9);
            return Stream.of(
//                    Arguments.arguments(
//                            new ListNode(1).next(2).next(common),
//                            null,
//                            null
//                    ),
//                    Arguments.arguments(
//                            null,
//                            new ListNode(1).next(2).next(common),
//                            null
//                    ),
//                    Arguments.arguments(
//                            null,
//                            null,
//                            null
//                    ),
//                    Arguments.arguments(
//                            new ListNode(1).next(2).next(common),
//                            new ListNode(3).next(4).next(5).next(common),
//                            common
//                    ),
//                    Arguments.arguments(
//                            new ListNode(1).next(2).next(common),
//                            new ListNode(3).next(4).next(common),
//                            common
//                    ),
//                    Arguments.arguments(
//                            common,
//                            common,
//                            common
//                    ),
                    Arguments.arguments(
                            new ListNode(1).next(2).next(3),
                            new ListNode(3).next(4),
                            null
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void getIntersectionNode(ListNode headA, ListNode headB, ListNode result) {
        Assertions.assertEquals(result, new Q160().getIntersectionNode1(headA, headB));
        Assertions.assertEquals(result, new Q160().getIntersectionNode2(headA, headB));
        Assertions.assertEquals(result, new Q160().getIntersectionNode3(headA, headB));
        Assertions.assertEquals(result, new Q160().getIntersectionNode(headA, headB));
    }
}