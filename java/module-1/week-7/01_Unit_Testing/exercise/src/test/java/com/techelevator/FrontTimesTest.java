package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    private final String abcWord = "abcWord";
    public FrontTimes frontTimes = new FrontTimes();


    //happy path test

    @Test
    public void test_method_returns_first_three_char_per_int_n() {
        //arrange

        //act
        String returnsTwoTimes = frontTimes.generateString(abcWord,2);
        String returnsThreeTimes = frontTimes.generateString(abcWord,3);
        //assert
        Assert.assertEquals("abcabc",returnsTwoTimes);
        Assert.assertEquals("abcabcabc",returnsThreeTimes);
    }


    //Test for case insensitivity and snake case
    @Test
    public void test_snake_case_and_insensitivity () {
        //arrange

        //act
        String returnsTwoTimes = frontTimes.generateString("AbCWord", 2);
        String returnsThreeTime = frontTimes.generateString("ABCWORD", 3);
        //assert
        Assert.assertEquals("AbCAbC", returnsTwoTimes);
        Assert.assertEquals("ABCABCABC", returnsThreeTime);
    }

    //Test String less than three char
    @Test
    public void test_less_than_three_char_string () {
        //Arrange


        //Act
        String twoCharString = frontTimes.generateString("ab",2);
        String emptyOrNullString = frontTimes.generateString(null,2);
        //Assert
        Assert.assertEquals(twoCharString, "abab");
        Assert.assertEquals(emptyOrNullString, "");
    }

    //Test for neg int, test for zero int
    @Test
    public void test_neg_int_and_zero_int() {
        //Arrange


        //Act
        String nIsNegative = frontTimes.generateString(abcWord,-1);
        String nIsZero  =   frontTimes.generateString(abcWord,0);

        //Assert
        Assert.assertEquals(nIsNegative,"");
        Assert.assertEquals(nIsZero,"");
    }
}
