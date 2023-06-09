package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		/* Your code goes here */
		//Initialize variables

		//Ask user to input quiz file
		System.out.println("Enter the fully qualified name of the file to read in for quiz questions");
		String quizFileLocation = userInput.nextLine();

		//File object to store file
		File quizFile = new File(quizFileLocation);


		//Display the first question
		try (Scanner inputOfQuizFile = new Scanner(quizFile)) {
			while (inputOfQuizFile.hasNextLine()) {
				String lineOfText = inputOfQuizFile.nextLine();
				String[] splitUpQuestion = lineOfText.split("\\|");
//				int delimiter = lineOfText.lastIndexOf('?');
//				System.out.println(lineOfText.substring(0,delimiter + 1));
				System.out.println(splitUpQuestion[0]);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + quizFileLocation);
		}
	}

}
