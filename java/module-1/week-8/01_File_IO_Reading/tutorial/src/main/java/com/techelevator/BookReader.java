package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class BookReader {
    static private final String BEGIN_MARKER = "*** START OF";
    static private final String END_MARKER = "*** END OF";
    public static void main(String[] args) {
        /*
         * This book-reader program opens a file that was downloaded from https://www.gutenberg.org/, reads
         * through the copyright information at the top until it finds the start of the book content, and
         * then displays the content to the user. It also counts the total lines of book content between the
         * start and the end markers.
         */

        /*
        Step 1: Prompt the user for a filename
         */
        // Create a scanner for user input
        Scanner userInput = new Scanner(System.in);
        // Prompt the user for a file path - path should look like "data/jekyll-and-hyde.txt"
        System.out.print("Enter path to the book file: ");
        String filePath = userInput.nextLine();

        /*
        Step 2: Step Two: Open the book file and handle errors
         */
        //Create a file object using the path
        File bookFile = new File(filePath);

        //initialize a variable to hold the count of lines
        int lineCount = 0; //count of lines between the start and end markers

        //initialize variable to remove header
        boolean inBookText = false;

        //open the file
        try (Scanner fileInput = new Scanner(bookFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                //Skip the header information before book content - turns true after BEGIN_MARKER
                if (lineOfText.startsWith(BEGIN_MARKER)) {
                    inBookText = true;
                }
                if (lineOfText.startsWith(END_MARKER)) {
                    break;
                }
                if (inBookText) {
                    lineCount++;
                    System.out.println(lineCount + ": " + lineOfText);
                }
            }

        } catch (FileNotFoundException e) {
            //Could not find the file at the specified path
            System.out.println("The file was not found: " + bookFile.getAbsolutePath());
        }
        System.out.println("Found " + lineCount + " lines of text in " + filePath);
    }
}
