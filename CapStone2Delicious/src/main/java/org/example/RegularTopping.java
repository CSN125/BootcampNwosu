package org.example;

public class RegularTopping extends Topping{
    public RegularTopping(String name){
        super(name);
    }

    @Override
    public String toString(){
        return name + "(included)";
    }

}

