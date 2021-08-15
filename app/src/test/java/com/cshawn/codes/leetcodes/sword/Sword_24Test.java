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
 * @Date 2020/12/08 22:17
 */
public class Sword_24Test {
    private Sword_24 test = new Sword_24();

    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of((ListNode)null, (ListNode)null),
                Arguments.of(new ListNode(1), new ListNode(1)),
                Arguments.of(new ListNode(1).next(2).next(3), new ListNode(3).next(2).next(1))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void reverseList(ListNode head, ListNode reverse) {
        assertEquals(reverse, test.reverseList(head));
    }
}
