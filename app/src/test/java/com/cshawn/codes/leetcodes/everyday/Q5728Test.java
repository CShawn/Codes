package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/4/11 11:14 上午
 */
class Q5728Test {

    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{0,1}, 0),
                    Arguments.of(new int[]{0,2}, 1),
                    Arguments.of(new int[]{0,1,2,3,0}, 2),
                    Arguments.of(new int[]{0,1,1,3,3,0}, 0),
                    Arguments.of(new int[]{0,2,1,0,3,0}, 2),
                    Arguments.of(new int[]{0,1,0,1,3,1,1,1,0,2,0}, 1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void minSideJumps(int[] obstacles, int result) {
        Assertions.assertEquals(result, new Q5728().minSideJumps1(obstacles));
        Assertions.assertEquals(result, new Q5728().minSideJumps(obstacles));
    }
}