package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/17/2021 , 
    CREATED ON : 12:37 AM
*/

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

    private static int divide() {
        int x,y;
        try {
            x = getInt();
            y = getInt();
        } catch (NoSuchElementException e) {
            throw  new ArithmeticException("No suitable input");
        }
        System.out.println("x is " + x +", y is " + y);
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by Zéro");
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an Integer");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                // go round again. Read past the end of line in the input first.
                scanner.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }

    }
}
