package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public Dealership getDealership(){
        try{
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Dealership dealership;
            //ArrayList<vehicle> vehicles = new ArrayList<>();
            String[] added =bufferedReader.readLine().split("\\|");
            String name = added[0];
            String address = added[1];
            String phone = added[2];
            Dealership dealership = new Dealership(name, address, phone);

            String line;

            while((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];

                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            bufferedReader.close();
            return dealership;

        }catch(IOException ex){
            System.out.println("failed to load");

        }
        return null;
    }
    public void saveDealerShip(Dealership dealership){
        try{
            File file = new File("src/main/resources/inventory.csv");
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getPhone()+"\n");

            for (Vehicle vehicle :dealership.getAllVehicles()){
                fileWriter.write(vehicle.toString().trim() + "\n");
                System.out.println(vehicle);
            }

            fileWriter.close();

            //FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv");
            //BufferedWriter writer = new BufferedWriter(fileWriter);

            //for(Vehicle vehicle: dealership.getAllVehicles()){
                //String line = vehicle.getVin() + "|" +
                        //vehicle.getYear() + "|" +
                        //vehicle.getMake() + "|" +
                       // vehicle.getModel() + "|" +
                        //vehicle.getVehicleType() + "|" +
                        //vehicle.getColor() + "|" +
                        //vehicle.getOdometer() + "|" +
                        //vehicle.getPrice() + "|";
                //fileWriter.write(line);
               // writer.newLine();
            //
            //writer.close();

            //System.out.println( "Dealership data saved successfully");
        } catch (IOException e) {
            System.out.println("Error saving dealership to file");

        }
    }


}

