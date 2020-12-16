package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2020/12/16 4:50 下午
 */
class Sword_33Test {
    private final Sword_33 test = new Sword_33();

    static class PostorderArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[0], true),
                    Arguments.of(new int[]{1}, true),
                    Arguments.of(new int[]{1, 2, 3}, true),
                    Arguments.of(new int[]{1, 2}, true),
                    Arguments.of(new int[]{2, 3}, true),
                    Arguments.of(new int[]{3, 1, 2}, false),
                    Arguments.of(new int[]{1,2,5,10,6,9,4,3}, false),
                    Arguments.of(new int[]{5,4,3,2,1}, true),
                    Arguments.of(new int[]{179, 437, 1405, 5227, 8060, 8764, 8248, 4687, 3297, 13038, 12691, 15744, 16195,
                            15642, 19813, 17128, 21051, 20707, 22177, 21944, 23644, 23281, 19970, 23652, 26471,
                            31467, 33810, 32300, 33880, 27334, 25987, 35643, 35103, 36489, 42534, 42990, 42942,
                            37090, 36075, 34516, 16624, 11335, 10737, 44641, 45754, 47096, 46021, 49150, 48013,
                            49814, 51545, 52555, 50701, 47875, 56783, 57558, 53812, 62008, 61737, 63052, 63478,
                            62799, 59246, 64765, 64066, 63862, 65384, 67449, 66552, 57741, 45618, 44412, 667,
                            69718, 75519, 76819, 72971, 79319, 78145, 80615, 84280, 80984, 86598, 85903, 84334,
                            80867, 87993, 92361, 88465, 87738, 80364, 94380, 94446, 96785, 93694, 76847, 99655,
                            98675, 97001, 72112}, true)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(PostorderArgumentsProvider.class)
    void verifyPostorder(int[] postorder, boolean expected) {
        assertEquals(expected, test.verifyPostorder(postorder));
    }
}