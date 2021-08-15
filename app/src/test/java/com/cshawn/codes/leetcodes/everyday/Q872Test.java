package com.cshawn.codes.leetcodes.everyday;


import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/5/10 9:23 下午
 */
class Q872Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(
                            new Integer[]{3,5,1,6,2,9,8,null,null,7,4},
                            new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8},
                            true
                    ),
                    Arguments.of(
                            new Integer[]{1},
                            new Integer[]{1},
                            true
                    ),
                    Arguments.of(
                            new Integer[]{1},
                            new Integer[]{2},
                            false
                    ),
                    Arguments.of(
                            new Integer[]{1,2},
                            new Integer[]{2,2},
                            true
                    ),
                    Arguments.of(
                            new Integer[]{1,2,3},
                            new Integer[]{1,3,2},
                            false
                    )
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void leafSimilar(Integer[] root1, Integer[] root2, boolean result) {
        Assertions.assertEquals(result, new Q872().leafSimilar(new TreeNode(root1), new TreeNode(root2)));
    }
}