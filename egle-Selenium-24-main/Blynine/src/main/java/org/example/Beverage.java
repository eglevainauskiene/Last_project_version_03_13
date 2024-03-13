package org.example;

public class Beverage extends Product{
   private boolean isAlcoholic;
    private int volume;
    private Type type;
    public Beverage(String name, Type type,double price, int volume, boolean isAlcoholic) {
        super(name, price);
        this.isAlcoholic = isAlcoholic;
        this.volume = volume;
        this.type = type;
    }
    enum Type {
        WATER,
        LEMONADE,
        SODA,
        BEER,
        WINE,
        JUICE
    }
}
