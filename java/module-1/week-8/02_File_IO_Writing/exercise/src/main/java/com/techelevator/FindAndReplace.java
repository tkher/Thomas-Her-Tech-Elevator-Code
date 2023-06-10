package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */

        //Initialize variables

        //Ask for search word
        System.out.println("Please enter in a search word: ");
        String searchWordInput = userInput.nextLine();

        //Ask for replacement word
        System.out.println("Please enter in a replacement word: ");
        String replacementWordInput = userInput.nextLine();

        //Ask for the source file - file writing from
        System.out.println("Enter in the source file: ");
        String sourceFileInput = userInput.nextLine();
        //**Create the file object for the source file path
        File sourceFile = new File(sourceFileInput);

        //Ask for destination file - file writing to
        System.out.println("Enter in the destination file: ");
        String destinationFileInput = userInput.nextLine();
        //**Create the file object for the destination file path
        File destinationFile = new File(destinationFileInput);

        //try-catch block
        try (Scanner scanSourceFile = new Scanner(sourceFile);
             PrintWriter writeDestinationFile = new PrintWriter(destinationFile)) {
                while (scanSourceFile.hasNextLine()) {
                    String lineOfText = scanSourceFile.nextLine(); //read every line - proceeds to nextline till false
                    if (lineOfText.contains(searchWordInput)) {
                        lineOfText=lineOfText.replace(searchWordInput,replacementWordInput);
//                        System.out.println(lineOfText);
                    }
                    writeDestinationFile.println(lineOfText);
                }


            writeDestinationFile.close();
        } catch (FileNotFoundException | NullPointerException e) {
            //indicate to user that file is not found and exit
            System.out.println("The file was not found: " + e.getMessage());

        }


    }
}
