package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/6/21 5:49 下午
 */
class Q401Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(1, new String[]{"0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"}),
                    Arguments.of(9, new String[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void readBinaryWatch(int turnedOn, String[] result) {
        Assertions.assertArrayEquals(result, new Q401().readBinaryWatch(turnedOn).toArray());
    }
}