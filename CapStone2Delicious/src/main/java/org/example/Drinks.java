package org.example;

public class Drinks implements OrderItem {
    private String size;
    public double price;
    public String flavor;

    public Drinks (String size, String flavor){
        this.size = size.toLowerCase();
        this.flavor = flavor;

        if (this.size.equals("small")){
            price = 2.00;
        } else if (this.size.equals("medium")) {
            price = 2.50;
        }else if(this.size.equals("large")){
            price = 3.00;
        }else{
            price = 0.0;
        }
    }
    public String getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return size.toUpperCase() + " " + flavor.toUpperCase() + " - $" + price;
    }

    @Override
    public double getItemTotal() {
        return getPrice();
    }
}
