package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/12/28 8:05 下午
 */
class Q472Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}, new String[]{"catsdogcats","dogcatsdog","ratcatdogcat"}),
                    Arguments.of(new String[]{"cat","dog","catdog"}, new String[]{"catdog"}),
                    Arguments.of(new String[]{"cat","dog","catd"}, new String[0]),
                    Arguments.of(new String[]{""}, new String[0])
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findAllConcatenatedWordsInADict(String[] words, String[] result) {
        Arrays.sort(result);
        Object[] res = new Q472().findAllConcatenatedWordsInADict(words).toArray();
        Arrays.sort(res);
        assertArrayEquals(result, res);
    }
}