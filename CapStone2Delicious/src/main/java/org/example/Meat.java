package org.example;

public class Meat extends Topping{
    public String name;
    public int sandwichSize;
    public boolean isExtra;


    public Meat(String name, int sandwichSize, boolean isExtra) {
        super(name);
        this.name = name;
        this.isExtra = isExtra;
        this.sandwichSize = sandwichSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   private double getMeatPriceBySize(){
        double price = 0.0;
        double extraCharge = 0.0;

        if( sandwichSize == 4){
            price = 1.00;
            extraCharge = 0.50;
        } else if ( sandwichSize == 8) {
            price = 2.00;
            extraCharge = 1.00;
        }else if(sandwichSize == 12){
            price = 3.00;
            extraCharge = 1.50;
        }
        return isExtra ? price + extraCharge : price;
   }

    @Override
    public double getPrice() {
        return getMeatPriceBySize();
    }

    @Override
    public String toString(){
       return getName() + ( isExtra ? "(extra meat)" : "(meat)") + "- $" + getPrice();
   }
    }

