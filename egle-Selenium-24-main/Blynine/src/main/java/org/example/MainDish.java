package org.example;

public class MainDish extends Product{
    private Type type;
    private boolean isVegan;
    private int calories;
public MainDish(String name, double price, Type type, boolean isVegan, int calories){
    super(name, price);
}

}

enum Type{
    SOUP,
    MEAT,
    FISH,
    SALAD,
    PANCAKE
}