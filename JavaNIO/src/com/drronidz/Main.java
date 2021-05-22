package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/22/2021 , 
    CREATED ON : 3:49 PM
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel();) {
            byte[] outPutBytes = "Hello World!".getBytes();
            ByteBuffer byteBuffer = ByteBuffer.wrap(outPutBytes);
            int numberBytes = binChannel.write(byteBuffer);
            System.out.println("numberBytes written was: " + numberBytes);

            ByteBuffer integerBuffer = ByteBuffer.allocate(Integer.BYTES);
            integerBuffer.putInt(245);
            integerBuffer.flip();
            numberBytes = binChannel.write(integerBuffer);
            System.out.println("numberBytes written was: " + numberBytes);

            integerBuffer.flip();
            integerBuffer.putInt(-98767);
            integerBuffer.flip();
            numberBytes = binChannel.write(integerBuffer);
            System.out.println("numberBytes written was: " + numberBytes);

//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();
//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
//            List<String> lines = Files.readAllLines(dataPath);
//            for (String line : lines) {
//                System.out.println(lines);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
