package org.example;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String title;
    private List<Product> menu = new ArrayList<>();

    public Restaurant(String title) {
        this.title = title;
    }

    public void addProduct(Product product){
        menu.add(product);
    }
    public void order(Order order){
        order.getItems().removeIf(p -> !p.decreaseQuantity());
    }
    public void printMenu(){
        System.out.println("-------------------");
        System.out.println(title + "menu");
        for(Product p : menu ){
            System.out.println(p);
        }
        System.out.println("-------------------");
    }
}
