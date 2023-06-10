package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */
		int FizzBuzz = 300;
		int[] listOfNumbers = new int[300];
		for(int i =0; i < listOfNumbers.length; i ++) {
			if ((i % 3 ==0) && (i % 5 == 0)) {
//				listOfNumbers[i]
			} else if (i % 3 ==0) {

			}
			listOfNumbers[i] = i;
		}


		String stringOfNumbers = "";
		for(int i=1; i < listOfNumbers.length; i++) {
			stringOfNumbers += " " + listOfNumbers[i];
		}

//		System.out.println(stringOfNumbers);


		//prompt user for destination file
		System.out.println("Please enter destination file: ");
		String destinationFileInput = userInput.nextLine();
		File destinationFile = new File(destinationFileInput);

		try(PrintWriter write = new PrintWriter(destinationFile)) {
			int lineOfnumbers = 300;
			for (int i = 1; i <= lineOfnumbers; i++) {
				if (((i % 5) == 3) && ((i % 5) == 0)) {
					write.println("fizzbuzz");
				} else if ((i % 3) == 0) {
					write.println("fizz");
				} else if ((i % 5) == 0) {
					write.println("buzz");
				} else {
					write.println(lineOfnumbers);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File path is not found: " + e);
		}

	}

}
