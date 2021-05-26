package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/26/2021 , 
    CREATED ON : 2:30 PM
*/

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DirectoryStream.Filter<Path> filter =
                entry -> (Files.isRegularFile(entry));

        Path directory = FileSystems.getDefault().getPath("Directories","FileTree\\DIR2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for(Path file: contents) {
              System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
