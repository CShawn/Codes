package com.cshawn.codes.leetcodes.everyday;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author C.Shawn
 * @date 2021/2/10 10:07 上午
 */
class Q567Test {

    @ParameterizedTest
    @CsvSource(value = {
            // ",,true",
            // ",'',true",
            // ",'',true",
            // "'',,false",
            // ",a,true",
            // "'',a,true",
            // "a,,false",
            // "a,'',false",

            "a,a,true",
            "a,ba,true",
            "c,ba,false",
            "aa,ba,false",
            "ab,ba,true",
            "ab,aba,true",
            "ab,cba,true",
            "ab,bca,false",
            "ab,bcba,true",
            "ab,acbcacbcabc,true",
            "aab,acacacbacaacabac,true",
            "aab,acacacbacaacabc,false",
            "abc,cacb,true",
            "adc,dcda,true",
            "abbc,acbcbaabbdcbabcba,true",
            "vuocwszndxhpilvfujnmakne,vxivzcmyxxvvlchcnbirwatjuloyulmrwfiknxqhkclnubtxbxmkngxtauarrbaxnbpobwvsvzvitycqfrpulnmivncjuxxhntxpmiuojvbfsfdwjbqdiymwbvxlrrxedtdhnyrxyijtlzwirpnfqsooedatollvosgutcxidziubcgrwxskketqaxqslfrhybltsmjyshjopblwszlcibvgvwkabrwqhjunjbjqgguxjupxphldyrzmjazqpdsxmljdxfzutgbxddrpkzkcaosuyouszqdvlrjpzywrompedzyxvvvwglftjvaxrjgfztaqxqfxgjtvmsplsvjzyizywglfcsknmpvaagetggcjzpjoklpmzvfqxlryziuggyrdcrbcgepvnwovfgtiqxgjqkvlukzcmminsghqqkzydfabvpkuegaoprkufbuoqvectqpvtunjxtdjhteoakweecnaocvsllbwrotxcigtwoehqpvalqwuhmsbdngocfnewhyypfmhfllpvcjllaqefpcyypsuevxokcujejhydbfgyinjlwhiuecpzvjmttlvxasgfpetprrbiumeroptqhfsbqrxfhvkbsecuimklqjmbvicelsxglbdctbbsxhmklwcmntodsoutdtesawojotnqfjnwbvhbbescbllmjwevqxandaxpiqscqhwcyulrxukjbdismrhhyvuwzphuvcderanzzkfqoxjcclornlkmatzpapttbkjnsjpmqyaoznrudwtqfjsnnyhhclcentngrjhaxyocmkdeobotrcjlofqdchcarwtjvwhjwnpkvvidmnfzluuxseacnomprtwpwrpkjknlagdcjhglenkmuunalbmgvjaijnasegddfsydyamgjgaujqwehbhxniwhgljshdcmhgqrjyoyltajgdxerxoqdbgrpxgriquhkextrlfhrmpkqkcwoyfwcszztdicqruwilxzqdmiggfagkacbpglqwijgohwxggfjfkmvozkzihitcniooezootwebkntcpgvhikdapbyxwfgjvhsboxodnedpcoiqndeasbyryoxetfygqqnfwikejcrgrqmeffxgcskzeyhpedjsxxxfvqjrklsdczmdhrnfnyjrukzxgqpgtxeswxqlczcfhvypkvosdutpidivzixunwynhwaizruqnnozghmwinjazrkmghdmrwmgvcaerbfwphsmiyjutsjnlgcmdsutwffxojyszaxgawjyypboztzqpjijcsqgtaavsduwjqexwhxkazaejgkchxentxjwpnjfauddhafdbqznbcfzquohewtfzdmwpcdhjxrtcduxmuuracdwkrqkbreiuoubqirjgoxkrejvoyrzmvoxpxsagkyggqesprqrtvbnptoqpmfgitkpzfchqlotdccryzwbnmyieufdhshlaycrfszvipkdlwsfntnqszftlbcoxusavav,true",
            "vuocwszndxhpilvfujnmakne,jvwhjwnpkvvidmnfzluuxseacnomprtwpwrpkjknlagdcjhglenkmuunal,true"
    })
    void checkInclusion(String s1, String s2, boolean result) {
        Assertions.assertEquals(result, new Q567().checkInclusion(s1, s2));
    }
}