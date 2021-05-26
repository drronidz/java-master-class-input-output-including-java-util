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


        try {
            Path sourceFile = FileSystems.getDefault().getPath("Paths","Examples","file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Paths","Examples","file1copy.txt");
            Files.copy(sourceFile, copyFile);
        } catch (IOException  e) {
            e.printStackTrace();
        }


//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        System.out.println("******************************************************");
//
////        Path filePath = FileSystems.getDefault().getPath("Paths","files","SubdirectoryFile.txt");
//        Path filePath = Paths.get("Paths","files","SubdirectoryFile.txt");
//        System.out.println(filePath);
//        printFile(filePath);
//        System.out.println("******************************************************");
//
//
//        filePath = Paths.get("");
//        System.out.println(filePath.toAbsolutePath());
//
//        System.out.println("******************************************************");
//
//        Path path2 = FileSystems.getDefault().getPath(".","Paths", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//
//        System.out.println("******************************************************");
//
//        Path path3 = FileSystems.getDefault().getPath("this_file_doesnt_exist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("C:\\","addf","whatever");
//        System.out.println(path4.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("Paths","files");
//        System.out.println("Exists = " + Files.exists(filePath));
//        System.out.println("Exists = " + Files.notExists(filePath));
//
//        System.out.println("Exists = " + Files.exists(path4));
//        System.out.println("Exists = " + Files.notExists(path4));
//
//    }
//
//    public static void printFile(Path path) {
//        try (BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while ((line = fileReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
    }
}
