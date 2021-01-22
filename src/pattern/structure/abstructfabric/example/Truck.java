package pattern.structure.abstructfabric.example;

public class Truck implements Car {
    @Override
    public void go() {
        System.out.println("Едем очень медленно");
    }
}
