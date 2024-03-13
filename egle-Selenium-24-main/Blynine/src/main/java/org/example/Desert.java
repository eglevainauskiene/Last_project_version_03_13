package org.example;

public class Desert extends Product{
    private Type type;
    private int calories;
    private boolean isDairy;
    public Desert(String name, double price, Type type, int calories, boolean isDairy) {
        super(name, price);
        this.type = type;
    }

    enum Type {
        CAKE,
        PASTRIES,
        ICE_CREAM,
        FONDUE
    }
}
