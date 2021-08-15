package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/5/14 9:11 下午
 */
class Q12Test {

    @ParameterizedTest
    @CsvSource({
            "1,I", "2,II", "3,III", "4,IV", "5,V",
            "6,VI", "8,VIII", "9,IX", "11,XI", "34,XXXIV", "49,XLIX",
            "58,LVIII", "64,LXIV", "1994,MCMXCIV", "2021,MMXXI", "3900,MMMCM",
            "3001,MMMI", "409,CDIX", "794,DCCXCIV"
    })
    void intToRoman(int num, String result) {
        Assertions.assertEquals(result, new Q12().intToRoman1(num));
        Assertions.assertEquals(result, new Q12().intToRoman(num));
    }
}