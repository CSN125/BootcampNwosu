package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and 10");
        int number = scanner.nextInt();

        System.out.println("Pick a number between 1 and 50");
        int number2 = scanner.nextInt();

        System.out.println(number+number2);



    }
}