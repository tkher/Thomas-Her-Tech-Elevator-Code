package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    WordCount wordCount = new WordCount();

    //Happy path test
    @Test
    public void returns_maps_with_string_key_and_int_occurrences () {
        //Arrange
        String[] wordList1 = new String[] {"ba", "ba", "black", "sheep"};
        String[] wordList2 = new String[] {"a", "b", "a", "c", "b" };
        String[] wordListEmpty = new String[] { };
        //Act
        Map<String, Integer> blackSheep = wordCount.getCount(wordList1);
        Map<String, Integer> abc = wordCount.getCount(wordList2);
        Map<String, Integer> isEmpty = wordCount.getCount(wordListEmpty);
        //Assert
        Assert.assertEquals(blackSheep, Map.of("ba",2, "black", 1, "sheep", 1));
        Assert.assertEquals(abc, Map.of("a" ,2, "b" ,2, "c", 1));
        Assert.assertEquals(isEmpty, Map.of());

    }
    //Words array = null returns empty
    @Test
    public void returns_empty_when_array_is_null () {
        //Arrange
        String [] words = null;
        //Act
        Map<String, Integer> isNull = wordCount.getCount(words);
        //Assert
        Assert.assertEquals(isNull, Map.of());
    }

}
