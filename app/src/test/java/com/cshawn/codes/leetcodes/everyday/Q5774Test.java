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
 * @date 2021/5/30 12:00 下午
 */
class Q5774Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{3,3,2}, new int[]{1,2,3,2,1,2}, new int[]{2,2,0,2,1,2}),
                    Arguments.of(new int[]{5,1,4,3,2}, new int[]{2,1,2,4,5,2,1}, new int[]{1,4,1,4,1,3,2}),
                    Arguments.of(new int[]{10,63,95,16,85,57,83,95,6,29,71},
                            new int[]{70,31,83,15,32,67,98,65,56,48,38,90,5},
                            new int[]{8, 0, 3, 9, 5, 1, 10, 6, 4, 2, 7, 9, 0})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void assignTasks(int[] servers, int[] tasks ,int[] result) {
        Assertions.assertArrayEquals(result, new Q5774().assignTasks1(servers, tasks));
        Assertions.assertArrayEquals(result, new Q5774().assignTasks(servers, tasks));
    }
}