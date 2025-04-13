package org.example;

import java.util.Scanner;

public class Week1FinancialCalculator2 {
    public static void main(String[] args) {
        //deposit
        //interest rate
        //number of years
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your deposit?");
        double p = scanner.nextDouble();

        System.out.println("What is your interest rate");
        double c = scanner.nextDouble();

        System.out.println("What is the number of years");
        double t = scanner.nextDouble();

        //future value
        //number of years
        //divide rate by 100
        //double years =365;
        double r = c / 100;

        //FV = P*(1+(r/n))^(n*t)
        //P = principal/deposit
        //R=Rate
        //t=number of years

        //n=365(daily compounding)


        double o =r/365;
        double x =Math.pow((o+1),(365 * t));
        double fv =x * p;
        double interest = fv-p;

        System.out.printf(" the value is $%.2f and interest earned is $%.2f",fv,interest);













    }
}
