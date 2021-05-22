package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/22/2021 , 
    CREATED ON : 3:49 PM
*/

import java.io.*;
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

            RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = randomAccessFile.getChannel();
            outPutBytes[0] = 'a';
            outPutBytes[1] = 'b';
            byteBuffer.flip();
            long numBytesRead = channel.read(byteBuffer);
            if(byteBuffer.hasArray()) {
                System.out.println("byte buffer = " + new String(byteBuffer.array()));
            }

            // Absolute Read
            integerBuffer.flip();
            numBytesRead = channel.read(integerBuffer);
            System.out.println(integerBuffer.getInt(0));
            integerBuffer.flip();
            numBytesRead = channel.read(integerBuffer);
            System.out.println(integerBuffer.getInt());

            // Relative Read
//            integerBuffer.flip();
//            numBytesRead = channel.read(integerBuffer);
//            integerBuffer.flip();
//            System.out.println(integerBuffer.getInt());
//            integerBuffer.flip();
//            numBytesRead = channel.read(integerBuffer);
//            integerBuffer.flip();
//            System.out.println(integerBuffer.getInt());

            channel.close();
            randomAccessFile.close();




//            System.out.println("outPutBytes = " + new String(outPutBytes));

//            RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat","rwd");
//            byte[]b  = new byte[outPutBytes.length];
//            randomAccessFile.read(b);
//            System.out.println(new String(b));
//
//            long integerOne = randomAccessFile.readInt();
//            long integerTwo = randomAccessFile.readInt();
//            System.out.println(integerOne);
//            System.out.println(integerTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
