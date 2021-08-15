package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.cshawn.codes.ListNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @Date 2020/12/08 21:14
 */
public class Sword_22Test {

    private Sword_22 test = new Sword_22();
    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of((ListNode)null, 5, (Integer)null),
                Arguments.of(new ListNode(1), -2, (Integer)null),
                Arguments.of(new ListNode(1), 2, (Integer)null),
                Arguments.of(new ListNode(1), 1, 1),
                Arguments.of(new ListNode(1).next(2).next(3), 3, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void getKthFromEnd(ListNode head, int k, Integer expected) {
        ListNode node = test.getKthFromEnd(head, k);
        assertEquals(expected != null ? expected.intValue() : null, node != null ? node.val : null);
    }
}
