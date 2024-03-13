public class Car {
    private String brand;
   private String model;
   private int mileage = 0;
   private int fuel =0;
    private boolean engineRunning = false;
    public static final int FUEL_CAP = 100;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public Car(String line){
        String[] data = line.split("__");
        this.brand = data[0];
        this.model = data[1];
        this.mileage = Integer.parseInt(data[2]);
        this.fuel = Integer.parseInt(data[3]);

    }
    public boolean swithEngine(){
        engineRunning= !engineRunning;
        return engineRunning;

    }
    public int drive(int km)
    {
        if(!engineRunning) return -1;
        if(km < 0) km = 0;
        if(km>fuel)km=fuel;
        mileage +=km;
        fuel -=km;
        return km;
    }
    public int fuel(int l)
    {
        if(engineRunning) return -1;
        if(fuel+l>FUEL_CAP){
            fuel = FUEL_CAP;
            return fuel;
        }
        fuel += l;
        return fuel;
    }
    public int getFuel() {
        return fuel;
    }

    public String toFile(){

        return brand + "__" + model + "__" + mileage+"__"+fuel;
    }

    @Override
    public String toString() {
        return "%s %s: %skm, %sl".formatted(brand, model, mileage, fuel);
    }
}

