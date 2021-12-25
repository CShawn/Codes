package com.cshawn.codes.leetcodes.everyday;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/12/25 1:36 下午
 */
class Q1609Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{1,10,4,3,null,7,9,12,8,6,null,null,2}, true),
                    Arguments.of(new Integer[]{5,4,2,3,3,7}, false),
                    Arguments.of(new Integer[]{5,9,1,3,5,7}, false),
                    Arguments.of(new Integer[]{1}, true),
                    Arguments.of(new Integer[]{11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void isEvenOddTree(Integer[] root, boolean result) {
        assertEquals(result, new Q1609().isEvenOddTree(new TreeNode(root)));
    }
}