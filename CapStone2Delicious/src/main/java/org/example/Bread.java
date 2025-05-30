package org.example;

public class Bread extends Topping{
    public int size;
    public double price;

    public Bread(String name, double price) {
        super(name);
        this.size = size;
        this.price = price;

    }

    public void setSize(int size) {
        this.size = size;
    }




    public void setPrice(double price) {
        this.price = price;
    }

    public static double calculateTotalPrice  (int size){
        if(size == 4)
            return 5.50;
        else if (size == 8)
            return 7.00;
        else if (size == 12)
            return 8.50;
        else return 0.00;
    }
    public int getSize(){
        return size;
    }




    @Override
    public String toString() {
        return size + "\n" + getName() + "bread - $" + getPrice();
    }
}
