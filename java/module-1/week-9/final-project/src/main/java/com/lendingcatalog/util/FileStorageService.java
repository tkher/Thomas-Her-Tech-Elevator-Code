package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename, appendFile))) {
            writer.println(contents);

        } catch (FileNotFoundException e) {
            throw new FileStorageException(filename);

        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List list = new ArrayList();
        File file = new File(filename);
        int lineCounter = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String fileString = scanner.nextLine();
                lineCounter++;
                //retrn list adds to the index of the line (-1 because needs to start at zero), per that index is the line data)
                list.add(lineCounter - 1, fileString);
            }
        } catch (FileNotFoundException e) {
            throw new FileStorageException("Could not read: " + e);
        }
        return list;
    }
}



