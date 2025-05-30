package org.example;

public abstract class Topping {
    public String name;
    public double price;


    public Topping(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setGetPrice(double getPrice) {
        this.price = getPrice;
    }

    @Override
    public String toString(){
        return name;
    }

}


