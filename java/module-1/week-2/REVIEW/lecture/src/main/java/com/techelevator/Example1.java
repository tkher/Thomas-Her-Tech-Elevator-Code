package com.techelevator;

public class Example1 {

    /*
     1. Given a starting number and a higher ending number, return the sum of all the numbers from the
     starting number up to the ending number.

     sumAllNumbers(0, 1) → 1
     sumAllNumbers(2, 6) → 20  (2 + 3 + 4 + 5 + 6 = 20)
     sumAllNumbers(100, 104) → 510
    */
    public int sumAllNumbers(int start, int end) {
<<<<<<< HEAD
        return 0;
=======
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        return sum;
>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
    }

    /*
	 2. Given an array of ints, return true if one of the first 4 elements in the array is a 9.
	 The array length may be less than 4.

	 arrayFront9([1, 9, 2]) → true
	 arrayFront9([1, 2, 3, 4, 9]) → false
	 arrayFront9([1, 2, 3, 4, 5]) → false
	 */
    public boolean arrayFront9(int[] nums) {
<<<<<<< HEAD
=======
        int end = nums.length >= 4?4:nums.length;
        for(int i = 0; i < end; i++){
            if(nums[i] == 9){
                return true;
            }
        }
>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
        return false;
    }

    /*
	 3. Given an array of integers, return an array of doubles where each element is half the value of the element at the
	 same index in the integer array.

	 halveAll([2, 4, 6, 8]) → [1.0, 2.0, 3.0, 4.0]
	 halveAll([1, 1, 1]) → [0.5, 0.5, 0.5]
	 halveAll([3, 300]) → [1.5, 150.0]
	 */
    public double[] halveAll(int[] input) {
<<<<<<< HEAD
        return null;
=======
        double[] halfArray = new double[input.length];
        for(int i = 0; i < input.length; i++){
            halfArray[i] = input[i] * 0.5;
        }
        return halfArray;
>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
    }

}
