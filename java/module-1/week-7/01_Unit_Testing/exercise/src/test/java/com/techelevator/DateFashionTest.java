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
    @Test
    public void always_returns_two_when_either_score_is_higher_than_eight() {
        //arrange


        //Act
        int fashionScore8And3Return2 = dateFashion.getATable(8,3);
        int fashionScore3and10Return2 = dateFashion.getATable(3,10);

        //Assert
        Assert.assertEquals(fashionScore8And3Return2, 2);
        Assert.assertEquals(fashionScore3and10Return2, 2);
    }

    //Test returns always No(0)
    @Test
    public void always_returns_zero_when_either_score_is_two_or_less() {
        //arrange


        //Act
        int fashionScore2And10Return0 = dateFashion.getATable(2, 10);
        int fashionScore8and0Return0 = dateFashion.getATable(8, 0);

        //Assert
        Assert.assertEquals(fashionScore2And10Return0, 0);
        Assert.assertEquals(fashionScore8and0Return0, 0);

    }

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
