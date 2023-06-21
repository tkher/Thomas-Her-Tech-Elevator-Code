package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		String userInput = scanner.nextLine();
		int userNumber = Integer.parseInt(userInput);

		int firstNumber = 0;
		int secondNumber = 1;
		int newNumber = firstNumber + secondNumber;

		if (userNumber <= 0) {
			System.out.print("0, 1");
		} else {
			System.out.print("0, 1");
			for (int i = 2; i <= userNumber; i += newNumber) {
				newNumber = firstNumber + secondNumber;
				firstNumber = secondNumber;
				secondNumber = newNumber;
				System.out.print(", " + newNumber);
			}
			if (firstNumber + secondNumber == userNumber) {
				System.out.print(", " + userNumber);
			} else {
				System.out.println(", " + (firstNumber + secondNumber));
			}

		}
	}
}

