package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderItem {
    private int size;
    private String breadType;
    private boolean isToasted;
    private List<Topping> toppings;

    public Sandwich(int size, String breadType, boolean isToasted, List<Topping> toppings) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeToppingByName(String name) {
        toppings.removeIf(topping -> topping.getName().equalsIgnoreCase(name));
    }

    public Sandwich() {
        this.toppings = new ArrayList<>();
    }

    public double getBasePrice() {
        if (size == 4)
            return 5.50;
        else if (size == 8)
            return 7.00;
        else if (size == 12)
            return 8.50;
        else return 0.00;
    }


    public double calculateTotalPrice() {
        double total = 0.0;

        //get base Price
        total += getBasePrice();

        for (Topping topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sandwich Size: ").append(size).append("\"").append("\n");
        sb.append("Toppings:\n");

        for (Topping topping : toppings) {
            sb.append(" - ").append(topping.toString()).append("\n");
        }

        sb.append("Total Price: $").append(String.format("%.2f", calculateTotalPrice()));

        return sb.toString();
    }

    @Override
    public double getItemTotal() {
        return calculateTotalPrice();
    }
}




