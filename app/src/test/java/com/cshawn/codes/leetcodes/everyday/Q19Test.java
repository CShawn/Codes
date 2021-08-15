package com.cshawn.codes.leetcodes.everyday;


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
 * @date 2021/7/21 6:10 下午
 */
class Q19Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,2,3,4,5}, 1, new int[]{1,2,3,4}),
                    Arguments.of(new int[]{1}, 1, new int[0]),
                    Arguments.of(new int[]{1,2}, 2, new int[]{2})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void removeNthFromEnd(int[] list, int n, int[] result) {
        ListNode node = new Q19().removeNthFromEnd(new ListNode(list), n);
        Assertions.assertArrayEquals(result, node != null ? node.toArray() : new int[0]);
    }
}