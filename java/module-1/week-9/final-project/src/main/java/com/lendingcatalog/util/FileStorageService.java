package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename,appendFile))) {
            writer.println(contents);

        } catch (FileStorageException e) {
//            throw new FileStorageException(filename);
            e.printStackTrace();
            System.out.println("Unable to create log: " + e);
        }catch (FileNotFoundException e) {

        }
    }


    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        return null;
    }

}
