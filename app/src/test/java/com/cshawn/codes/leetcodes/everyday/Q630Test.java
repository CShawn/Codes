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
 * @date 2021/12/14 8:37 上午
 */
class Q630Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[][]{{100, 200},{200, 1300},{1000, 1250},{2000, 3200}}, 3),
                    Arguments.of(new int[][]{{1,2}}, 1),
                    Arguments.of(new int[][]{{1,2},{2,5},{1,5}}, 3),
                    Arguments.of(new int[][]{{3,2},{4,3}}, 0),
                    Arguments.of(new int[][]{{5,5},{4,6},{2,6}}, 2)
            );
        }
    }
    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void scheduleCourse(int[][] courses, int result) {
        assertEquals(result, new Q630().scheduleCourse(courses));
    }
}