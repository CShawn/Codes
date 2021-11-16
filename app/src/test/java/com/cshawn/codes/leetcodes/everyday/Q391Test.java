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
 * @date 2021/11/16 6:16 下午
 */
class Q391Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}, true),
                    Arguments.of(new int[][]{{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}}, false),
                    Arguments.of(new int[][]{{1,1,3,3},{3,1,4,2},{1,3,2,4},{3,2,4,4}}, false),
                    Arguments.of(new int[][]{{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}}, false)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isRectangleCover(int[][] rectangles, boolean result) {
        assertEquals(result, new Q391().isRectangleCover(rectangles));
    }
}