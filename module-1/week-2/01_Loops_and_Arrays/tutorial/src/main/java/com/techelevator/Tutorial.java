package com.techelevator;

public class Tutorial {

    public static void main(String[] args) {
        // write your code here
        int i;
        for (i = 0; i <= 5; i++) {
            System.out.println(i);
        }
        for (i = 10; i >= 0; i--) {
            System.out.println(i);
        }
        int[] forcastTemperature = new int[5];
        forcastTemperature[0] = 72;
        forcastTemperature[1] = 78;
        forcastTemperature[2] = 58;
        forcastTemperature[3] = 79;
        forcastTemperature[4] = 74;
        //add 10 to element 3
        forcastTemperature[2] = forcastTemperature[2] + 10;
        //shorthand version
        //forecastTemperature[2] += 10;

        for (i = 0; i < forcastTemperature.length; i++) {
            System.out.println(forcastTemperature[i]);
        }
        //write loop to find highest temp
        int highestTemperatureValue = forcastTemperature[0];
        int highestTemperatureIndex = 0;
        //assuming the first element is highest temp until you find higher one

        for (int j = 1; j < forcastTemperature.length; j++) {
            if (forcastTemperature[j] > highestTemperatureValue) {
                highestTemperatureValue = forcastTemperature[j];
                highestTemperatureIndex = j;
            }
        }
        System.out.println("The highest temperature is " + highestTemperatureValue);
        System.out.println("The highest temperature is in " + (highestTemperatureIndex + 1) + " days");
    }
    
}


