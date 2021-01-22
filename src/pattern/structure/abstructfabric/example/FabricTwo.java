package pattern.structure.abstructfabric.example;

public class FabricTwo implements MyFabric {
    @Override
    public Car makeCar() {
        return new SportCar();
    }

    @Override
    public Product makeProduct() {
        return new Pasta();
    }
}
