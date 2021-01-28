package com.cshawn.leetcodes.sword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/1/28 11:10 上午
 */
class Sword_67Test {

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "123,123",
            "+-2,0",
            "2147483646,2147483646",
            "   ,0",
            "  -  ,0",
            "   +  ,0",
            "  +4wef5 ,4",
            "23-2,23",
            "23+2,23",
            "23637267376376376,2147483647",
            "  -23637267376376376,-2147483648"
    })
    void strToInt(String str, int value) {
        Assertions.assertEquals(value, new Sword_67().strToInt(str));
    }
}