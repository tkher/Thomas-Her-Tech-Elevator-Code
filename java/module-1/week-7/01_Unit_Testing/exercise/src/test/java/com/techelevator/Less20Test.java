package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    public Less20 less20 = new Less20();


    //Happy path test
    @Test
    public void returns_true_with_multiples_of_20() {
        //Arrange

        //Act
        boolean eighteen = less20.isLessThanMultipleOf20(18);
        boolean ninetyNine = less20.isLessThanMultipleOf20(99);
        boolean highNumber = less20.isLessThanMultipleOf20(9999);
        //Assert
        Assert.assertEquals(eighteen, true);
        Assert.assertEquals(ninetyNine,true);
        Assert.assertEquals(highNumber,true);
    }

    //returns false
    @Test
    public void returns_false_with_non_multiples_of_20 () {
        //Arrange

        //Act
        boolean seventeen = less20.isLessThanMultipleOf20(17);
        boolean highNumber = less20.isLessThanMultipleOf20(9997);
        boolean numberOne  = less20.isLessThanMultipleOf20(1);
        //Assert
        Assert.assertEquals(seventeen,false);
        Assert.assertEquals(highNumber,false);
        Assert.assertEquals(numberOne,false);
    }


    //negative number returns false
    @Test
    public void negative_int_return_false () {
        //Arrange

        //Act
        boolean numberIsNeg = less20.isLessThanMultipleOf20(-1);
        boolean numberIsZero = less20.isLessThanMultipleOf20(0);
        //Assert
        Assert.assertEquals(numberIsNeg,false);
        Assert.assertEquals(numberIsZero,false);
    }
}
