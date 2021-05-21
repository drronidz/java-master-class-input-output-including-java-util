package com.timbuchalka;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/21/2021 , 
    CREATED ON : 10:16 PM
*/

public class IndexRecord {
    private int startByte;
    private int length;

    public IndexRecord(int startByte, int length) {
        this.startByte = startByte;
        this.length = length;
    }

    public int getStartByte() {
        return startByte;
    }

    public void setStartByte(int startByte) {
        this.startByte = startByte;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
