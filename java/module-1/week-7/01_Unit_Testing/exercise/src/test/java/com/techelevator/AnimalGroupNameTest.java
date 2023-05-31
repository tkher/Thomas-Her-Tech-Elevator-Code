package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
    private String animalName;

    public AnimalGroupName animal = new AnimalGroupName();


    //happy path test
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

    @Test
    //Test Lower/Upper Case insensitive - Snake case
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

    //test for null, empty

}
