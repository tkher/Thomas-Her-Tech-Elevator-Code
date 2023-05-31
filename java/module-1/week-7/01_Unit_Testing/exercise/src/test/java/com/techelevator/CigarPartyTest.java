package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    public CigarParty party = new CigarParty();


    ///Happy path
    @Test
    public void test_haveParty_return_true_when_successful_is_true () {

        // Arrange - Create a shopping cart with items
        int lowRangeCigars = 40;
        int highRangeCigars = 60;
        boolean dayIsWeekend = true;

        // Act - call the method
        boolean truePartyLowRange = party.haveParty(lowRangeCigars, !dayIsWeekend);
        boolean truePartyLowWeekend = party.haveParty(lowRangeCigars, dayIsWeekend);
        boolean truePartyHighRange = party.haveParty(highRangeCigars, !dayIsWeekend);
        boolean truePartyHighRangeWeekend = party.haveParty(highRangeCigars, dayIsWeekend);

        // Assert - Make sure value is correct
        Assert.assertTrue(truePartyLowRange);
        Assert.assertEquals(true, truePartyLowWeekend);


    }

    //Test all the False

    //Test null

    //

}
