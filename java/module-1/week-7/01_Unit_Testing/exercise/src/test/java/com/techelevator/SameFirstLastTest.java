package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    public SameFirstLast sameFirstLast = new SameFirstLast();

    //Happy path test
    @Test
    public void results_return_true_if_first_and_last_int_are_equal() {
        //Arrange
        int[] listOne = new int [] {1,2,1,};
        int[] listTwo = new int [] {1,2,3,1};
        int[] listThree = new int [] {0,2,0};
        //Act
        boolean testListOne = sameFirstLast.isItTheSame(listOne);
        boolean testListTwo = sameFirstLast.isItTheSame(listTwo);
        boolean testListThree = sameFirstLast.isItTheSame(listThree);
        //Assert
        Assert.assertTrue(testListOne);
        Assert.assertTrue(testListTwo);
        Assert.assertTrue(testListThree);

    }



    //Test false if first and last not equal
    @Test
    public void results_return_false_if_first_and_last_int_are_not_equal() {
        //Arrange
        int[] listOne = new int [] {1,2,3,};
        int[] listTwo = new int [] {1,2,3,4};
        int[] listThree = new int [] {-1,1,0};
        //Act
        boolean equalIndexOneAndThree = sameFirstLast.isItTheSame(listOne);
        boolean equalIndexOneAndfour = sameFirstLast.isItTheSame(listTwo);
        boolean equalZeroValue = sameFirstLast.isItTheSame(listThree);
        //Assert
        Assert.assertFalse(equalIndexOneAndThree);
        Assert.assertTrue(equalIndexOneAndfour);
        Assert.assertTrue(equalZeroValue);

    }


    //Test if empty array, array of strings, null
    @Test
    public void results_return_false_if_first_and_last_elements_are_string_empty_null() {
        //Arrange

        //Act

        //Assert
    }

    //
}
