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
 * @date 2021/6/25 7:57 下午
 */
class Q752Test {

    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"0201","0101","0102","1212","2002"}, "0202", 6),
                    Arguments.of(new String[]{"8888"}, "0009", 1),
                    Arguments.of(new String[]{"0000"}, "8888", -1),
                    Arguments.of(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888", -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void openLock(String[] deadends, String target, int result) {
        Assertions.assertEquals(result, new Q752().openLock1(deadends, target));
        Assertions.assertEquals(result, new Q752().openLock2(deadends, target));
        Assertions.assertEquals(result, new Q752().openLock(deadends, target));
    }
}