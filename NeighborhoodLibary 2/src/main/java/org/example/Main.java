package org.example;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Book[] inventory = new Book[20];

        Book book = new Book(101, "978-0135166307", "Effective Java", true, "Sarah Miles");
        Book book1 = new Book(102, "978-0596009205", "Head First Java", false, "");
        Book book2 = new Book(103, "978-1491950357", "Java: The Complete Reference", true, "David Kim");
        Book book3 = new Book(104, "978-0132350884", "Clean Code", false, "");
        Book book4 = new Book(105, "978-1119457893", "Beginning Programming with Java", true, "Alicia Thomas");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            //menu time
            System.out.println("Welcome to the Neighborhood Library");
            System.out.println("1.Show available books");
            System.out.println("2.Show checked out books");
            System.out.println("3.Show checked in books");
            System.out.println("4. Exist please");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                displayBooks(inventory, scanner);
                break;
                case 2:
                 showCheckedOutBooks(inventory, scanner);
                    break;
                case 3:
                    checkInBook(inventory,scanner);

                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Please select 1 through 4");
                    break;
            }
        }


    }

    public static void displayBooks(Book[] inventory, Scanner scanner) {
        System.out.println("Available Books ");
        boolean available = false;
        for (Book book : inventory) {
            if (book != null && book.isCheckedOut())
                System.out.println("ID:" + book.getiD() +"ISBN" + book.getIsbn() + "Title" + book.getTitle());
            available = true;

            if(available){
                System.out.println(" book is not available right now");
                return;
            }
            System.out.print("Enter the ID of the book to check out (or 0 to go back): ");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            if (bookId == 0) {
                return;

        }
            //for(Book book : inventory){
                if(book != null && book.getiD() == bookId && book.isCheckedOut()){
                    System.out.println("Enter your name");
                    //String name = scanner.nextLine();
                    //book.setCheckedOut(true);
                   // book.setCheckedOutTo(name);
                    System.out.println("You checked out" + book.getTitle());
                    return;
                }
            }
            System.out.println("Book is not available");
    }

    public static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {
        System.out.println("What book are you returning?");


        boolean isCheckedOut = false;
        for (Book book : inventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("ID" + book.getiD() + "ISBN" + book.getIsbn() + "Title" + book.getTitle() + "checked out to" + book.getCheckedOutTo());
                isCheckedOut = true;
            }
        }
        if (isCheckedOut) {
            System.out.println("No book are currently checked out ");
        }
        System.out.println("Enter 'C' to check in book or 'X' to return to home ");
        String choice = scanner.nextLine().toUpperCase();
        switch (choice) {
            case "C":
                System.out.println("enter c to check in book");
                break;
            case "X":
                System.out.println("Returning to back home");
                break;
            default:
                System.out.println("Invalid input.");
        }

    }


    public static void checkInBook (Book[] inventory, Scanner scanner){
        System.out.println("Enter the ID of the book you want to check in");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for(Book book : inventory){
            if(book != null && book. getiD() ==bookId){
                if(book.isCheckedOut()){
                    System.out.println("That book is already checked in");

                } else{
                    book.checkIn();
                    System.out.println("book has been check in");
                }
            }
        }
        System.out.println("Book ID not found");
    }
}























        //for(int i = 0; i < inventory.length; i++){
            //Book currentBook = inventory[i];
            //if(currentBook != null && currentBook.getTitle().equalsIgnoreCase(title));
           // System.out.println(currentBook.getTitle());



