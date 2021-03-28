package com.cshawn.leetcodes.everyday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/3/28 10:48 上午
 */
class Q5714Test {
    public static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(
                            "(name)is(age)yearsold",
                            new ArrayList<List<String>>(){{
                                add(new ArrayList<String>(){{add("name");add("bob");}});
                                add(new ArrayList<String>(){{add("age");add("two");}});
                            }},
                            "bobistwoyearsold"
                    ),
                    Arguments.of("hi(name)", new ArrayList<List<String>>(){{
                        add(new ArrayList<String>(){{add("ab");add("b");}});}},
                            "hi?"
                    ),
                    Arguments.of("(a)(a)(a)aaa", new ArrayList<List<String>>(){{
                        add(new ArrayList<String>(){{add("a");add("yes");}});}},
                            "yesyesyesaaa"
                    ),
                    Arguments.of("(a)(b)", new ArrayList<List<String>>(){{
                        add(new ArrayList<String>(){{add("a");add("b");}});
                        add(new ArrayList<String>(){{add("b");add("a");}});}},
                            "ba"
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void evaluate(String s, List<List<String>> knowledge, String result) {
        Assertions.assertEquals(result, new Q5714().evaluate(s, knowledge));
    }
}