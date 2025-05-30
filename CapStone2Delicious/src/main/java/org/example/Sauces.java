package org.example;

public class Sauces extends Topping{
    public Sauces(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return getName() + " (sauce)";
        }
    }



