package com.techelevator;

<<<<<<< HEAD
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
			if (celsiusOrFahrenheit == "C") {
				double temperatureFarenheit = inputTemperature * 1.8 + 32;
				System.out.print(inputTemperature + "C is " + temperatureFarenheit +"F");
			} else if (celsiusOrFahrenheit == "F") {
				double temperatureCelsius = (inputTemperature - 32) / 1.8;
				System.out.print(inputTemperature + "F is " + temperatureCelsius +"C");
			}
		//}
=======
public class TempConvert {

	public static void main(String[] args) {
>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc

	}

}
