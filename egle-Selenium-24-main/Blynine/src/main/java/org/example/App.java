package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    Restaurant restaurant = new Restaurant("AuGusto blynine");
    Desert pancakes = new Desert("Lietiniai",5.99, Desert.Type.CAKE,50, true);
    MainDish fish = new MainDish("Menke",4.56,Type.FISH,false,100);
    Beverage juice = new Beverage("CIDO", Beverage.Type.JUICE,1.50,200,false);
    pancakes.setQuantity(20);
    juice.setQuantity(100);
    fish.setQuantity(15);
    restaurant.addProduct(pancakes);
    restaurant.addProduct(fish);
    restaurant.addProduct(juice);
    restaurant.printMenu();
    Order order = new Order();
    order.addProduct(fish);
    order.addProduct(juice);
    order.addProduct(pancakes);

        System.out.println(order.getPrice());
        restaurant.order(order);
        restaurant.printMenu();
    }
}
