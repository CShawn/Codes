package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/12/19 11:22 上午
 */
class Q997Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, new int[][]{{1,2}}, 2),
                    Arguments.of(3, new int[][]{{1,3},{2,3}}, 3),
                    Arguments.of(3, new int[][]{{1,3},{2,3},{3,1}}, -1),
                    Arguments.of(3, new int[][]{{1,2},{2,3}}, -1),
                    Arguments.of(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findJudge(int n, int[][] trust, int result) {
        assertEquals(result, new Q997().findJudge(n, trust));
    }
}