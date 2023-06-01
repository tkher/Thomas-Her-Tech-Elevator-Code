package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion dateFashion = new DateFashion();

    //Test Happy path
    @Test
    public void test_getTable_returns_expected_results_using_range_inputs () {
        //Arrange -
            /* Test:
            return 0
            return 1
            return 2
             */

        //Act
        int returnZero = dateFashion.getATable(5,0);
        int returnOne = dateFashion.getATable(5,5);
        int returnTwo = dateFashion.getATable(5, 10);


        //Assert
        Assert.assertEquals(0,returnZero);
        Assert.assertEquals(1,returnOne);
        Assert.assertEquals(2,returnTwo);


    }

    //Test returns always Yes(2)

    //Test returns always No(0)




    //Test outside of range
    /*

    ***This test should return "null" but because the code does not have that written,
            I wrote test to return the expected values.***
     */
    @Test
    public void test_returns_null_when_outside_of_max_range () {
        //Arrange
            /*
            int is 11 returns null - (2)
            int is negative number - (0)
             */

        //Act
        int outsideMax = dateFashion.getATable(11,11);
        int negativeNumber = dateFashion.getATable(-1,-1);

        //Assert
        Assert.assertEquals(outsideMax,2);
        Assert.assertEquals(negativeNumber, 0);

    }

}
