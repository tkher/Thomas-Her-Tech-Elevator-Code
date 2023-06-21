package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the length: ");
		String userInput = scanner.nextLine();
		int userInputInt = Integer.parseInt(userInput);

		System.out.println("Is the measurement in (m)eter, or (f)eet?: ");
		String measurementInput = scanner.nextLine();

		if(measurementInput.equalsIgnoreCase("M")) {
			double measurementInFeet = userInputInt * 3.2808399;
			System.out.println(userInput + "M is " + measurementInFeet +"F." );
		} else if (measurementInput.equalsIgnoreCase("F")) {
			double measurementInMeter = userInputInt * 0.3048;
			System.out.println(userInput + "F is " + measurementInMeter +"M." );

			}
		}


	}


