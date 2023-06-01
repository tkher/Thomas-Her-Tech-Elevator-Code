package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion dateFashion = new DateFashion();


    @Test
    public void test_getTable_works () {
        //Arr


        //Act
        int answer = dateFashion.getATable(5, 10);


        //Assest
        Assert.assertEquals(2,answer);


    }

    //test for all outcomes

    //


}
