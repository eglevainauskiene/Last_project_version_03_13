package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items = new ArrayList<>();
    public void addProduct(Product product){
        items.add(product);
    }
    public List<Product> getItems(){
        return items;
    }
    public double getPrice(){
      double sum = 0;
        for(Product p : items) {
         sum += p.getPrice();
        }
        return sum;
    }
}
