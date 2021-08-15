package com.cshawn.codes;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @Date 2020/11/24 23:03
 */
public class ListNodeTest {
    public static class ListNodeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                Arguments.of((ListNode)null, 0, (int[])null),
                Arguments.of(new ListNode(1), 1, new int[]{1}),
                Arguments.of(new ListNode(1).next(2), 2, new int[]{1, 2}),
                Arguments.of(new ListNode(1).next(2).next(3), 3, new int[]{1, 2, 3})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void toArray(ListNode head, int size, int[] array){
        assertEquals(size, head != null ? head.getSize() : 0);
        assertArrayEquals(array, head != null ? head.toArray() : null);
    }

    @ParameterizedTest
    @ArgumentsSource(ListNodeArgumentsProvider.class)
    public void equals(ListNode head){
        assertEquals(head, head);
    }
}
