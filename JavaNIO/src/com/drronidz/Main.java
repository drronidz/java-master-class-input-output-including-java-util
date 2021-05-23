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

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

            channel.position(int3pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());
            readBuffer.flip();

            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());

            channel.position(int1Pos);
            readBuffer.flip();
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            byte[] outputString = "Hello, World!".getBytes();
            long stringPosition = 0;
            long integerOnePosition = outputString.length;
            long integerTwoPosition = integerOnePosition + Integer.BYTES;
            byte[] outputStringTwo = "Nice to meet You".getBytes();
            long stringTwoPosition = integerTwoPosition + Integer.BYTES;
            long integerThreePosition = stringTwoPosition + outputStringTwo.length;

            ByteBuffer integerBuffer = ByteBuffer.allocate(Integer.BYTES);
            integerBuffer.putInt(245);
            integerBuffer.flip();
            binChannel.position(integerOnePosition);
            binChannel.write(integerBuffer);

            integerBuffer.flip();
            integerBuffer.putInt(-98765);
            integerBuffer.flip();
            binChannel.position(integerTwoPosition);
            binChannel.write(integerBuffer);

            integerBuffer.flip();
            integerBuffer.putInt(1000);
            integerBuffer.flip();
            binChannel.position(integerThreePosition);
            binChannel.write(integerBuffer);

            binChannel.position(stringPosition);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(stringTwoPosition);
            binChannel.write(ByteBuffer.wrap(outputBytes2));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
