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
		System.out.println("Enter path to the book file: ");
		String filePath = userInput.nextLine();

		File bookFile = new File(filePath);

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
