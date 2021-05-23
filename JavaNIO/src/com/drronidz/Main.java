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
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outPutBytes = "Hello World!".getBytes();
            byte[] outPutBytes2 = "Nice to meet you".getBytes();
            buffer.put(outPutBytes).putInt(245).putInt(-98765).put(outPutBytes2).putInt(1000);
            buffer.flip();

            /*
            * read(ByteBuffer) - reads bytes beginning at the channel's current position, and after
            *                    the read, updates the position accordingly.
            *                    Note that now we're talking about the channel's position, not the byte
            *                   of course, the bytes will be placed into the buffer starting at its current
            *                   position.
            * write(ByteBuffer) - the same as read, expect it writes. There's one exception.
            *                   If a datasource is opened is APPEND mode, then the first write will take
            *                   place starting at the end of the datasource, rather than at position 0.
            *                   After the write, the position will be updated accordingly.
            *
            *
            *
            * */

//            buffer.put(outPutBytes);
//            buffer.putInt(245);
//            buffer.putInt(-98765);
//            buffer.put(outPutBytes2);
//            buffer.putInt(1000);

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();
            
            binChannel.write(buffer);

            RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outPutBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String (inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outPutBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
