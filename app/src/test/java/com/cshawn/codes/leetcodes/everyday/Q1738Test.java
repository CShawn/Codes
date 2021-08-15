package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class Q1738Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{5,2},{1,6}}, 1, 7),
                    Arguments.of(new int[][]{{5,2},{1,6}}, 2, 5),
                    Arguments.of(new int[][]{{5,2},{1,6}}, 3, 4),
                    Arguments.of(new int[][]{{5,2},{1,6}}, 4, 0)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void kthLargestValue(int[][] matrix, int k, int result) {
        Assertions.assertEquals(result, new Q1738().kthLargestValue(matrix, k));
    }
}
