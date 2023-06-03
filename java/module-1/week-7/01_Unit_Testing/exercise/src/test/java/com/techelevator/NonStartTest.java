package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    public NonStart nonStart = new NonStart();

    //Happy path Test
    @Test
    public void results_in_concatenation_string_omitting_first_chars () {
        //Arrange

        //Act
        String ellohere = nonStart.getPartialString("Hello","There");
        String removeAs = nonStart.getPartialString("abc","abc");
        String removeOnes= nonStart.getPartialString("123","123");
        //Assert
        Assert.assertEquals(ellohere,"ellohere");
        Assert.assertEquals(removeAs,"bcbc");
        Assert.assertEquals(removeOnes, "2323");
    }

    //Test null and empty string
    @Test
    public void results_in_empty_string_if_null_one_or_zero_char(){
        //Arrange

        //Act
        String resultsNull = nonStart.getPartialString(null,null);
        String resultsEmpty = nonStart.getPartialString("","");
        String resultsNotEnoughChar = nonStart.getPartialString("a", "1");
        //Assert
        Assert.assertEquals(resultsNull,"");
        Assert.assertEquals(resultsEmpty,"");
        Assert.assertEquals(resultsNotEnoughChar,"");


    }

    //Test case sensitivity, Snake case
    @Test
    public void results_in_concatenation_string_regardless_of_case() {
        //Arrange

        //Act
        String resultsAllCaps = nonStart.getPartialString("ALL","CAPS");
        String resultsSnakeCase = nonStart.getPartialString("SnAkE","CaSe");
        //Assert
        Assert.assertEquals(resultsAllCaps,"LLAPS");
        Assert.assertEquals(resultsSnakeCase,"nAkEaSe");
    }

}
