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
 * @date 2021/6/5 10:18
 */
public class Q203Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of(new ListNode(1).next(2).next(3), 1, new int[]{2,3}),
                Arguments.of(new ListNode(1).next(2).next(3), 2, new int[]{1,3}),
                Arguments.of(new ListNode(1).next(2).next(3), 3, new int[]{1,2}),
                Arguments.of(new ListNode(1).next(2).next(3).next(3).next(3), 3, new int[]{1,2}),
                Arguments.of(new ListNode(1).next(2).next(3).next(3).next(4), 3, new int[]{1,2,4}),
                Arguments.of(new ListNode(1).next(1).next(3).next(3).next(4), 1, new int[]{3,3,4}),
                Arguments.of(null, 1, null)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeElements1(ListNode head, int val, int[] result) {
        ListNode res = new Q203().removeElements1(head, val);
        Assertions.assertArrayEquals(result, res != null ? res.toArray(): null);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeElements(ListNode head, int val, int[] result) {
        ListNode res = new Q203().removeElements(head, val);
        Assertions.assertArrayEquals(result, res != null ? res.toArray(): null);
    }
}
