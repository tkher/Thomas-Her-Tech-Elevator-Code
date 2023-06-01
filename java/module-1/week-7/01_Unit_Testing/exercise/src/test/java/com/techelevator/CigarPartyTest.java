package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {

    public CigarParty party = new CigarParty();

//    @Before
//    public setValues() {
        int lowRangeCigars = 40;
        int highRangeCigars = 60;
        boolean dayIsWeekend = true;


    ///Happy path
    @Test
    public void test_haveParty_return_true_when_successful_is_true () {

        // Arrange - Done above


        // Act - call the method
        boolean truePartyLowRange = party.haveParty(lowRangeCigars, !dayIsWeekend);
        boolean truePartyLowRangeWeekend = party.haveParty(lowRangeCigars, dayIsWeekend);
        boolean truePartyHighRange = party.haveParty(highRangeCigars, !dayIsWeekend);
        boolean truePartyHighRangeWeekend = party.haveParty(highRangeCigars, dayIsWeekend);

        // Assert - Make sure value is correct
        Assert.assertTrue(truePartyLowRange);
        Assert.assertTrue(truePartyLowRangeWeekend);
        Assert.assertTrue(truePartyHighRange);
        Assert.assertTrue(truePartyHighRangeWeekend);
        //Could also use: Assert.assertEquals(true, truePartyLowWeekend);
    }

    //Test all the False
    @Test
    public void test_haveParty_return_false_when_successful_is_false() {

        //Arrange - Done above, Test null


        //Act - call the method
        boolean falsePartyLowRange = party.haveParty(lowRangeCigars-1, !dayIsWeekend);
        boolean falsePartyLowRangeWeekend = party.haveParty(lowRangeCigars -1, dayIsWeekend);
        boolean falsePartyHighRange = party.haveParty(highRangeCigars+1, !dayIsWeekend);
        boolean falsePartyHighRangeWeekend = party.haveParty(highRangeCigars+1, dayIsWeekend);

        //Assert - return false
        Assert.assertFalse(falsePartyLowRange);
        Assert.assertFalse(falsePartyLowRangeWeekend);
        Assert.assertFalse(falsePartyHighRange);
      //Assert.assertFalse(falsePartyHighRangeWeekend); High ranges does not need to be tested on weekends

    }

    //Test null
    @Test
    public void test_return_null_when_cigars_is_zero() {

        //Arrange - Test int is null, test boolean is null
        int Result = 0;
        //Act - call the method
        boolean nullTest = party.haveParty(Result, dayIsWeekend);
        //Assert - return null
        Assert.assertFalse(nullTest);
    }
    //

}
