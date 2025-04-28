package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Loading csv file");
        FileLoader.readFiles();
        List<Product> products = FileLoader.readFiles();
        ShoppingCart cart = new ShoppingCart();

        for (Product product : products) {
            System.out.println(product.getProductName());
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Enter the product you want to buy");
            System.out.println("1. View all products");
            System.out.println("2 Search by SKU");
            System.out.println("3. Search by price range");
            System.out.println("4.Search by name");
            System.out.println("5 Add cart");
            System.out.println("6 Remove from cart");
            System.out.println("7 View cart");
            System.out.println("8 Checkout");
            System.out.println("9 Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayProducts(products);
                    break;
                case 2:
                    System.out.println("Enter the sku");
                    String SKU = scanner.nextLine();
                    Product foundProduct = findBySku(products, SKU);
                    if (foundProduct != null) {
                        System.out.println("found" + foundProduct.getProductName());
                    } else {
                        System.out.println("Product not found");
                    }
                    return;
                case 3:
                    System.out.println("Enter the minimum price");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    filterByPriceRange(products, minPrice, maxPrice);
                    return;


                case 4:
                    System.out.println("Please enter the product name");
                    String productName = scanner.nextLine();
                    List<Product> matchingProducts = searchByName(products, productName);
                    if(matchingProducts != null){
                        System.out.println("No product found");
                        for(Product product : matchingProducts){
                            System.out.println(product.getProductName() + "-$" + product.getPrice());
                        }
                        return;
                    }
                case 5:
                    System.out.println("Enter the SKU of the product you want to add to cart");
                    String skuToAdd = scanner.nextLine();
                    Product productToAdd = findBySku(products,skuToAdd);
                    if(productToAdd != null){
                        cart.addProductToCart(productToAdd);
                        System.out.println(productToAdd.getProductName() + "has been added to your cart");
                    }else{
                        System.out.println("Product with SKU" + skuToAdd + " Product not found");
                    }
                    break;

                case 6:
                    System.out.println("Enter the sku of the product you want to remove from your cart");
                    String skuToRemove = scanner.nextLine();
                    cart.removeProduct(skuToRemove);
                    break;

                case 7:
                    cart.displayItems();
                    break;

                case 8:
                    cart.getCartTotal();

                case 9:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");




            }

        }
    }

    public static void displayProducts(List<Product> products) {
        System.out.println("Available Products");
        for (Product product : products) {
            System.out.println("SKU" + product.getSKU());
            System.out.println("Name" + product.getProductName());
            System.out.println("Price" + product.getPrice());
            System.out.println("Department" + product.getDepartment());
        }
    }

    public static Product findBySku(List<Product> products, String SKU) {

        for (Product product : products) {
            if (product.getSKU().equalsIgnoreCase(SKU)) {
                return product;
                //System.out.println("product found");
                //System.out.println("SKU" + product.getSKU());
                //System.out.println("Name" + product.getProductName());
                //System.out.println("Price" + product.getPrice());
                //System.out.println("department" + product.getDepartment());

            }
        }
        return null;
    }

    // Returns a list of products with names that contain the search string (case-insensitive)
    public static List<Product> searchByName(List<Product> products, String name) {
        List<Product> matches = new ArrayList<>();
        for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(name)){
                return matches;
            }
        }
        return null;
    }
    public static List<Product> filterByPriceRange(List<Product> products, double min, double max){
        List<Product> matches = new ArrayList<>();
        for(Product product : products){
            if(product.getPrice() >= min && product.getPrice() <= max){
                matches.add(product);
            }
        }
        if(matches != null){
            System.out.println("Product not found in the price range $" + min + " to $" + max);
        }else{
            System.out.println("Product found between $" + min + "and $" + max + " ");
            return matches;
        }
        return matches;
    }
}




