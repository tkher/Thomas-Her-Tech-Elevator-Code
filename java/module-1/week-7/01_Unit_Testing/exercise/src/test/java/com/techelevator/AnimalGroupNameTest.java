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
            this.animalName = "rhino";
        // Act - call heard method and get herd name
            String herd = animal.getHerd(animalName);

        // Assert - Make sure value is correct
        Assert.assertSame("Crash", herd);
    }
}
