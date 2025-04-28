package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<Product> readFiles(){
        //Use FileReader class and Buffered Reader to load the file
        //loop through the file line by line
        //Skip the first line of the file because its the header
        //take each line and split it on the |
        //WE need to convert data as need
        //price will need conversion to a double
        //create a product object to hold the data
        //put it the product in a list

        try{
            FileReader fileReader = new FileReader( "src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //skip the first line
            bufferedReader.readLine();// skip ;ine automatically

            String input;

            List<Product> productList = new ArrayList<>();

            while((input = bufferedReader.readLine()) != null){
               String[] row =  input.split("\\|");
               //rejects is a pattern matcher, tell me if it matches or not
                //index o is the SKU, index 1 product name, index 2 is the price, and index 3 is department
                String sku = row[0];
                String productName = row[1];
                double price = Double.parseDouble(row[2]); // parse converts and then whatever ur converting
                String department =row[3];
                Product product = new Product(sku, productName, price, department);
                productList.add(product);
            }

            bufferedReader.close();
            return productList;


        }
        catch(IOException ex){
            System.out.println("failed to load csv file");
            return new ArrayList<>();

        }

    }

    public static void writeFile(List<Product> productList){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/products.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("SKU|Product Name|Price|Department");
            bufferedWriter.newLine();

            for(Product product : productList){
                String line = product.getSKU() + "|" +
                 product.getProductName() + "|" +
                 product.getPrice() + "|" +
                 product.getDepartment();
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }
        }catch (IOException ex){
            System.out.println("failed to write to csv file.");
            ex.printStackTrace();

        }
    }
}
