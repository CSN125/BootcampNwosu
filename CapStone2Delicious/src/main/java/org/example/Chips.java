package org.example;

public class Chips implements OrderItem{
    private String type;

    public Chips(String type){
        this.type = type;
    }
    public double getCost(){
        return 1.50;
    }

  @Override
    public String toString(){
        return String.format("%s Chips - $%.2f", type, getCost());
  }

    @Override
    public double getItemTotal() {
       return getCost();
    }
}
