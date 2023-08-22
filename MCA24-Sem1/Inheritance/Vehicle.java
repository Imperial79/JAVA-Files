class Vehicle {
    protected int regnNumber = 001, speed = 100;
    protected String color = "Orange", ownerName = "Avishek";

    void showData() {
        System.out.println("This is a Vehicle Class");
        System.out.println("Regn Number: " + regnNumber);
        System.out.println("Speed: " + speed);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Color: " + color);
    }
}

class Bus extends Vehicle {
    private int routeNumber = 19;

    @Override
    void showData() {

        super.showData();
        System.out.println("Route Number: " + routeNumber);
    }
}

class Car extends Vehicle {
    private String manufacturerName = "Suzuki";

    @Override
    void showData() {

        super.showData();
        System.out.println("Manufacturer Name: " + manufacturerName);
    }
}

class Main {
    public static void main(String[] args) {
        Bus bs = new Bus();
        Car cr = new Car();

        bs.showData();
        cr.showData();
    }
}
