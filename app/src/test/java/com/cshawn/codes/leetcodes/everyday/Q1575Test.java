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
 * @date 2021/8/3 6:42 下午
 */
class Q1575Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{2,3,6,8,4}, 1, 3, 5, 4),
                    Arguments.of(new int[]{4,3,1}, 1, 0, 6, 5),
                    Arguments.of(new int[]{5,2,1}, 0, 2, 3, 0),
                    Arguments.of(new int[]{2,1,5}, 0, 0, 3, 2),
                    Arguments.of(new int[]{1,2,3}, 0, 2, 40, 615088286)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void countRoutes(int[] locations, int start, int finish, int fuel, int result) {
        Assertions.assertEquals(result, new Q1575().countRoutes1(locations, start, finish, fuel));
        Assertions.assertEquals(result, new Q1575().countRoutes(locations, start, finish, fuel));
    }
}