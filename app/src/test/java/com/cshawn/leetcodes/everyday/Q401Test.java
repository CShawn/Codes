package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
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
                    Arguments.of(2, new String[]{"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"}),
                    Arguments.of(9, new String[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void readBinaryWatch(int turnedOn, String[] result) {
        Arrays.sort(result);
        Object[] res1 = new Q401().readBinaryWatch1(turnedOn).toArray();
        Arrays.sort(res1);
        Assertions.assertArrayEquals(result, res1);
        Object[] res2 = new Q401().readBinaryWatch(turnedOn).toArray();
        Arrays.sort(res2);
        Assertions.assertArrayEquals(result, res2);
    }
}