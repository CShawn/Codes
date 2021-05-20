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
 * @date 2021/5/20 9:49 下午
 */
class Q692Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2, new String[]{"i", "love"}),
                    Arguments.of(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4, new String[]{"the", "is", "sunny", "day"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void topKFrequent(String[] words, int k, String[] result) {
        Assertions.assertArrayEquals(result, new Q692().topKFrequent(words, k).toArray());
    }
}