package com.cshawn.codes.leetcodes.everyday;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author C.Shawn
 * @date 2021/10/11 9:30 上午
 */
class Q273Test {

    @ParameterizedTest
    @CsvSource({
            "123,One Hundred Twenty Three",
            "12345,Twelve Thousand Three Hundred Forty Five",
            "1234567,One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
            "1234567891,One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
            "1003,One Thousand Three",
            "120000003,One Hundred Twenty Million Three",
            "100000003,One Hundred Million Three",
            "1000000003,One Billion Three",
            "100009000,One Hundred Million Nine Thousand"
    })
    void numberToWords(int num, String result) {
        assertEquals(result, new Q273().numberToWords1(num));
        assertEquals(result, new Q273().numberToWords(num));
    }
}