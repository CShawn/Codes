package com.cshawn.codes.leetcodes.sword;

import com.cshawn.codes.ListNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/19 8:08 下午
 */
class Sword_52Test {
    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            ListNode node = new ListNode(6);
            return Stream.of(
                    Arguments.of(null, null, null),
                    Arguments.of(new ListNode(1), null, null),
                    Arguments.of(null, new ListNode(1), null),
                    Arguments.of(new ListNode(1).next(node), new ListNode(2), null),
                    Arguments.of(new ListNode(1).next(node), new ListNode(2).next(node), node),
                    Arguments.of(new ListNode(1).next(2).next(node), new ListNode(4).next(5).next(6).next(node), node)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    void getIntersectionNode(ListNode a, ListNode b, ListNode intersection) {
        assertEquals(intersection, new Sword_52().getIntersectionNode(a, b));
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    void getIntersectionNode2(ListNode a, ListNode b, ListNode intersection) {
        assertEquals(intersection, new Sword_52().getIntersectionNode2(a, b));
    }
}