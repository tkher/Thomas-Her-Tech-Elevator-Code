package com.techelevator;

public class Example2 {

    /*
	 1. Given a string, return true if the first and last characters of the string are the letter o (upper or
	 lower case). Ignore any leading or trailing spaces.

	 roundOnBothEnds("Ohio") → true
	 roundOnBothEnds("    OREO ") → true
	 roundOnBothEnds("ooooo!") → false
	*/
    public boolean roundOnBothEnds(String input) {
        input = input.trim();
        String firstCharacter = input.substring(0,1);
        String endCharacter = input.substring(input.length() -1);
        if(firstCharacter.equalsIgnoreCase(endCharacter) && firstCharacter.equalsIgnoreCase("o")){
            return true;
        }
        return false;
    }

    /*
	 2. Given two strings, append them together (known as "concatenation") and return the result.
	 However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and
	 "cat" yields "abcat".

	 conCat("abc", "cat") → "abcat"
	 conCat("dog", "cat") → "dogcat"
	 conCat("abc", "") → "abc"
	*/
    public String conCat(String a, String b) {
        String combined = a + b;
        if(a.length() > 0 && b.length() > 0){
            if(a.endsWith(b.substring(0,1))){
                combined = a + b.substring(1);
            }
        }

        return combined;
    }

    /*
     3. Given a string, return true if the number of appearances of "is" anywhere in the string is equal to
     the number of appearances of "not" anywhere in the string (case sensitive).

     equalIsNot("This is not") → false
     equalIsNot("This is notnot") → true
     equalIsNot("noisxxnotyynotxisi") → true
    */
    public boolean equalIsNot(String str) {
        //counter for "is"
        int isCount = 0;
        //counter for "not"
        int notCount = 0;

        //declare a new variable "i" and set it equal to the index where "is" is located in our string
        //in the first two examples, it would be 5
        int i = str.indexOf("is");
        //while i is within the bounds of our string
        while (i > -1) {
            //if "is" is found, increment our isCount variable by 1
            isCount++;
            //we've already checked the previous index, so keep going
            i = str.indexOf("is", i + 2);
        }
        //now that we're done checking for "is" start we can now set "i" equal to the index of the first occurence of "not"
        i = str.indexOf("not");
        while (i > -1) {
            //if "not" is found, increment our isNot variable by 1
            notCount++;
            //we've already checked the previous index, so keep going
            i = str.indexOf("not", i + 3);
        }
        //if isCount and notCount are equal integers return true, otherwise return false
        return isCount == notCount;
    }

}
