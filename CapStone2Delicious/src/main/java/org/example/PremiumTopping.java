package org.example;

public class PremiumTopping extends Topping {
   public PremiumTopping(String name, double price){
       super(name);
   }
   @Override
    public String toString(){
       return getName() + "($" + getPrice() + ")";
   }


}
