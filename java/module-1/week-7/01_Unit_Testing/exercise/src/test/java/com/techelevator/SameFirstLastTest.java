package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    private int[] listOne = new int[3];
    private int[] listTwo = new int[4];
    private int[] listThree = new int[5];

    public SameFirstLast sameFirstLast = new SameFirstLast();

    private boolean actTestOne() {
        return sameFirstLast.isItTheSame(listOne);
    }

    private boolean actTestTwo() {
        return sameFirstLast.isItTheSame(listOne);
    }

    private boolean actTestThree() {
        return sameFirstLast.isItTheSame(listOne);
    }

    //Happy path test
    @Test
    public void results_return_true_if_first_and_last_int_are_equal() {
        //Arrange
        listOne[0] = 1;
        listOne[1] = 2;
        listOne[2] = 1;

        listTwo[0] = 1;
        listTwo[1] = 2;
        listTwo[2] = 3;
        listTwo[3] = 1;

        listThree[0] = 1;
        listThree[1] = 2;
        listThree[2] = 3;
        listThree[3] = 4;
        listThree[4] = 5;


        //Act
        actTestOne();
        actTestTwo();
        actTestThree();
        //Assert
        Assert.assertTrue(actTestOne());
        Assert.assertTrue(actTestTwo());
        Assert.assertTrue(actTestThree());

    }



    //Test false if first and last not equal
    @Test
    public void results_return_false_if_first_and_last_int_are_not_equal() {
        //Arrange
        listOne[0] = 1;
        listOne[1] = 2;
        listOne[2] = 3;

        listTwo[0] = 1;
        listTwo[1] = 2;
        listTwo[2] = 3;
        listTwo[3] = 4;

        listThree[0] = 0;
        listThree[1] = 1;
        listThree[2] = 2;
        listThree[3] = 3;
        listThree[4] = 4;
        //Act
        actTestOne();
        actTestTwo();
        actTestThree();
        //Assert
        Assert.assertFalse(actTestOne());
        Assert.assertFalse(actTestTwo());
        Assert.assertFalse(actTestThree());


    }


    //Test if empty array, array of strings, null
    @Test
    public void results_return_false_if_array_is_null() {
        //Arrange
        int[]nums = null;

        //Act
        boolean testNums = sameFirstLast.isItTheSame(nums);

        //Assert
        Assert.assertFalse(testNums);

    }

}
