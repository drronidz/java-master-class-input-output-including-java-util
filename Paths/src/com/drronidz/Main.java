package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/24/2021 , 
    CREATED ON : 10:38 PM
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);


        System.out.println("******************************************************");
        Path filePath = FileSystems.getDefault().getPath("Paths","files","SubdirectoryFile.txt");
        printFile(filePath);


    }

    public static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
