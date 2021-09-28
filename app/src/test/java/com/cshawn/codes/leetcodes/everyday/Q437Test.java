package com.cshawn.codes.leetcodes.everyday;

import com.cshawn.codes.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author C.Shawn
 * @date 2021/9/28 5:26 下午
 */
class Q437Test {
    static class DataArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}, 8, 3),
                    Arguments.of(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}, 22, 3)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DataArgumentsProvider.class)
    void pathSum(Integer[] root, int targetNum, int result) {
        assertEquals(result, new Q437().pathSum1(new TreeNode(root), targetNum));
        assertEquals(result, new Q437().pathSum(new TreeNode(root), targetNum));
    }
}