package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    public StringBits stringBits = new StringBits();

    //Happy Path Test
    @Test
    public void results_return_every_other_char_string () {
        //Arrange

        //Act
        String hello = stringBits.getBits("Heeololeo");
        //Assert
        Assert.assertEquals(hello,"Hello");

    }

    //String is null
    @Test
    public void results_return_empty_if_null_or_empty_string () {
        //Arrange

        //Act
        String empty = stringBits.getBits("");
        String stringIsNull = stringBits.getBits(null);
        //Assert
        Assert.assertEquals(empty,"");
        Assert.assertEquals(stringIsNull,"");
    }


}
