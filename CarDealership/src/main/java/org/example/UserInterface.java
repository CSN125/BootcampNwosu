package org.example;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

//import static sun.awt.CGraphicsEnvironment.init;

public class UserInterface {
    Dealership dealership;
    DealershipFileManager dealershipFileManager;

    public void display() {

        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Welcome to CSN dealership");
            System.out.println("1) Find vehicles within price range");
            System.out.println("2) Find vehicles by make / model");
            System.out.println("3) Find vehicles by color");
            System.out.println("4) Find vehicles by mileage range");
            System.out.println("5) Find by year range");
            System.out.println("6) Find vehicles by type");
            System.out.println("7) List all vehicles");
            System.out.println("8) Add a vehicles");
            System.out.println("9) Remove a vehicle");
            System.out.println("10) Exist");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getByPrice(scanner);
                    break;
                case 2:
                    getByMakeModel(scanner);
                    break;

                case 3:
                    getByColor(scanner);
                    break;

                case 4:
                    getMileage(scanner);
                    break;

                case 5:
                    getByYear(scanner);
                    break;

                case 6:
                    getByVehicleType(scanner);
                    break;
                case 7:
                    getVehicleList();
                    break;

                case 8:
                    addVehicles(scanner);
                    break;

                case 9:
                    removeVehicles(scanner);
                    break;

                case 10:


                case 0:
                    System.exit(10);
                    break;
                default:
                    System.out.println("Error");


            }
        }
    }

    private void init() {
        dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    private void getByPrice(Scanner scanner) {
        System.out.println("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum price:");
        double max = scanner.nextDouble();
        helperMethod(dealership.getVehiclesByPrice(min, max));
    }

    private void getByMakeModel(Scanner scanner) {
        //List<Vehicle> results = dealership.getVehicleByMakeModel(make,model);
        System.out.println("Enter vehicle make:");
        String make = scanner.nextLine().toLowerCase();
        System.out.println("Enter vehicle model");
        String model = scanner.nextLine().toLowerCase();
        helperMethod(dealership.getVehicleByMakeModel(make, model));
    }

    private void getByColor(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter vehicle color");
        String color = scanner.nextLine().toLowerCase();
        if (dealership.getVehicleByColor(color).isEmpty()) {
            System.out.println("color not found");
        }
        helperMethod(dealership.getVehicleByColor(color));
    }

    private void getMileage(Scanner scanner) {
        System.out.println(" Enter minimum mileage");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum mileage");
        double max = scanner.nextDouble();
        helperMethod(dealership.getVehicleByMileage(min, max));
    }

    private void getByYear(Scanner scanner) {
        System.out.println("Enter minimum year of the vehicle");
        int minYear = scanner.nextInt();
        System.out.println("Enter maximum year of the vehicle");
        int maxYear = scanner.nextInt();
        helperMethod(dealership.getVehicleByYear(minYear, maxYear));
    }

    private void getByVehicleType(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter vehicle type");
        String type = scanner.nextLine().toLowerCase();
        helperMethod(dealership.getVehiclesByType(type));
    }

    private void getVehicleList() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("All vehicles in inventory");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available in inventory");
        } else {
            helperMethod(vehicles);

        }
    }

    private void addVehicles(Scanner scanner) {
        System.out.println("Enter VIN number");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter year");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make");
        String make = scanner.nextLine();
        System.out.println("Enter model");
        String model = scanner.nextLine();
        System.out.println("Enter type");
        String type = scanner.nextLine();
        System.out.println("Enter color");
        String color = scanner.nextLine();
        System.out.println("Enter mileage");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" Enter price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, mileage, price));
        dealershipFileManager.saveDealerShip(dealership);
        System.out.println("Vehicle has been added successfully");
    }

    private void removeVehicles(Scanner scanner) {
        System.out.println("Enter VIN number");
        int vin2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter year");
        int year2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make");
        String make2 = scanner.nextLine();
        System.out.println("Enter model");
        String model2 = scanner.nextLine();
        System.out.println(" Enter vehicle type");
        String type2 = scanner.nextLine().toLowerCase();
        System.out.println("Enter color");
        String color2 = scanner.nextLine();
        System.out.println("Enter mileage");
        int mileage2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter price");
        double price2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("vehicle has been removed");

        dealership.removeVehicle(new Vehicle(vin2, year2, make2, model2, type2, color2, mileage2, price2));
        dealershipFileManager.saveDealerShip(dealership);
    }

    private void helperMethod(List<Vehicle> vehicles) {
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).toString());
        }
    }

    private void saleCar(String name, String date, String email, Vehicle vehicle){
        ContractFileManager contractFileManager = new ContractFileManager();
        SalesContract salesContract = new SalesContract()
    }

}



