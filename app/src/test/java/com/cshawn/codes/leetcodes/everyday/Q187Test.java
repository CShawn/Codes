package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author C.Shawn
 * @date 2021/10/8 5:44 下午
 */
class Q187Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", new String[]{"AAAAACCCCC","CCCCCAAAAA"}),
                    Arguments.of("AAAAAAAAAAAAA", new String[]{"AAAAAAAAAA"})
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findRepeatedDnaSequences(String s, String[] result) {
        assertArrayEquals(result, new Q187().findRepeatedDnaSequences1(s).toArray());
        assertArrayEquals(result, new Q187().findRepeatedDnaSequences(s).toArray());
    }
}