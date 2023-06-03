package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class MaxEnd3Test {

    public MaxEnd3 maxEnd3 = new MaxEnd3();


    //Happy Path Test
    @Test
    public void results_return_highest_of_first_and_last () {
        //Arrange
        int[] numsOne = new int[] {1,2,3};
        int[] numsTwo = new int[] {11,5,9};
        int[] numsThree = new int[] {1,1,1};
        //Act
        int[] returnsThreesBack = maxEnd3.makeArray(numsOne);
        int[] returnsElevensFront = maxEnd3.makeArray(numsTwo);
        int [] returnsOnesAll = maxEnd3.makeArray(numsThree);
        //Assert
        Assert.assertArrayEquals(returnsThreesBack,(new int[] {3,3,3}));
        Assert.assertArrayEquals(returnsElevensFront, (new int[] {11,11,11}));
        Assert.assertArrayEquals(returnsOnesAll, (new int[] {1,1,1}));
    }

    //Test Zero and Neg
    @Test
    public void results_return_highest_of_neg_and_zero () {
        //Arrange
        int[] numsOne = new int[] {-1,2,3};
        int[] numsTwo = new int[] {11,5,0};
        int[] numsThree = new int[] {0,0,0};

        //Act
        int[] returnsThreesBack = maxEnd3.makeArray(numsOne);
        int[] returnsElevensFront = maxEnd3.makeArray(numsTwo);
        int [] returnsZeroAll = maxEnd3.makeArray(numsThree);

        //Assert
        Assert.assertArrayEquals(returnsThreesBack,(new int[] {3,3,3}));
        Assert.assertArrayEquals(returnsElevensFront, (new int[] {11,11,11}));
        Assert.assertArrayEquals(returnsZeroAll, (new int[] {0,0,0}));
    }
}
