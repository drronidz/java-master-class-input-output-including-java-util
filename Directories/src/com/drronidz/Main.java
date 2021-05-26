package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/26/2021 , 
    CREATED ON : 2:30 PM
*/

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DirectoryStream.Filter<Path> filter =
                entry -> (Files.isRegularFile(entry));

        //Path directory = FileSystems.getDefault().getPath("Directories","FileTree\\DIR2");
        Path directory = FileSystems
                .getDefault()
                .getPath("Directories","FileTree"+ File.separator +"DIR2");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for(Path file: contents) {
              System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp",".txt");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores) {
            System.out.println("Volume name/Drive letter = " + store);
            System.out.println("file store = " + store.name());
        }
        System.out.println("########################################################");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path: rootPaths) {
            System.out.println(path);
        }
    }
}
