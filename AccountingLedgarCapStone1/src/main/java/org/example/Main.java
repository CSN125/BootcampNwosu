package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import static org.example.Ledger.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<org.example.Transaction> transactions = TransactionFileManager.readFile();
        // Reports report = new Reports();
        while (true) {
            System.out.println("Home Screen");
            System.out.println("D Add Deposit");
            System.out.println("P make payment ");
            System.out.println("L ledger");
            System.out.println("X Exist");
            System.out.println("Choose an option D, P, L, X");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "D":
                    addDeposit(scanner);

                case "P":
                    makePayment(scanner);
                case "L":
                    Ledger(transactions, scanner);
                case "X":
                    Exist();
                    break;
            }
        }
    }

    public static void addDeposit(Scanner scanner) {
        System.out.println("Add deposit");

        System.out.println("Enter description");
        String description = scanner.nextLine();

        System.out.println("Enter Vendor");
        String vendor = scanner.nextLine();

        System.out.println("Enter Amount");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        TransactionFileManager.appendTransaction(payment);

        System.out.println("Deposit have been added");
    }

    public static void makePayment(Scanner scanner) {
        System.out.println("\n Make payment ( must be debit");
        System.out.println("Enter description");
        String description = scanner.nextLine();

        System.out.println("Enter Vendor");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount > 0) {
            amount = amount * -1;
        }
        Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        TransactionFileManager.appendTransaction(payment);
        System.out.println("Payment recieved");

    }

    public static void Ledger(List<Transaction> transactions, Scanner scanner){
        while(true){
            System.out.println("Ledger\n");
            System.out.println("A) Display all entries");
            System.out.println("B) Deposits");
            System.out.println("C) Payments");
            System.out.println("D) Reports");
            System.out.println("E) Back home");

            String choice = scanner.nextLine().toUpperCase();

            switch(choice){
                case "A":
                    allTransactions();
                    break;
                case "B":
                    deposits();
                    break;
                case "C":
                    payment();
                    break;
                case "D":
                    Reports(scanner);
                    break;
            }
        }
    }

    public static void Reports(Scanner scanner){
        while(true){
            System.out.println("1) Month to Date");
            System.out.println("2) Search by vendor ");
            String choice = scanner.nextLine();

            switch(choice){
                case "1":
                    monthToDate();
                    break;
                case "2":
                    //String name = scanner.nextLine();
                    vendor();
                    break;


            }
        }
    }

    public static void Exist(){
        System.out.println("\n Exist applications please");
    }


}






//displaytranaction
//findtra