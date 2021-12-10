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
 * @date 2021/12/10 11:27 上午
 */
class Q748Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}, "steps"),
                    Arguments.of("1s3 456", new String[]{"looks", "pest", "stew", "show"}, "pest"),
                    Arguments.of("Ah71752", new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"}, "husband"),
                    Arguments.of("OgEu755", new String[]{"enough","these","play","wide","wonder","box","arrive","money","tax","thus"}, "enough"),
                    Arguments.of("iMSlpe4", new String[]{"claim","consumer","student","camera","public","never","wonder","simple","thought","use"}, "simple")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void shortestCompletingWord(String licensePlate, String[] words, String result) {
        assertEquals(result, new Q748().shortestCompletingWord(licensePlate, words));
    }
}