package com.cshawn.codes.leetcodes.everyday;

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
 * @date 2021/9/22 4:44 下午
 */
class Q725Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new ListNode(new int[]{1,2,3}), 5, new int[][]{{1}, {2}, {3}, {}, {}}),
                    Arguments.of(new ListNode(new int[]{1,2,3}), 4, new int[][]{{1}, {2}, {3}, {}}),
                    Arguments.of(new ListNode(new int[]{1,2,3}), 3, new int[][]{{1}, {2}, {3}}),
                    Arguments.of(new ListNode(new int[]{1,2,3}), 2, new int[][]{{1,2}, {3}}),
                    Arguments.of(new ListNode(new int[]{1,2,3}), 1, new int[][]{{1,2,3}}),
                    Arguments.of(new ListNode(new int[]{1,2,3,4,5,6,7,8,9,10}), 3, new int[][]{{1,2,3,4},{5,6,7},{8,9,10}}),
                    Arguments.of(new ListNode(new int[]{1,2,3,4,5,6,7,8,9,10,11}), 3, new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11}})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void splitListToParts1(ListNode head, int k, int[][] result) {
        ListNode[] res = new Q725().splitListToParts1(head, k);
        int[][] arr = new int[res.length][];
        for (int i = 0; i < res.length; i++) {
            if (res[i] != null) {
                arr[i] = res[i].toArray();
            } else {
                arr[i] = new int[0];
            }
        }
        assertArrayEquals(result, arr);
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void splitListToParts(ListNode head, int k, int[][] result) {
        ListNode[] res = new Q725().splitListToParts(head, k);
        int[][] arr = new int[res.length][];
        for (int i = 0; i < res.length; i++) {
            if (res[i] != null) {
                arr[i] = res[i].toArray();
            } else {
                arr[i] = new int[0];
            }
        }
        assertArrayEquals(result, arr);
    }
}