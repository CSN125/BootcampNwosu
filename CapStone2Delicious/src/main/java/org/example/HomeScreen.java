package org.example;

import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    private static final Scanner scanner = new Scanner(System.in);
    private final Order order = new Order();

    public void displayMenu() {
        boolean choice = true;

        //System.out.println("Welcome to Foreign DELI-cious Sandwich Shop");

        while (choice) {
            System.out.println("\n Welcome to Foreign Deli-Cious Sandwich Shop ");
            System.out.println("1) Build a Sandwich");
            System.out.println("2) Add Chips");
            System.out.println("3) Add drink");
            System.out.println("4) Checkout");


            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    Sandwich sandwich = SandwichBuilder.buildSandwich();
                    order.addItemToOrder(sandwich);
                    System.out.println("Sandwich added to your order");
                    break;

                case "2":

                    System.out.println("Enter chip");

                    System.out.println(" BBQ");
                    System.out.println(" Sour Cream");
                    System.out.println(" Salt & Vinegar");
                    System.out.println(" Lays");

                    String chip = scanner.nextLine();
                    Chips chips = new Chips(chip);
                    order.addItemToOrder(chips);
                    System.out.println("chips added");

                    break;
                case "3":
                    System.out.println("Enter drink name:");
                    System.out.println("Coke");
                    System.out.println("Lemonade");
                    System.out.println("Tea");

                    String drinkName = scanner.nextLine();

                    System.out.println("Enter drink size (Small, Medium, Large):");
                    String drinkSize = scanner.nextLine();
                    Drinks drinks1 = new Drinks(drinkSize, drinkName);

                    order.addItemToOrder(drinks1);
                    System.out.println("drink added");
                    break;
                case "4":

                    checkout();
                    System.out.println("Have A DELIcious Day!");
                    choice = false;
                    break;




            }
        }
    }

    void checkout() {

        System.out.println("Receipt");

        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item);
        }

            System.out.println(order.getToTalCost());
            System.out.println("Checkout Y/N");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("1)Confirm");
                System.out.println("2) Cancel");
                String confirmChoice = scanner.nextLine();
                if (confirmChoice.equals("1")) {
                    saveTransaction();
                    System.out.println("Order has been confirmed");
                } else if (confirmChoice.equals("2")) {
                    System.out.println("Order Canceled");
                }
            } else {

                System.out.println("Thank you for visiting Foreign Deli-Ous, Have a great day! ");
            }

    }

    public void saveTransaction() {
        FileManager.saveToFile(order);
    }
}


