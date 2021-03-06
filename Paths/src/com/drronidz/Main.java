package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/24/2021 , 
    CREATED ON : 10:38 PM
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {

//            Path fileToCreate = FileSystems.getDefault().getPath("Paths","Examples","file2.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Paths","Examples","DIR4");
//            Files.createDirectory(dirToCreate);


//            String directoryToCreate = "DIR2"
//                    + File.separator +"DIR3"
//                    + File.separator +"DIR4"
//                    + File.separator +"DIR5"
//                    + File.separator +"DIR6";
//            Path dirToCreate = FileSystems.getDefault().getPath("Paths","Examples",directoryToCreate);
//            Files.createDirectories(dirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Paths","Examples","DIR1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + fileAttributes.size());
            System.out.println("Last modified = " + fileAttributes.lastModifiedTime());
            System.out.println("Created = " + fileAttributes.creationTime());
            System.out.println("Is directory = " + fileAttributes.isDirectory());
            System.out.println("Is regular file = " + fileAttributes.isRegularFile());

//            Path fileToDelete = FileSystems.getDefault().getPath("Paths","Examples","DIR1","file1copy.txt");
//            Files.delete(fileToDelete);
//            Files.deleteIfExists(fileToDelete);

//            Path fileToMove = FileSystems.getDefault().getPath("Paths","Examples","file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Paths","Examples","file1.txt");
//            Files.move(fileToMove, destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Paths","Examples","file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Paths","Examples","file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Paths","Examples","DIR1");
//            copyFile = FileSystems.getDefault().getPath("Paths","Examples","DIR4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException  e) {
            System.out.println(e.getMessage());
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
