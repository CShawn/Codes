package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * @author C.Shawn
 * @date 2020/11/22 16:04
 */
public class Sword_12Test {
    public static class ArrayArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new char[][] { 
                        { 'A', 'B', 'C', 'E' }, 
                        { 'S', 'F', 'C', 'S' }, 
                        { 'A', 'D', 'E', 'E' } 
                    }, "ABCCED", true),
                    Arguments.of(new char[][] {
                        { 'A', 'B' }, 
                        { 'C', 'D' } 
                    }, "ABCD", false),
                    Arguments.of(new char[][]{
                        {'a','b','c','e'},
                        {'s','f','c','s'},
                        {'a','d','e','e'}
                    }, "bfce", true),
                    Arguments.of(new char[][]{
                        {'a','b','c','e'},
                        {'s','f','c','s'},
                        {'a','d','e','e'}
                    }, "abfb", false),
                    Arguments.of(new char[][]{
                        {'C','A','A'},
                        {'A','A','A'},
                        {'B','C','D'}
                    }, "AAB", true)
            );
        }
    }

    private Sword_12 test = new Sword_12();

    @ParameterizedTest
    @ArgumentsSource(ArrayArgumentsProvider.class)
    public void exist(char[][] board, String word, boolean exsited) {
        assertEquals(exsited, test.exist(board, word));
    }
}
