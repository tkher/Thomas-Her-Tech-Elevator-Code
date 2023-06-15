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
        try (Scanner scanner = new Scanner(filename)) {
            System.out.println(filename); //more than likely will change once in app
//        } catch (FileNotFoundException e) {
//            throw new FileStorageException(filename);
        }
        return list;
    }
}




