package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    public Lucky13 lucky13 = new Lucky13();
    int[] nums = new int[3];

    //Happy Path Test
    @Test
    public void results_return_true_if_no_one_or_three () {
        //Arrange
        nums[0] = 2;
        nums[1] = 4;
        nums[2] = 5;
         //Act
        boolean twoFourFive = lucky13.getLucky(nums);
        //Assert
        Assert.assertTrue(twoFourFive);

    }

    //Returns false if contains 1 or 3
    @Test
    public void results_return_false_if_contains_one_or_three () {
        //Arrange
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 1;
        //Act
        boolean threeTwoOne = lucky13.getLucky(nums);
        //Assert
        Assert.assertFalse(threeTwoOne);
        //Act

        //Assert
    }

    //Zero, neg int returns false
    @Test
    public void results_return_true_or_false_with_neg_int_and_zero () {
        //Arrange
        nums[0] = -1;
        nums[1] = 0;
        nums[2] = 1;

        int[] secondList = new int[] {-1,0,2};
        //Act
        boolean zeroNegFalse = lucky13.getLucky(nums);
        boolean zeroNegTrue = lucky13.getLucky(secondList);
        //Assert
        Assert.assertFalse(zeroNegFalse);
        Assert.assertTrue(zeroNegTrue);

    }
}
