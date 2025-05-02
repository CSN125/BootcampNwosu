package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Ledger {


    public static void allTransactions(){
        System.out.println("All transactions");
        List<Transaction> transactions = TransactionFileManager.readFile();
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }

    }

    public static void deposits() {
        System.out.println("Deposits");
        List<Transaction> transactions = TransactionFileManager.readFile();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction.toString());
            }
        }


    }
    public static void payment () {
        System.out.println("Payments");
        List<Transaction> transactions =TransactionFileManager.readFile();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction.toString());
            }
        }

    }
    public static void vendor(){
        //System.out.println("Vendors");
        List<Transaction> transactions = TransactionFileManager.readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vendor to search");
        String vendor = scanner.nextLine();

        boolean found = false;
        for(Transaction transaction : transactions){
            if(transaction.getVendor().contains(vendor)) {
                String row = transaction.toString();
                System.out.println(row);
                found = true;
            }
            }
            if(!found){
                System.out.println("Error");
            }
        }



    public static void monthToDate(){
        System.out.println("\n Month to date");
        List<Transaction> transactions = TransactionFileManager.readFile();
        LocalDate today = LocalDate.now();

        System.out.println("Date| Time| Description|Vendor|Amount");
        for(Transaction transaction : transactions) {
            LocalDate date = transaction.getDate();

            if(date.getMonth() == today.getMonth() && date.getYear() == today.getYear()){
                System.out.println(transaction.toString());
            }

        }
    }

}

