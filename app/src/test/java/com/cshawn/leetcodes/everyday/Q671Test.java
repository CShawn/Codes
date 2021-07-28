package com.cshawn.leetcodes.everyday;

import com.cshawn.leetcodes.sword.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

/**
 * @author C.Shawn
 * @date 2021/7/27 5:53 下午
 */
class Q671Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{2,2,5,null,null,5,7}, 5),
                    Arguments.of(new Integer[]{2,2,2,null,null,2,7,6,2}, 6),
                    Arguments.of(new Integer[]{2,2,2}, -1),
                    Arguments.of(new Integer[]{2}, -1)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void findSecondMinimumValue(Integer[] tree, int result) {
        Assertions.assertEquals(result, new Q671().findSecondMinimumValue(new TreeNode(tree)));
    }
}