package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    private static final Scanner scanner = new Scanner(System.in);
    List<Topping> toppings = new ArrayList<>();

    public static Sandwich buildSandwich() {
        System.out.println("\n Build your sandwich");

        Sandwich sandwich = new Sandwich();

        System.out.println("What type of bread would you like");
        for (ToppingType.BreadType bread : ToppingType.BreadType.values()) {
            System.out.println("-" + bread.name());
        }
        System.out.println("Enter bread type ");
        ToppingType.BreadType breadType = ToppingType.BreadType.valueOf(scanner.nextLine().toLowerCase());
        sandwich.setBreadType(breadType.toString());

        System.out.println("Enter sandwich size(4, 8, 12) :");
        int size = Integer.parseInt(scanner.nextLine());
        sandwich.setSize(size);

        //Sandwich sandwich = new Sandwich();//(size, breadType.name(), buildSandwich().isToasted() topping);
        System.out.println("would you like your sandwich toasted? (yes/no)");
        String answer = scanner.nextLine();
        sandwich.setToasted(answer.equalsIgnoreCase("yes"));


            System.out.println("choose meats of choice or 'done");
            for (ToppingType.MeatType meat : ToppingType.MeatType.values()) {
                System.out.println("-" + meat);
            }



                    String input = scanner.nextLine().toLowerCase();


        System.out.println("\n Would you like extra meat (yes/no)");
        if(scanner.nextLine().equalsIgnoreCase("yes")){
            sandwich.addTopping(new Meat(input, size, true));
        } else{
            sandwich.addTopping(new Meat(input, size, false));

        }



                System.out.println("Choose cheese of choice or done");
                for (ToppingType.CheeseType cheese : ToppingType.CheeseType.values()) {
                    System.out.println("-" + cheese);
                }

                    System.out.println("Enter cheese of choice or done ");
                    String input2 = scanner.nextLine().toLowerCase();
                    if (input.equals("done"));

        System.out.println("Would you like extra cheese? (yes/no)");
        if(scanner.nextLine().equalsIgnoreCase("yes")){
            sandwich.addTopping(new Cheese(input2, size, true));
        }else{
            sandwich.addTopping(new Cheese(input2, size, false));
        }



        while (true){
                System.out.println("Choose your toppings or 'done :");
                for(ToppingType.RegularToppings toppings : ToppingType.RegularToppings.values()){
                    System.out.println("-" + toppings.name());
                }

                  // System.out.println("Add regular topping:");
                   String input3 = scanner.nextLine().toUpperCase();
                   if(input3.equalsIgnoreCase("done")) break;
                   sandwich.addTopping(new RegularTopping(input3));
               }
        while(true){
                System.out.println("\n Choose your sauce or done ");
               for(ToppingType.Sauces sauce : ToppingType.Sauces.values()){
                   System.out.println("_" + sauce.name());
               }
                   String input4 = scanner.nextLine().toUpperCase();

                   if(input4.equalsIgnoreCase("done"))break;
                 sandwich.addTopping(new Sauces(input4));
               }

                System.out.println("\n Your sandwich is ready ");

               System.out.println(sandwich);
        return sandwich;


            }




    }

