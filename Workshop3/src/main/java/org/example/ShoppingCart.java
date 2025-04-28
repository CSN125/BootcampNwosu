package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    //TODO add product to cart method
    public void addProductToCart(Product product){
        products.add(product);
        System.out.println(product.getProductName() + "product has been added to your cart");


    }
    //TODO remove product from cart method
    //you will need the sku of the product tou want to remove
    //loop through the list of products
    //check to see if the sku matches
    //get that product, then use the remove method after the loop
    public void removeProduct(String SKU){
        for(Product product : products){
            if(product.getSKU().equalsIgnoreCase(SKU)){
                products.remove(product);
                System.out.println(product.getProductName() + "has been removed from your cart ");
                break;
            }
        }


    }

    public double getCartTotal(){
        if(products != null){
            System.out.println("Cart is empty");
        }else{
            double total = 0;
            System.out.println("\n Time to checkout");
            for(Product product : products){
                System.out.println("SKU" + product.getSKU());
                System.out.println("Name" + product.getProductName());
                System.out.println("Price" + product.getPrice());
                System.out.println("Department" + product.getDepartment());

                total += product.getPrice();
            }
            System.out.println("Total Amount $%.2f" + total);
            System.out.println("Thank you for shopping with us ");
        }
       return 0.0;
    }

    public void displayItems(){
        if(products.isEmpty()){
            System.out.println("Your cart is empty ");
        }else{
            System.out.println("\n Your Shopping Cart");
            for(Product product : products){
                System.out.println("SKU" + product.getSKU());
                System.out.println("Name" + product.getProductName());
                System.out.println("Price" + product.getPrice());
                System.out.println("Department" + product.getDepartment());
            }

        }
    }

    //TODO get cart total method
}

