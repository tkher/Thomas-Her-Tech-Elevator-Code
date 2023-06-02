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
        Assert.assertTrue(eighteen);
        Assert.assertTrue(ninetyNine);
        Assert.assertTrue(highNumber);
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
        Assert.assertFalse(seventeen);
        Assert.assertFalse(highNumber);
        Assert.assertFalse(numberOne);
    }


    //negative number returns false
    @Test
    public void negative_int_return_false () {
        //Arrange

        //Act
        boolean numberIsNeg = less20.isLessThanMultipleOf20(-1);
        boolean numberIsZero = less20.isLessThanMultipleOf20(0);
        //Assert
        Assert.assertFalse(numberIsNeg);
        Assert.assertFalse(numberIsZero);
    }
}
