package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Principal
        //Interest rate
        //loan length
        System.out.println("Enter the following instructions?");


        System.out.println("What is your current principle?");
        double p = scanner.nextDouble();

        System.out.println("What is your annual interest rate?");
        double k = scanner.nextDouble();
        double r = (k/12) /100;

        System.out.println("What is your annual loan length?");
        double loanYears = scanner.nextInt();
        double n = (loanYears * 12);




        //Calculate the monthly interest rate
        //divide the annual interest rate by 12
        //divide by 100
        //convert it to decimals
        //calculate the number of monthly payments
        //multiply the loan length by 12


        //M = P[r(1+r)^n] / [(1+r)^n-1]
        //double j= 1 + r;
        //double l= Math.pow(j,n);
        //double u= l * r;
        //double left= p * u;
        //double right= l - 1;
        //double monthlyPayments= left / right;
        //double Interest= monthlyPayments * n - p;

        double monthlyPayments = (p * r) / (1 - Math.pow(1 + r, -n));
        double totalInterest = (monthlyPayments * n) - p;
        System.out.printf("Monthly bill is a total %.2f/n. The total interest due is %.2f/n.",monthlyPayments,totalInterest);

        }

    }



