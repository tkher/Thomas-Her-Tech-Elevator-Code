package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the temperature: ");
		String value = input.nextLine();
		int inputTemperature = Integer.parseInt(value);

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String celsiusOrFahrenheit = input.nextLine();

		//for (int c = inputTemperature; c = inputTemperature; c+= 0) {
		if (celsiusOrFahrenheit.equalsIgnoreCase("C") ) {
			double temperatureFarenheit = inputTemperature * 1.8 + 32;
			System.out.print(inputTemperature + "C is " + temperatureFarenheit +"F");
		} else if (celsiusOrFahrenheit.equalsIgnoreCase("F") ) {
			double temperatureCelsius = (inputTemperature - 32) / 1.8;
			System.out.print(inputTemperature + "F is " + temperatureCelsius +"C");
		}
	}

}
