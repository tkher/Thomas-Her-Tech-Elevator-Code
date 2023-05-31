package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
    private String animalName;

    public AnimalGroupName animal = new AnimalGroupName();


    //Happy path test
    @Test
    public void test_getHerd_return_herd_string_matching_animal_string() {

        // Arrange - get animal string
        animalName = "rhino";
        // Act - call heard method and get herd name
        String herd = animal.getHerd(animalName);

        // Assert - Make sure value is correct
        Assert.assertSame("Crash", herd);

    }
    //Test Unknown animal name
    @Test
    public void test_unknown_animal_returns_string_unknown() {
        //Arrange
        animalName = "Alien";
        //Act
        String unknown = animal.getHerd(animalName);
        //Assert
        Assert.assertEquals(unknown,"unknown");
    }

    //Test Lower/Upper Case insensitive - Snake case
    @Test
    public void test_snake_case_and_case_insensitive () {
        //Arrange
        animalName = "DeEr";

        //Act
        String snakeCase = animal.getHerd(animalName);
        String lowerCase = animal.getHerd("deer");
        String upperCase = animal.getHerd("DEER");

        //Assert
        Assert.assertEquals(snakeCase,"Herd");
        Assert.assertEquals(lowerCase,"Herd");
        Assert.assertEquals(upperCase, "Herd");
    }

    //Test for null, empty
    @Test
    public void test_for_null_and_empty_string() {
        //Arrange
        animalName = null;

        //Act
        String isNull = animal.getHerd(animalName);
        String isEmpty = animal.getHerd("");
        //String isInt = animal.getHerd(123); ***How do I test for wrong data type input???***

        //Assert
        Assert.assertEquals( "unknown", isNull );
        Assert.assertEquals("unknown", isEmpty);
    }

}
