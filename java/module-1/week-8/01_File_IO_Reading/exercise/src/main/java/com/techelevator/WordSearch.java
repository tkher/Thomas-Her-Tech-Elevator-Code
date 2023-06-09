package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */

		//Step 1 - Prompt user for file input
		System.out.print("Enter path to the book file: ");
		String filePath = userInput.nextLine();

		//Prompt user for a word to search for
		System.out.print("Enter word you are searching for: ");
		String searchWord = userInput.nextLine();

		//File object - Holds file path
		File bookFile = new File(filePath);

		//Variable that holds the occurences of the word
		String foundLine = ")" + "";


		try (Scanner fileInput = new Scanner(bookFile)) {
			while (fileInput.hasNextLine()) {
				String lineOfText = fileInput.nextLine();
			}
		}
	 catch (FileNotFoundException e) {
		 System.out.println("The file was not found:" + bookFile.getAbsolutePath());
	 }

	}


}
