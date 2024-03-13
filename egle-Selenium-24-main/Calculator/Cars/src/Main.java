import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        Car vw = new Car("Volswagen", "Passat");
        Car bmw = new Car("BMW", "X5");
        Car mazda = new Car("Mazda", "363");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(vw);
        cars.add(bmw);
        cars.add(mazda);
        Scanner scanner = new Scanner(System.in);
        Car selectedCar = null;
        Path file = Paths.get("file.txt");
        cars.add(new Car("Toyota","Corola"));
        while(true){
            System.out.println("Select your action(cars, createCar, deleteCar, select, engine, drive, fuel, quit)");
            String action = scanner.next();
            if(action.equals("quit")) break;
            switch(action) {
                case "load" ->{
                    try {
                        List<String> lines = Files.readAllLines(file);

                        for(String data : lines){
                         Car newCar = new Car(data);
                         cars.add(newCar);
                        }
                        System.out.println(cars.size() + "cars loaded from" + file.getFileName() );
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                case "save" -> {
                    try {
                        String fileText = "";
                        for (Car c : cars) {
                            //Car.toFile();
                            fileText += c.toFile() + "\n";
                        }
                        Files.writeString(file, fileText);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
                case "deleteCar" ->{
                    System.out.println("Enter car number");
                    int index = readNumber(scanner) - 1;
                    try {
                        cars.remove(index);
                    } catch(IndexOutOfBoundsException e){
                        System.err.println("Selected car does not exist");
                    }
                }
                case "createCar" ->{
                    System.out.println("Choose a brand");
                    scanner.nextLine();
                    String brand = scanner.nextLine();
                    System.out.println("Choose a model");
                    String model = scanner.nextLine();
                    Car newCar = new Car(brand, model);
                    cars.add(newCar);
                }

                case"select" ->{
                    System.out.println("Enter car number");
                    int index = readNumber(scanner) - 1;
                    try {
                        selectedCar = cars.get(index);
                    } catch(IndexOutOfBoundsException e){
                        System.err.println("Selected car does not exist");
                    }
                }
                case "cars" ->{
                    for(int i=0; i<cars.size(); i++){
                        System.out.println(i+1 +"- " + cars.get(i));
                    }

                }
                case "engine" -> {
                    if(!checkSelection(selectedCar)) break;
                    boolean engine = selectedCar.swithEngine();
                    System.out.println(engine ? "Engine on" : "Engine off");
                }
                case "drive" -> {
                    if(!checkSelection(selectedCar)) break;
                    System.out.println("How many kilomenters?");
                    int km = readNumber(scanner);
                    int distance = selectedCar.drive(km);
                    if (distance == -1)
                    {
                        System.out.println("Turn on the engine");
                        break;
                    }
                    if(selectedCar.getFuel()==0)
                    {   selectedCar.swithEngine();
                        System.err.println("Out of fuel, engine off");
                    }

                }
                case "fuel" ->{
                    if(!checkSelection(selectedCar)) break;
                    System.out.println("How many liters?");
                    int l = readNumber(scanner);
                    int newL = selectedCar.fuel(l);
                    if (newL == -1){
                        System.err.println("Turn off the engine");}
                        else{
                            System.out.println("New fuel: " + l + "l");
                        }

                    }
                }
            }
        }
    private static int readNumber(Scanner scanner) {
        try {
            return scanner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("Enter a number!");
            return 0;
        }
    }
    private static boolean checkSelection(Car car){
if (car == null){
    System.err.println("Select a car first");
    return false;

}
return true;
    }

    }
