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
 * @date 2021/2/25 9:37 下午
 */
class Q2_8Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            return Stream.of(
                    Arguments.of(null, null),
                    Arguments.of(new ListNode(0), null),
                    Arguments.of(new ListNode(1).next(3).next(4), null),
                    Arguments.of(new ListNode(0).next(node1).next(3).next(node1), node1),
                    Arguments.of(new ListNode(1).next(node2).next(3).next(4).next(node2), node2)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void detectCycle(ListNode list, ListNode node) {
        if (node == null) {
            Assertions.assertNull(new Q2_8().detectCycle(list));
        } else {
            Assertions.assertEquals(node.val, new Q2_8().detectCycle(list).val);
        }
    }
}