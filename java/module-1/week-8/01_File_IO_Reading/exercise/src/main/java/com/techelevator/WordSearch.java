package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Locale;
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

		//Initialize variables
		//Step 1 - Prompt user for file input
		System.out.print("Enter path to the book file: ");
		String filePathForBook = userInput.nextLine();

		//Prompt user for a word to search for
		System.out.print("Enter word you are searching for: ");
		String searchWord = userInput.nextLine();

		//Prompt User if should be case sensitive
		System.out.print("Should the search be case sensitive? " +'('+"Y" +"\\" + "N" + ')');
		String yesOrNo = userInput.nextLine();

		//File object - stores file path
		File bookFile = new File(filePathForBook);

		//Store line count for every line of text
		int lineCounter = 0;

		//Scanner fileInput

		try (Scanner inputOfBookFile = new Scanner(bookFile)) {
			while (inputOfBookFile.hasNextLine()) {
				String lineOfText = inputOfBookFile.nextLine(); //Reads line of book, then proceeds to next line until .nextLine returns false -end of book.
				lineCounter ++;
				if (yesOrNo.equalsIgnoreCase("n")) {
					String upperCaseLineOfText = lineOfText.toUpperCase();
					String upperCaseSearchWord = searchWord.toUpperCase();
					if (upperCaseLineOfText.contains(upperCaseSearchWord)) {
						System.out.println(lineCounter + ") " + lineOfText);
					}
				} else if (lineOfText.contains(searchWord)) {
						System.out.println(lineCounter + ") " + lineOfText);
					}
			}
		}
	 catch (FileNotFoundException e) {
		 System.out.println("The file was not found:" + bookFile.getAbsolutePath());
	 }

	}


}
