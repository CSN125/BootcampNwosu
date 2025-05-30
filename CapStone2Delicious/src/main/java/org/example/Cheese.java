package org.example;

public class Cheese extends Topping {
    public String name;
    public int sandwichSize;
    public boolean isExtra;


    public Cheese(String name,int sandwichSize,boolean isExtra ) {
        super(name);
        this.name = name;
        this.isExtra = isExtra;
        this.sandwichSize = sandwichSize;

    }


    private double getCheesePriceBySize(){
        double price = 0.0;
        double extraCharge =0.0;

        if (sandwichSize == 4){
          price = 0.75;
          extraCharge = 0.30;
        } else if (sandwichSize == 8) {
            price = 1.50;
            extraCharge =0.60;
        } else if (sandwichSize == 12) {
            price = 2.25;
            extraCharge =0.90;

        }
        if(isExtra){
            return price + extraCharge;
        }else {
            return price;
        }
    }

    @Override
    public double getPrice() {
        return getCheesePriceBySize();
    }

    @Override
    public String toString(){
         return getName() + ( isExtra ? "(extra cheese)" : "(cheese)") + "- $" + getPrice();

     }
    }



